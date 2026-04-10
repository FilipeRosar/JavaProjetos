package com.exercicio.alunos.controller;


import com.exercicio.alunos.model.Aluno;
import com.exercicio.alunos.model.CreateAlunoDTO;
import com.exercicio.alunos.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("v1/alunos")
public class AlunoController {
    private AlunoService _alunoService;

    public AlunoController(AlunoService alunoService) {
        _alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Aluno> CreateAluno (@RequestBody CreateAlunoDTO dto){
        var alunoId = _alunoService.createAluno(dto);

        return ResponseEntity.created(URI.create("v1/alunos" + alunoId.toString())).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getUserById (@PathVariable("id") String id){
        var aluno = _alunoService.getUserById(id);
        return aluno.map(ResponseEntity:: ok) .orElse(ResponseEntity.notFound().build());
    }

}
