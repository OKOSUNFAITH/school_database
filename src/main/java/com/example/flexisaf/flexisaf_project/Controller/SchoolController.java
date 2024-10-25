package com.example.flexisaf.flexisaf_project.Controller;

import com.example.flexisaf.flexisaf_project.entity.School;
import com.example.flexisaf.flexisaf_project.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/schools")
public class SchoolController {
    SchoolService schoolService;
    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }
    @PostMapping
    public School createSchool(@RequestBody School school)
    {
        return schoolService.createSchool(school);
    }

    @GetMapping("/{id}")
    public Optional<School> getSchool(@PathVariable Long id) {
        return (schoolService.getSchoolById(id));
    }

    @GetMapping
    public List<School> getAllSchool() {
        return (schoolService.getAllSchool());
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Long id, @RequestBody School school) {
        return ResponseEntity.ok(schoolService.updateSchool(id, school));
    }

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id) {
          schoolService.deleteSchool(id);

    }

}
