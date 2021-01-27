package com.gesab.mapperIMpl;

import org.springframework.stereotype.Service;

import com.gesab.dto.AbonneDto;
import com.gesab.dto.ContratDto;
import com.gesab.dto.MouvementDto;
import com.gesab.entity.AbonneEntity;
import com.gesab.entity.ContratEntity;
import com.gesab.entity.MouvementEntity;
import com.gesab.mapper.IAbonneMapper;

@Service
public class AbonneMapperImpl implements IAbonneMapper {

	@Override
	public AbonneEntity toAbonneEntity(AbonneDto abonneDto) {
		if (abonneDto == null) {
			return null;
		}

		AbonneEntity abonneEntity = new AbonneEntity(abonneDto.getNom(), abonneDto.getPrenom(), abonneDto.getAdresse());
		abonneEntity.setIdentifiant(abonneDto.getIdAbonne());
		return abonneEntity;
	}

	@Override
	public AbonneDto toAbonneDto(AbonneEntity abonneEntity) {
		if (abonneEntity == null) {
			return null;
		}
		AbonneDto abonneDto = new AbonneDto(abonneEntity.getNom(), abonneEntity.getPrenom(), abonneEntity.getAdresse());
		abonneDto.setIdAbonne(abonneEntity.getIdentifiant());
		return abonneDto;
	}

	@Override
	public ContratEntity tocontratEntity(ContratDto contratDto) {
		if (contratDto == null) {
			return null;
		}

		ContratEntity contratEntity = new ContratEntity(contratDto.getAdresse());
		contratEntity.setIdentifiant(contratDto.getIdContrat());
		contratEntity.setAbonne(toAbonneEntity(contratDto.getAbonne()));
		return contratEntity;
	}

	@Override
	public ContratDto toContratDto(ContratEntity contratEntity) {

		if (contratEntity == null) {
			return null;
		}

		ContratDto contratDto = new ContratDto(contratEntity.getAdresse());
		contratDto.setAbonne(toAbonneDto(contratEntity.getAbonne()));
		return contratDto;

	}

	@Override
	public MouvementEntity toMvmEntity(MouvementDto mvmDto) {

		if (mvmDto == null) {
			return null;
		}
		MouvementEntity mvmEntity = new MouvementEntity(mvmDto.getIdAbonne(), mvmDto.getIdContrat(),
				mvmDto.getTypeMvn(), mvmDto.getDateMvn(), mvmDto.getNewVal(), mvmDto.getOldVal());
		return mvmEntity;

	}

	@Override
	public MouvementDto toMvmDto(MouvementEntity mvmEntity) {
		if (mvmEntity == null) {
			return null;
		}

		MouvementDto mvmDto = new MouvementDto(mvmEntity.getIdAbonne(), mvmEntity.getIdContrat(),
				mvmEntity.getTypeMvn(), mvmEntity.getDateMvn(), mvmEntity.getNewVal(), mvmEntity.getOldVal());

		return mvmDto;
	}

}