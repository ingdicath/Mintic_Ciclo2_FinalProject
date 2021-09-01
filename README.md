# PetStoreDiDi

Final project software development using MVC and JDBC, as a part of the curriculum Mintic 2022 Cycle II.

- **Project type**: Desktop application using Database, CRUD operations.
- **Objective**: Develop a desktop application using MVC and JDBC.

This is a group project completed by [Diego Maldonado](https://github.com/dialejo) & [Diana Salamanca](https://github.com/ingdicath)
<br >_Funny fact_: The name of the Pet Store is composed of the first syllable of our names.

---

## Requirements :pushpin:

For this project, we used **mysql 8.0.26**, **Java 8** and **Netbeans** IDE. 

Before start, be sure you setup the basic tools for running java and sql:

1. SQL: 
	- Install [mysql](https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/) in your pc.
	- It is highly recommended download [MSQLWorkBench](https://dev.mysql.com/downloads/workbench/), [DBeaver](https://dbeaver.io/download/) or any other SQL editor of your choice.

2. Java:
	- Install [Java](https://www.oracle.com/java/technologies/javase-downloads.html) and JDK.
	- Install an IDE like Netbeans, IntelliJ or any other IDE of your choice.
	- JDBC component, for [connection between sql and Java](https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/tree/main/PetStoreDiDi/lib). 


---

## Design process :bulb:

1. We created a database in SQL through a [script](https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/PetStoreDiDi/src/util/db_creation.sql), building tables and records from scratch.

2. We verified if the Entity-relationship (ER) diagram was correct according to our design, using the _Reverse Engineer_ option provided by _MySQLWorkBench_.
<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/ER_mysql.png" width="60%" height="60%"></p>

In this case, the relation between "propietario" and "mascota" is __one to many__, it means one "propietario" or owner can holder many "mascotas" or pets.
In the same way, the relation between "mascota" and "cita" is also __one to many__, it means one "mascota" or pet can holder many "citas" or appointments.

3. Having the database, we created the files (packages and classes) for the project. We designed our project based on three-layers architecture MVC.
<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/mvc.png" width="60%" height="60%"></p>


4. We have six packages in total:

- **Controller**: this is the bridge between the view and the model, in this case, for the pet summary and the owner. Here are the click events for each button in the app defined as well.
- **dao**: contains DAO for owner and pet summary.
- **main**: contains the main. Running this file allows to see the app.
- **model**: contains the model for owner and pet summary.
- **util**: where the user needs to set up the parameters for the connection to the SQL database and where the connection is established as well.
- **view**: where is set up the Frame and Panel features for the main window, Owner and Pet summary.

<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/packages.png" width="40%" height="40%"></p>

---
## How to use :hammer:

1. Clone the repository in your local machine.
2. Open a new project in your IDE and copy the folder ```src```.
3. Add into ```Libraries``` the ```mysql-connector-java-8.0.26.jar``` file, located in this repo in [lib folder](https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/tree/main/PetStoreDiDi/lib).
<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/mysql-conector-java.png" width="40%" height="40%"></p>

4. Go to package ```main``` and run ```PetStoreDiDi.java```.



----
## Outputs 😎

### 1. Windows

- **Main Window PetStore DiDi**, where the user can visualize a summary of pets with some basic information like ```Pet Id```, ```Pet Name```, ```Owner last name``` and pet number of ```appointments```.

<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/main_window.png" width="70%" height="70%"></p>

- **Owner Window**, where the user can add or delete an owner.

<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/owner_window.png" width="50%" height="50%"></p>


### 2. Actions

- **Search a pet**: The user can search by exact coincidence or just using a character or a group of it to perform this action.
<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/search_pet.png" width="70%" height="70%"></p>

- **Create a new owner**
<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/create_new_owner.png" width="50%" height="50%"></p>

- **Delete an owner**: It is required to select the entire row to perform this action.
<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/delete_owner.png" width="60%" height="60%"></p>
<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/record_deleted.png" width="40%" height="40%"></p>

### 3. Errors

When an error occurs, there are some message boxes that are displayed to warn the user about it

- **Adding a new owner**: Error when the ```Username```, ```Owner Last name```, or ```Owner First name``` fields are empty.
<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/error_null.png" width="42%" height="42%"></p>

- **Searching a pet**: Error when the pet doesn't exist in the Pet Store database.
<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/error_pet_doesnt_exist.png" width="70%" height="70%"></p>

- **Deleting an owner who owns a pet.**: An owner must not have pets at the time of being removed from the database.
<p align="center"><img src="https://github.com/ingdicath/Mintic_Ciclo2_FinalProject/blob/main/images/error_owner_with_pet.png" width="100%" height="100%"></p>


