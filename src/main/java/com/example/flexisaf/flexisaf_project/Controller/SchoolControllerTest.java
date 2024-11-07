package com.example.flexisaf.flexisaf_project.Controller;

import com.example.flexisaf.flexisaf_project.entity.School;
import com.example.flexisaf.flexisaf_project.service.SchoolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SchoolController.class)
class SchoolControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SchoolService schoolService;

    @Test
    void testCreateSchool() throws Exception {
        // Arrange
        School school = new School("Test School", "123 Main St");
        when(schoolService.createSchool(school)).thenReturn(school);

        // Act and Assert
        mockMvc.perform(post("/api/schools")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test School\",\"address\":\"123 Main St\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test School"))
                .andExpect(jsonPath("$.address").value("123 Main St"));

        verify(schoolService, times(1)).createSchool(school);
    }


}