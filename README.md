# IT Equipment Management System

## Contexte du projet
En tant que développeur full stack Java/Angular dans la société ITSolutions, vous êtes chargé de concevoir et de développer un système de gestion des équipements informatiques. Ce système vise à gérer efficacement les équipements, les pannes et les tickets de support, tout en offrant des fonctionnalités avancées telles que des rapports et des statistiques pour une meilleure gestion.

## User Stories

### Gestion des Équipements Informatiques
- **En tant qu'administrateur IT**, je veux pouvoir ajouter de nouveaux équipements informatiques au système afin de suivre leur état et leur utilisation.
- **En tant qu'administrateur IT**, je veux pouvoir modifier les informations des équipements existants pour maintenir des données à jour.
- **En tant qu'administrateur IT**, je veux pouvoir supprimer des équipements obsolètes ou hors service pour garder le système organisé.
- **En tant qu'administrateur IT**, je veux pouvoir voir une liste de tous les équipements avec leur état actuel pour une gestion efficace.

### Gestion et Suivi des Pannes
- **En tant qu'administrateur IT**, je veux pouvoir faire la gestion (ajouter, modifier, supprimer) des pannes.
- **En tant qu'administrateur IT**, je veux pouvoir consulter l'historique des pannes pour chaque équipement afin d'identifier les équipements problématiques.

### Gestion des Tickets de Support
- **En tant qu'utilisateur**, je veux pouvoir créer un ticket de support pour signaler une panne afin de recevoir de l'aide.
- **En tant qu'administrateur IT**, je veux pouvoir attribuer les tickets de support aux techniciens disponibles pour une résolution rapide.
- **En tant que technicien IT**, je veux pouvoir voir les tickets qui me sont attribués pour les traiter efficacement.
- **En tant qu'utilisateur**, je veux pouvoir suivre l'état de mon ticket de support pour savoir quand mon problème sera résolu.


## Fonctionnement

- **Historique des Pannes**: Conserve un enregistrement détaillé de toutes les pannes passées pour chaque équipement. Chaque entrée dans l'historique est liée à un équipement, permettant ainsi de garder une trace des problèmes rencontrés et des réparations effectuées.
- **Tickets de Support**: Créés par les utilisateurs lorsqu'ils rencontrent des problèmes avec les équipements. Chaque ticket est lié à un utilisateur spécifique, ce qui permet de suivre qui a signalé le problème et de maintenir une communication efficace.
- **Attribution des Tickets**: Une fois un ticket de support créé, il est attribué à un technicien pour résolution. Cette relation permet de suivre quel technicien est responsable de la résolution du problème et d'évaluer les performances des techniciens en fonction des tickets résolus.

## Technologies Utilisées
- **Backend**: Spring Boot, Spring Data JPA, Spring Security
- **Frontend**: Angular 16
- **Base de données**: PostgreSQL / MySQL
- **Test unitaire**: JUnit
- **Conteneurisation**: Docker

## Conception Diagrams


- **Diagramme UML**:
- <img width="548" alt="ITDaigrame de class" src="https://github.com/user-attachments/assets/3b08a080-1281-4f70-87b5-f1a9718f20e6">

- **Diagramme de Séquence**:
- <img width="426" alt="ITDaigrame de Séquence" src="https://github.com/user-attachments/assets/e5731d66-1733-42fe-8f12-29575e27a5e6">

- **Diagramme de Cas d'Utilisation**:


