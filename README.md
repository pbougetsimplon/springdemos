# Découverte de SpringBoot : Solutions (session 3)

## Springdemo01 (Standalone)

Afficher un message dans la console avec Spring.

## Springdemo02 (Web)

Afficher un message dans un navigateur avec Spring.

## Springdemo03 (Web & RestController)

Afficher une liste d'objets au format JSON dans un navigateur avec Spring.

## Springdemo04 (JDBC - DAO - CRUD - JdbcTemplate)

Cette version démo utilise encore des requêtes SQL à l'aide de JdbcTemplate. ça permet de réviser le SQL pour le CRUD !

Accéder à la table Pilote dans la base de données bd-avion et exécuter les tâches suivantes (toujours dans la console) :

- Lister tous les pilotes
- Rechercher un pilote par nom comme "Elodie"
- Ajouter 2 nouveaux Pilotes
- Modifier le site d'un Pilote
- Supprimer le dernier Pilote

Il y a 2 versions de la méthode pour ajouter un pilote :

- Version non commentée en supposant que la clef primaire `PI_ID` de la table pilote est **auto-générée**
- Version commentée à utiliser si votre clef primaire `PI_ID`n'est pas auto-générée (Atttention, dans ce cas la méthode ne doit pas retourner un int !)  

## Spring-hibernate (Web - RestController - JPA - Hibernate)

Dans cet exemple, vous avez 2 classes **@Entity** : 

- Apprenant
- Region

Vous pouvez lister tous les apprenants ou toutes les régions au format JSON dans un navigateur.

Vous pouvez rechercher un apprenant par son **id**

Cette exemple permet de découvrir comment simplifier l'accès à la base de données grâce aux annotations.

## Spring pratique01 (Web - Spring - HYML - JSON - AJAX)

Autre démo basique