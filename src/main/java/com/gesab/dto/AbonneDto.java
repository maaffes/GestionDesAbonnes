package com.gesab.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class AbonneDto {

	/**
	 * ID Abonne
	 */
	private Integer idAbonne;

	/**
	 * nom
	 */
	@NonNull
	private String nom;

	/**
	 * prenom
	 */
	@NonNull
	private String prenom;

	/**
	 * adresse
	 */
	@NonNull
	private String adresse;

	/**
	 * Contrat
	 */
	private List<ContratDto> contrats;

}
