CREATE TABLE schools (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(200) NOT NULL,
    phone_number VARCHAR(20),
    email VARCHAR(100) NOT NULL UNIQUE,
    principal_name VARCHAR(100),
    foundation_year INT,
    total_students INT,
    total_staff INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);