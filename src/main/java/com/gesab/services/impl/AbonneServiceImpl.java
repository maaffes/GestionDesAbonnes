package com.gesab.services.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gesab.dto.AbonneDto;
import com.gesab.dto.ContratDto;
import com.gesab.dto.MouvementDto;
import com.gesab.entity.AbonneEntity;
import com.gesab.entity.ContratEntity;
import com.gesab.entity.MouvementEntity;
import com.gesab.mapper.IAbonneMapper;
import com.gesab.persistence.repository.AbonneRepository;
import com.gesab.persistence.repository.ContratRepository;
import com.gesab.persistence.repository.MouvementRepository;
import com.gesab.services.IAbonneService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class AbonneServiceImpl implements IAbonneService {

	@Autowired
	private IAbonneMapper mapper;

	@Autowired
	private AbonneRepository abonnerepository;

	@Autowired
	private ContratRepository contratrepository;

	@Autowired
	private MouvementRepository mvmrepository;

	@Override
	@Transactional
	public AbonneEntity createAbonne(String nom, String prenom, String adresse) {
		AbonneDto abonneDto = new AbonneDto(nom, prenom, adresse);
		AbonneEntity abonneEntity = mapper.toAbonneEntity(abonneDto);
		abonnerepository.save(abonneEntity);
		return abonneEntity;
	}

	@Override
	@Transactional
	public ContratDto addContrat(Integer idAbonne, String adresse) {
		ContratEntity contratEntity = contratrepository.findByAdresse(adresse);
		AbonneEntity abonneEntity = abonnerepository.findById(idAbonne).get();
		if (contratEntity == null) {
			ContratDto contratDto = new ContratDto(adresse);
			contratDto.setAbonne(mapper.toAbonneDto(abonneEntity));
			ContratEntity contratEntitymap = mapper.tocontratEntity(contratDto);
			contratrepository.save(contratEntitymap);
			return contratDto;
		}
		return null;
	}

	@Override
	@Transactional
	public Integer updateAdress(Integer idAbonne, String adresse) {
		Date today = Calendar.getInstance().getTime();
		AbonneEntity abonneEntity = abonnerepository.findById(idAbonne).get();
		List<ContratEntity> contratEntity = contratrepository.findByIdentifiant(idAbonne);
		if (!abonneEntity.getAdresse().contains("france")) {
			contratEntity.get(0).setAdresse(adresse);
			contratrepository.saveAll(contratEntity);
			MouvementDto mvmDto = new MouvementDto(idAbonne, contratEntity.get(0).getIdentifiant(), "Modification",
					today.toString(), adresse, contratEntity.get(0).getAdresse());
			MouvementEntity mvmEntity = mapper.toMvmEntity(mvmDto);
			mvmrepository.save(mvmEntity);
		} else {
			for (int i = 0; i < contratEntity.size(); i++) {
				contratEntity.get(i).setAdresse(adresse);
				contratrepository.saveAll(contratEntity);

				MouvementDto mvmDto = new MouvementDto(idAbonne, contratEntity.get(i).getIdentifiant(), "Modification",
						today.toString(), adresse, contratEntity.get(i).getAdresse());
				MouvementEntity mvmEntity = mapper.toMvmEntity(mvmDto);
				mvmrepository.save(mvmEntity);
			}
		}
		abonneEntity.setAdresse(adresse);
		abonnerepository.save(abonneEntity);
		return 1;
	}

	@Override
	@Transactional
	public List<ContratDto> getContrat(Integer idAbonne) {
		List<ContratEntity> contratEntity = contratrepository.findByIdentifiant(idAbonne);
		return contratEntity.stream().map(e -> mapper.toContratDto(e)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<MouvementDto> getMouvement(Integer idAbonne) {
		List<MouvementEntity> mvmEntity = mvmrepository.findMvmByIdentifiant(idAbonne);
		return mvmEntity.stream().map(e -> mapper.toMvmDto(e)).collect(Collectors.toList());
	}
}