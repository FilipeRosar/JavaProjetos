package com.escola.escola_projeto.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Enrollment enrollment;

    private Boolean present;

    private LocalDate date;

    public Attendance() {
        this.id = UUID.randomUUID();
    }
}
