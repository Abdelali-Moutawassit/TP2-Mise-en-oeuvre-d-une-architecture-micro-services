<h1 align="center" style="color: #2C3E50;">Welcome to Mise en oeuvre d'une architecture micro-services 👋</h1>
<p align="center">
  <a href="https://twitter.com/AbdelaliMoutawassit" target="_blank">
    <img alt="Twitter: AbdelaliMoutawassit" src="https://img.shields.io/twitter/follow/AbdelaliMoutawassit.svg?style=social" />
  </a>
</p>

> <p style="color: #34495E;">Ce projet implémente un système de gestion des factures basé sur une architecture micro-services, permettant une séparation claire des préoccupations et une extensibilité accrue. L'application est conçue pour gérer les factures qui contiennent des produits appartenant à des clients, offrant ainsi une solution complète pour les besoins de facturation.</p>

<h2 style="color: #2980B9;">Objectifs du Projet</h2>
<ul style="color: #34495E;">
  <li><strong>Gestion des Clients :</strong> Créer et gérer les informations relatives aux clients, y compris leurs détails de contact et l'historique des factures.</li>
  <li><strong>Gestion des Produits :</strong> Permettre l'ajout, la modification et la suppression de produits dans l'inventaire, avec des détails tels que le nom, le prix et la quantité disponible.</li>
  <li><strong>Facturation :</strong> Gérer la création de factures basées sur les produits sélectionnés par le client, en intégrant les informations client et produit.</li>
  <li><strong>Communication entre Services :</strong> Utiliser des API REST pour permettre une interaction fluide entre les différents micro-services, tels que Customer Service, Inventory Service, et Billing Service.</li>
  <li><strong>Scalabilité et Maintenance :</strong> Faciliter la scalabilité du système et la maintenance en séparant chaque fonctionnalité en un micro-service distinct, permettant ainsi une gestion simplifiée et une évolution rapide des services.</li>
</ul>

<h2 style="color: #27AE60;">Technologies Utilisées</h2>
<ul style="color: #34495E;">
  <li><strong>Backend :</strong> Java, Spring Boot, Spring Data, Spring Cloud, Netflix Eureka pour la découverte des services et Open Feign pour la communication entre micro-services.</li>
  <li><strong>Frontend :</strong> Angular pour le développement d'une application cliente dynamique qui interagit avec les services backend.</li>
  <li><strong>Base de données :</strong> [Indiquer la base de données utilisée, par exemple MySQL, MongoDB].</li>
</ul>

<h2 style="color: #E67E22;">Avantages de l'Architecture Micro-services</h2>
<ul style="color: #34495E;">
  <li><strong>Modularité :</strong> Chaque service peut être développé, déployé et mis à jour indépendamment, facilitant l'introduction de nouvelles fonctionnalités sans affecter l'ensemble du système.</li>
  <li><strong>Résilience :</strong> En cas de défaillance d'un service, les autres services peuvent continuer à fonctionner, améliorant ainsi la fiabilité de l'application.</li>
  <li><strong>Scalabilité :</strong> Chaque service peut être mis à l'échelle individuellement en fonction de la demande, optimisant l'utilisation des ressources.</li>
</ul>

<h2 style="color: #8E44AD;">Author</h2>
<p style="color: #34495E;">
  👤 <strong>Abdelali Moutawassit</strong><br>
  * Website: [AbdelaliWEB.moutawassit](http://AbdelaliWEB.moutawassit)<br>
  * Twitter: [@AbdelaliMoutawassit](https://twitter.com/AbdelaliMoutawassit)<br>
  * Github: [@Abdelali-Moutawassit](https://github.com/Abdelali-Moutawassit)<br>
  * LinkedIn: [@Moutawassit Abdelali](https://linkedin.com/in/Moutawassit-Abdelali)
</p>

<h2 style="color: #C0392B;">Installation</h2>
<p style="color: #34495E;">Pour installer le projet, exécutez les commandes suivantes :</p>

```bash
# Installer les dépendances et compiler les micro-services
mvn clean install

# Exécuter chaque micro-service dans son propre terminal
cd customer-service && mvn spring-boot:run
cd inventory-service && mvn spring-boot:run
cd gateway-service && mvn spring-boot:run
cd registry-service && mvn spring-boot:run
cd billing-service && mvn spring-boot:run
