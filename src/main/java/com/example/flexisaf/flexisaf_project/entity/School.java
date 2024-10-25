package com.example.flexisaf.flexisaf_project.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;


@Entity
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "principal_name", length = 100)
    private String principalName;

    @Column(name = "foundation_year")
    private Integer foundationYear;

    @Column(name = "total_students")
    private Integer totalStudents;

    @Column(name = "total_staff")
    private Integer totalStaff;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
