package com.gesab.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class MouvementDto {

	/**
	 * ID mouvement
	 */

	private Integer identifiant;

	/**
	 * ID abonné
	 */
	@NonNull
	private Integer idAbonne;

	/**
	 * ID Contrat
	 */
	@NonNull
	private Integer idContrat;

	/**
	 * Type de mouvement
	 */
	@NonNull
	private String TypeMvn;

	/**
	 * Date de mouvement
	 */
	@NonNull
	private String dateMvn;

	/**
	 * nouveau mouvement
	 */
	@NonNull
	private String newVal;

	/**
	 * ancien mouvement
	 */
	@NonNull
	private String oldVal;

}
