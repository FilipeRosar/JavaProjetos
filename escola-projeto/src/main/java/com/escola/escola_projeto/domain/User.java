package com.escola.escola_projeto.domain;


import com.escola.escola_projeto.domain.enumeration.Role;
import jakarta.persistence.*;
import com.escola.escola_projeto.domain.Student;
import java.util.UUID;

@Entity
@Table(name = "tb_name")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String username;

    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;
}
