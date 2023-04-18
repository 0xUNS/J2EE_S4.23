# TPs J2EE

Activité 1 : Inversion de contrôle & Injection des dépendances
- **TP1 :** Couplage fort & Couplage faible, Injection des dépendances - statique & dynamique -
- **TP2 :** Mini Framework - Injection des dépendances en Annotations & XML (fichier de configuration)

Activité 2 : Mapping Objet relationnel - JPA Hibernate & Spring Data
- **JPA-app :** Ajouter les dépendances JPA, H2, Spring Web et Lombock, création d'une entité JPA `Patient (id, nom, dateNaissance, malade, score)`, configuration du fichier _application.properties_, tester les opérations **CRUD**, migrer de H2 Database vers MariaDB
- **Hospital :** Utiliser plusieur entités JPA `Patient`, `Medecin`, `RendezVous`, `Consultation` , manipuler les relations **[1..1]** & **[1..*]**
- **JPA-user-role :** Example d'une relation **Many To Many** avec deux entités JPA `User` & `Role`

Activité 3 : Spring MVC avec Thymeleaf
- **patients-mvc :** Application Web JEE basée sur Spring MVC, Thylemeaf et Spring Data JPA, gérer les patients avec les opérations **CRUD**

