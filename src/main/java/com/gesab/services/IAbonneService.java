package com.gesab.services;

import java.util.List;
import com.gesab.dto.AbonneDto;
import com.gesab.dto.ContratDto;
import com.gesab.dto.MouvementDto;
import com.gesab.entity.AbonneEntity;




public interface IAbonneService {

	public AbonneEntity createAbonne(String nom, String prenom, String adresse);
	public ContratDto addContrat(Integer idAbonne, String adresse);
	public Integer updateAdress(Integer idAbonne, String adresse);
	public List<ContratDto> getContrat(Integer idAbonne);
	public List<MouvementDto> getMouvement(Integer idAbonne);

}