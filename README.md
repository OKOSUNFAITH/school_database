SCHOOL DATABASE PROJECT

This project demonstrates the use of Hibernate annotations to design a database table (entity) for a School, with at least 10 fields. It also includes database migration using mySql


PROJECT OVERVIEW

This project creates a School entity with various attributes such as name, address, contact information, and other relevant details. It uses Hibernate annotations to map the entity to a database table and mysql for database migration.

TECHNOLOGIES USED

Java
Hibernate
Spring Boot
MySQL 

SCHOOL ENTITY
The School entity is designed with the following fields:

id (Long)
name (String)
address (String)
phoneNumber (String)
email (String)
principalName (String)
foundationYear (Integer)
totalStudents (Integer)
totalStaff (Integer)
createdAt (LocalDateTime)


Important Hibernate annotations used include:

@Entity
@Table
@Id
@GeneratedValue
@Column
@CreationTimestamp


DATABASE MIGRATION

This project uses MYSQL for database migration. The initial migration script creates the schools table with all the necessary fields.
Setup and Installation

Clone the repository:
Copygit clone https://github.com/OKOSUNFAITH/school_database.git

Navigate to the project directory:
Copy cd school_database

Update application.properties with your database credentials.
Run the application:
Copy./mvnw spring-boot:run


