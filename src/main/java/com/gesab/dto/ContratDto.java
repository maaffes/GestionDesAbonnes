package com.gesab.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.gesab.entity.ContratEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ContratDto {

	/**
	 * ID Contrat
	 */
	private Integer idContrat;

	/**
	 * adresse
	 */
	@NonNull
	private String adresse;

	/**
	 * abonné
	 */
	private AbonneDto abonne;

}
