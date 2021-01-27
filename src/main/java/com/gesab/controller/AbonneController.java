package com.gesab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gesab.dto.ContratDto;
import com.gesab.dto.MouvementDto;
import com.gesab.entity.AbonneEntity;
import com.gesab.services.impl.AbonneServiceImpl;

@RestController
@RequestMapping("/gestionAbonne")
public class AbonneController {

	@Autowired
	private AbonneServiceImpl abonneService;

	@RequestMapping("/addAbonne")
	public AbonneEntity create(String nom, String prenom, String adresse) {
		return abonneService.createAbonne(nom, prenom, adresse);
	}

	@RequestMapping("/addContrat")
	public ContratDto addNewContrat(Integer idAbonne, String adresse) {
		return abonneService.addContrat(idAbonne, adresse);
	}

	@RequestMapping("/updateContrat")
	public Integer updateContrat(Integer idAbonne, String adresse) {
		return abonneService.updateAdress(idAbonne, adresse);
	}

	@RequestMapping("/getContrat")
	public List<ContratDto> getAllContrat(Integer idAbonne) {
		return abonneService.getContrat(idAbonne);
	}

	@RequestMapping("/getMouvement")
	public List<MouvementDto> getAllMvm(Integer idAbonne, String adresse) {
		return abonneService.getMouvement(idAbonne);
	}

}