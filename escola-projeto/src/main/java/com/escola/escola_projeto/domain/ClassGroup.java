package com.escola.escola_projeto.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_class")
public class ClassGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String descricao;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "classGroup")
    private List<Enrollment> enrollments;

    public ClassGroup() {
        this.id = UUID.randomUUID();
    }
}
