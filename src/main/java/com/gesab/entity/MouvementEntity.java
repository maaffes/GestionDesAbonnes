package com.gesab.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_MOUVEMENT")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class MouvementEntity implements Serializable {

	/**
	 * uid
	 */
	private static final long serialVersionUID = -8070236453659131566L;

	/**
	 * ID mouvement
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer identifiant;

	/**
	 * ID abonné
	 */
	@Column(name = "ID_ABONNE")
	@NonNull
	private Integer idAbonne;

	/**
	 * ID Contrat
	 */
	@Column(name = "ID_CONTRAT")
	@NonNull
	private Integer idContrat;

	/**
	 * Type de moucement
	 */
	@Column(name = "TYPE_MOUVEMENT")
	@NonNull
	private String TypeMvn;

	/**
	 * Date de mouvement
	 */
	@Column(name = "DATE_MOUVEMENT")
	@NonNull
	private String dateMvn;

	/**
	 * nouveau mouvement
	 */
	@Column(name = "NEW_VAL")
	@NonNull
	private String newVal;

	/**
	 * ancien mouvement
	 */
	@Column(name = "OLD_VAL")
	@NonNull
	private String oldVal;

}
