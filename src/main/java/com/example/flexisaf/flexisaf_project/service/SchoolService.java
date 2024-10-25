package com.example.flexisaf.flexisaf_project.service;

import com.example.flexisaf.flexisaf_project.entity.School;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SchoolService {
    School createSchool(School school);
    List<School> getAllSchool();
    Optional<School> getSchoolById(Long id);
    void deleteSchool(Long id);
    public School updateSchool(Long id, School school);


}
