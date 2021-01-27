package com.gesab;

import org.springframework.beans.factory.annotation.Autowired;

import com.gesab.services.impl.AbonneServiceImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;


public class SubscriberStepDefinitions extends GestionAbonneApplicationTests {
	@Autowired
	private AbonneServiceImpl abonneService;

	@Given("un abonné identifiant: {int} avec plusieurs contrats et une adresse {string}")
	public void un_abonné_avec_plusieurs_contrats_et_une_adresse_principale_en_france(Integer identifiant,String adresse) {
	}

	@When("le conseiller modifie l'adresse {string} de l'abonné identifiant: {int}")
	public void le_conseiller_modifie_l_adresse_de_l_abonné_identifiant(String adresse, Integer idAbonne) {
// 		return abonneService.updateAdress(idAbonne, adresse);
	}

	@Then("la nouvelle adresse {string} de l’abonné identifiant: {int} est enregistrée sur l'ensemble des contrats de l'abonné")
	public void la_nouvelle_adresse_de_l_abonné_identifiant_est_enregistrée_sur_l_ensemble_des_contrats_de_l_abonné(String string, Integer int1) {
		assertEquals("s", "s");
	}

	@Then("un mouvement de modification d'adresse est créé avec la nouvelle adresse {string}")
	public void un_mouvement_de_modification_d_adresse_est_créé_avec_la_nouvelle_adresse(String string) {
		assertEquals("s", "s");
	}
	
	
	@Given("un abonné avec plusieurs contrats et une adresse principale à l’international")
	public void un_abonné_avec_plusieurs_contrats_et_une_adresse_principale_à_l_international() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

		
	@Then("l’adresse {string} est modifiée uniquement sur le premier contrat identfiant:{int}")
	public void l_adresse_est_modifiée_uniquement_sur_le_premier_contrat_identfiant(String string, Integer int1) {
		assertEquals("s", "s");
	}
}
