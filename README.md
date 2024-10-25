                        SCHOOL DATABASE PROJECT
This project demonstrates building a complete Spring Boot application for managing school data, featuring Hibernate annotations,
MySQL database integration, Flyway migrations, and a full service layer with dependency injection.

PROJECT OVERVIEW
This project implements a complete REST API for managing school records, including:

School entity with various attributes
Repository layer for data access
Service layer with dependency injection
REST controllers for 5 API endpoints
Database migration using Flyway
Proper error handling

TECHNOLOGIES USED

Java
Spring Boot
Spring Data JPA
Hibernate
MySQL
Flyway

ARCHITECTURE

1. Entity Layer
   The School entity includes the following fields:

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

Important annotations used:

@Entity
@Table(name = "schools")
@Column
@Id
@GeneratedValue
@CreationTimestamp

2. Repository Layer
 @Repository
   public interface SchoolRepository extends JpaRepository<School, Long> {
   Optional<School> findByEmail(String email);
   }

3. Service Layer
   The service layer implements business logic with dependency injection:
   @Service
   public class SchoolServiceImpl implements SchoolService {
   private final SchoolRepository schoolRepository;

  ## Constructor injection
   public SchoolServiceImpl(SchoolRepository schoolRepository) {
   this.schoolRepository = schoolRepository;
   }

  ## CRUD operations

   public School createSchool(School school) {
   return schoolRepository.save(school);
   }

   public School getSchoolById(Long id) {
   return schoolRepository.findById(id)
   .orElseThrow(() -> new RuntimeException("School not found with id: " + id));
   }

   public School updateSchool(Long id, School schoolDetails) {
   School school = getSchoolById(id);

        school.setName(schoolDetails.getName());
        school.setAddress(schoolDetails.getAddress());
        school.setPhoneNumber(schoolDetails.getPhoneNumber());
        school.setEmail(schoolDetails.getEmail());
        school.setPrincipalName(schoolDetails.getPrincipalName());
        school.setFoundationYear(schoolDetails.getFoundationYear());
        school.setTotalStudents(schoolDetails.getTotalStudents());
        school.setTotalStaff(schoolDetails.getTotalStaff());
        
        return schoolRepository.save(school);
   }
   }
  ## DATABASE MIGRATION

   This project uses Flyway to manage database migrations. Migration files are located in:
   src/main/resources/db/migration
   Example migration file (V1__Create_schools_table.sql):
   CREATE TABLE schools (
   id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(100) NOT NULL,
   address VARCHAR(200) NOT NULL,
   phone_number VARCHAR(20),
   email VARCHAR(100) NOT NULL UNIQUE,
   principal_name VARCHAR(100),
   foundation_year INT,
   total_students INT,
   total_staff INT,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (id)
   );

SETUP AND INSTALLATION

Clone the repository:

bash-git clone https://github.com/OKOSUNFAITH/school_database.git

Navigate to the project directory:

cd school_database

Configure your database connection in application.properties:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/school_database
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true

Run the application:
./mvnw spring-boot:run

API ENDPOINTS

GET /api/schools - Get all schools
GET /api/schools/{id} - Get a specific school
POST /api/schools - Create a new school
PUT /api/schools/{id} - Update a school
DELETE /api/schools/{id} - Delete a school

SETUP AND INSTALLATION
Clone the repository:

git clone https://github.com/OKOSUNFAITH/school_database.git
Navigate to the project directory:

cd school_database
Update application.properties with your database credentials.

Run the application:
./mvnw spring-boot:run
This will automatically run Flyway migrations and set up the database schema.




