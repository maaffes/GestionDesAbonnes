package com.gesab.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_CONTRAT")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ContratEntity implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 5925464069341380386L;

	/**
	 * ID contrat
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer identifiant;

	/**
	 * l'adresse principale du contrat
	 */
	@Column(name = "ADRESSE")
	@NonNull
	private String adresse;

	/**
	 * Abonne.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ABONNE")
	private AbonneEntity abonne;

}
