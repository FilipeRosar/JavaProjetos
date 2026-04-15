package com.escola.escola_projeto.controller;

import com.escola.escola_projeto.domain.Student;
import com.escola.escola_projeto.dto.CreateStudentDto;
import com.escola.escola_projeto.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/students")
public class StudentController {
    @Autowired
    private StudentService _studentService;

    @PostMapping
    private ResponseEntity<Student> createStudent(@RequestBody @Valid CreateStudentDto dto){
        var studentId = _studentService.createStudent(dto);
        return ResponseEntity.created(URI.create("/v1/students/"+ studentId.toString())).build();
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@NotNull UUID id){
        var studentId =  _studentService.getStudentById(id);
        return ResponseEntity.ok(studentId);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        var students = _studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudentById(@NotNull UUID id){
         _studentService.deleteStudent(id);
         return ResponseEntity.noContent().build();
    }
}
