# Cinémathèque sécurisée avec JWT

Il s'agit d'une ébauche d'application créée avec Spring boot et Angular pour aider à comprendre l'utilisation des tokens JWT comme méchanisme d'authentification.

Le but de l'application est de recenser des films qu'on pourrait avoir dans une cinémathèque.

## Application parente Maven

Ici, nous avons une application Maven parente dont les parties backend et frontend sont des modules. On utilise la puissance de Maven pour générer un fat jar avec notre application Angular compilée comme ressource de notre application Spring boot. Ainsi, on peut lancer notre application directement en utilisant la commande `java -jar cinema-app-api-1.0.0.jar`.

## Backend Spring boot

Côté backend, il y a une structure d'API REST construite avec Spring boot. Cette API est sécurisée avec Spring Security et JWT.

L'API permet de :

- Gérer les utilisateurs (création de compte, authentification, récupération de la liste des utilisateurs).
- Gérer les catégories de film (récupération de la liste des catégories de film, création d'une nouvelle catégorie de film).
- Gérer les films (récupération de la liste des films, création d'un nouveau film).

Quelques roles ont été définis dans l'API : `ROLE_ADMIN`, `ROLE_CREATOR`, `ROLE_READER`.

Les accès aux fonctionnalités sont définis de la manière suivante :

- La création de compte et l'authentification sont accessibles à n'importe qui.
- Les fonctions de récupération de liste sont accessible aux utilisateurs authentifiés.
- Les fonctions de création sont accessibles aux utilisateurs avec le `ROLE_ADMIN` ou `ROLE_CREATOR`.
- Les fonctions de récupération d'informations sur les utilisateurs sont réservées au `ROLE_ADMIN`.

## Frontent Angular

Côté frontend, il y a une SPA minimaliste qui permet de :

- S'authentifier à l'API.
- Récupérer la liste de films.
- Récupérer la liste de catégories de film.

Les accès aux pages sont définis de la manière suivante :

- Seule la page de login est visible si l'utilisateur n'est pas authentifié.
- Les pages de liste sont visibles aux utilisateurs authentifiés.
- Les pages de création sont visibles aux utilisateurs avec le `ROLE_ADMIN` ou `ROLE_CREATOR`.
- Les pages de récupération d'informations sur les utilisateurs sont réservées au `ROLE_ADMIN`.

## Actions à réaliser

Votre mission si vous l'acceptez :

- Rajouter la création de compte côté frontend.
- Rajouter la création de film côté frontend.
- Rajouter la création de catégorie côté frontend.
- Rajouter la modification de compte côté frontend et backend (devra être réservée au `ROLE_ADMIN`).
- Rajouter la modification de film côté frontend et backend (devra être réservée au `ROLE_ADMIN` ou `ROLE_CREATOR`).
- Rajouter la modification de catégorie côté frontend et backend (devra être réservée au `ROLE_ADMIN` ou `ROLE_CREATOR`).
- Commenter proprement la partie frontend.