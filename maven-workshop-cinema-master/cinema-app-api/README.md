# Tests unitaires SpringBoot

## Notions de base

### Tests Unitaires, tests d'intégration, Mock

> Test Unitaire : permet de vérifier qu'une méthode prise individuellement, fait correctement ce qu'elle est supposée faire.

> Test d'Intégration : permet de démontrer que les différentes parties d'une application fonctionnent correctement ensemble
 (nécessite un jeu de données important).
 
> Mocks : Simulacres d'objets réels !

> Matcher : 

### Mockito (framework java permettant d'utiliser des Mocks)

**AssertJ** and **Mockito** sont automatiquement accessible grâce à la dépendance __spring-boot-starter-test__.

### Tester les méthodes d'un contrôleur (Test Unitaire)

Etapes :

- Isoler le contrôleur
- Mocker la logique métier
- Appeler les méthodes du contrôleur
- Vérifier les réponses

Ce que ne permet pas le test unitaire :

- Ecoute des réponses HTTP(@PostMapping)
- Désérialisation des objets en entrée (@RequestParam, @PathVAriable)
- Validation des entrées (@Valid)
- Sérialiser des objets HTTP en sortie
- Traduire les exceptions

La couche HTTP n'est donc pas couverte par les tests Unitaires.

