package com.escola.escola_projeto.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "tb_enrollment",
uniqueConstraints = @UniqueConstraint(columnNames = {"student_id","class_id"}))
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private ClassGroup classGroup;

    private LocalDate enrollmentDate;

    @OneToMany(mappedBy = "enrollment")
    private List<Grade> grades;

    public Enrollment() {
        this.id = UUID.randomUUID();
    }
    public double calculateGrade(){
        return grades.stream()
                .mapToDouble(Grade::getGrade)
                .average()
                .orElse(0.0);
    }
    public boolean isApproved(double attendance){
        return calculateGrade() >= 6.0 && attendance >= 75.0;
    }
}
