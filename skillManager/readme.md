# SII JAVA - SKILL MANAGER

## I. INFORMATION

- Update date : 09/02/2015
- Project summary : This project manage the skills of people, generate CV, ... 

## II. RELEASE CHANGES:

- #Collab1 : Ajouter un champ "email"
- #CV13	: Renommer "Technologies mission" par "Activité mission"
- #Skill1 : Ajouter la notion de "CATEGORY" (une catégorie inclus plusieurs items, un item peu appartenir à 0 ou 1 catégorie)
- #Skill2 : Compétences	Regrouper les skill par CATEGORY


## III. RELEASE PACKAGE

- maven build: mvn clean install


## IV. DEPLOYMENT

### 4.1. PRE-REQUISES:
	- Galssfish 3.1
	- MySQL 5
	- jdk-1.6
	
### 4.2. DEPLOYMENT INSTRUCTIONS
	- Step 1: Prepare database
		+ run /script/skillManager_create_tbl.sql
	- Step 2: Prepare for glassfish server
		+ deploy application to glassfish server
		
## V. DOCUMENTATION

- The documentation concerning the main purpose of the project : /docs/NoteTechnique_a.doc
- The CV documentation in order to generate a new CV by the application : 
-- CVSII : main template
-- expClient : template of the client part
-- formation : template of the formation part
- The todo list of elements to treats are available on : https://docs.google.com/spreadsheets/d/1EKKx911FFUOiQMiCGIYqe6vj2JGSDF3ESW-OKWjDRts/edit?usp=sharing
-- Please ask to adierick@sii.fr to add user to share.



