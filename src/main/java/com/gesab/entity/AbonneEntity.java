package com.gesab.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_ABONNE")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class AbonneEntity implements Serializable {

	/**
	 * uid
	 */
	private static final long serialVersionUID = -8070236453659131566L;

	/**
	 * ID Abonne
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer identifiant;

	/**
	 * nom abonné
	 */
	@Column(name = "NOM")
	@NonNull
	private String nom;

	/**
	 * prénom abonné
	 */
	@Column(name = "PRENOM")
	@NonNull
	private String prenom;

	/**
	 * l'adresse principale de l'abonné
	 */
	@Column(name = "ADRESSE")
	@NonNull
	private String adresse;

	/**
	 * Liste des contrats.
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "abonne", fetch = FetchType.LAZY)
	private List<ContratEntity> contrats = new ArrayList<>();

}
