package com.escola.escola_projeto.service;

import com.escola.escola_projeto.domain.Student;
import com.escola.escola_projeto.dto.CreateStudentDto;
import com.escola.escola_projeto.exception.BusinessException;
import com.escola.escola_projeto.repository.StudentRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Period;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository _studentRepository;

    public StudentService(StudentRepository _studentRepository) {
        this._studentRepository = _studentRepository;
    }
    public UUID createStudent(@NotNull CreateStudentDto dto){
        if (dto.birthDate().isAfter(LocalDate.now())){
            throw new BusinessException("Data nascimento invalida");
        }
        int age = Period.between(dto.birthDate(), LocalDate.now()).getYears();

        if (age <= 0){
            throw new BusinessException("Idade invalida");
        }
        Student student = new Student();

        student.setName(dto.name());
        student.setBirthDate(dto.birthDate());
        student.setEmail(dto.email());
        student.setPhone(dto.phone());

        return _studentRepository.save(student).getId();
    }
    public Student getStudentById(@NotNull UUID id){
        return _studentRepository.findById(id).get();
    }
    public List<Student> getAllStudents(){
        return _studentRepository.findAll();
    }
    public void deleteStudent(UUID id){
        if (id == null)
            throw new BusinessException("ID não pode ser nulo");

        Student student = _studentRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Aluno não encontrado"));

        _studentRepository.deleteById(student.getId());
    }
}
