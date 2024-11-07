package com.example.flexisaf.flexisaf_project.service;

import com.example.flexisaf.flexisaf_project.Repository.SchoolRepository;
import com.example.flexisaf.flexisaf_project.entity.School;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SchoolServiceImplTest {

    @Mock
    private SchoolRepository schoolRepository;

    @InjectMocks
    private SchoolServiceImpl schoolService;

    @Test
    void testCreateSchool() {
        // Arrange
        School school = new School("Test School", "123 Main St");
        when(schoolRepository.save(school)).thenReturn(school);

        // Act
        School createdSchool = schoolService.createSchool(school);

        // Assert
        assertEquals(school, createdSchool);
        verify(schoolRepository, times(1)).save(school);
    }

    @Test
    void testGetAllSchools() {
        // Arrange
        School school1 = new School("School 1", "1 Main St");
        School school2 = new School("School 2", "2 Main St");
        List<School> schools = Arrays.asList(school1, school2);
        when(schoolRepository.findAll()).thenReturn(schools);

        // Act
        List<School> result = schoolService.getAllSchool();

        // Assert
        assertEquals(schools, result);
        verify(schoolRepository, times(1)).findAll();
    }


}