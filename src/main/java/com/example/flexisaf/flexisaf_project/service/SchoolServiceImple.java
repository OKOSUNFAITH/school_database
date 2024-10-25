package com.example.flexisaf.flexisaf_project.service;

import com.example.flexisaf.flexisaf_project.Repository.SchoolRepository;
import com.example.flexisaf.flexisaf_project.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImple implements SchoolService {
    SchoolRepository schoolRepository;

    @Autowired
    public SchoolServiceImple(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;

    }

    @Override
    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchool() {
        return schoolRepository.findAll();
    }

    @Override
    public Optional<School> getSchoolById(Long id) {
        return schoolRepository.findById(id);
    }
    public School updateSchool(Long id, School schoolDetails)
    {
        Optional<School> optionalSchool = getSchoolById(id);
        School school = optionalSchool.orElseThrow(() -> {
            return new RuntimeException("School not found with id: " + id);
        });
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

    @Override
    public void deleteSchool(Long id) {
        Optional<School> school = getSchoolById(id);
        schoolRepository.delete(school);

    }
}
