package com.escola.escola_projeto.repository;

import com.escola.escola_projeto.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
