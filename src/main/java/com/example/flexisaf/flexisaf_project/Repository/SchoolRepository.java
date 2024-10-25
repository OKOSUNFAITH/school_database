package com.example.flexisaf.flexisaf_project.Repository;

import com.example.flexisaf.flexisaf_project.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {
    School findByEmail(String email);

    void delete(Optional<School> school);
}
