Feature:  Modifier l'adresse d'un abonné
Scenario: Modification de l'adresse d'un abonné résidant en France
Given un abonné identifiant: 1 avec plusieurs contrats et une adresse "france"
When le conseiller modifie l'adresse "paris" de l'abonné identifiant: 1
Then la nouvelle adresse "paris" de l’abonné identifiant: 1 est enregistrée sur l'ensemble des contrats de l'abonné
And un mouvement de modification d'adresse est créé avec la nouvelle adresse "paris"


Scenario: Modification de l'adresse d'un abonné résidant à l’international
Given un abonné identifiant: 1 avec plusieurs contrats et une adresse "international"
When le conseiller modifie l'adresse "paris" de l'abonné identifiant: 1
Then l’adresse "paris" est modifiée uniquement sur le premier contrat identfiant:1
And un mouvement de modification d'adresse est créé avec la nouvelle adresse "paris"

    