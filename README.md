SCHOOL DATABASE PROJECT

This project demonstrates using Hibernate annotations to design a database table (entity) for a School, with at least 10 fields. 
It also includes database migration using MySQL and Flyway to manage the database schema's version control.

PROJECT OVERVIEW

This project creates a School entity with various attributes such as name, address, contact information, and other relevant details. It uses Hibernate annotations to map the entity to a database table .It also includes database migration using MySQL and Flyway to manage the database schema's version control.

TECHNOLOGIES USED

Java
Hibernate
Spring Boot
MySQL
flyway

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
This project uses Flyway to manage database migration. The initial migration script (V1__Create_schools_table.sql) creates the school's table with all the necessary fields.

Flyway ensures that the database schema is kept in sync with the application by applying versioned migrations in SQL scripts.

Migration Directory:
The migration files are located in:

src/main/resources/db/migration
Example migration file:
sql
Copy code
CREATE TABLE schools (
id BIGINT NOT NULL AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
address VARCHAR(255),
phone_number VARCHAR(20),
email VARCHAR(255),
principal_name VARCHAR(255),
foundation_year INT,
total_students INT,
total_staff INT,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (id)
);
SETUP AND INSTALLATION
Clone the repository:

git clone https://github.com/OKOSUNFAITH/school_database.git
Navigate to the project directory:

cd school_database
Update application.properties with your database credentials.

Run the application:
./mvnw spring-boot:run
This will automatically run Flyway migrations and set up the database schema for you.

Clone the repository:
Copygit clone https://github.com/OKOSUNFAITH/school_database.git

Navigate to the project directory:
Copy cd school_database




