package com.exercicio.alunos.controller;

import com.exercicio.alunos.exception.GlobalExceptionHandler;
import com.exercicio.alunos.controller.dto.UpdateAlunoDTO;
import com.exercicio.alunos.model.Aluno;
import com.exercicio.alunos.controller.dto.CreateAlunoDTO;
import com.exercicio.alunos.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/alunos")
public class AlunoController {
    private final AlunoService _alunoService;

    public AlunoController(AlunoService alunoService) {
        _alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Aluno> CreateAluno (@RequestBody CreateAlunoDTO dto){

        try {
            var alunoId = _alunoService.createAluno(dto);

            return ResponseEntity.created(URI.create("/v1/alunos/" + alunoId.toString())).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/{alunoId}")
    public ResponseEntity<Aluno> getUserById (@PathVariable("alunoId") String alunoId){
        var aluno = _alunoService.getUserById(alunoId);
        return aluno.map(ResponseEntity:: ok) .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllUsers (){
        var alunos = _alunoService.getUsers();
        return ResponseEntity.ok(alunos);
    }

    @PutMapping("/{alunoId}")
    public ResponseEntity<Void> updateAluno(@PathVariable("alunoId") String alunoId,
                                            @RequestBody UpdateAlunoDTO dto){

        _alunoService.updateAluno(alunoId,dto);
        return  ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @DeleteMapping("/{alunoId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("alunoId") String alunoId){
            _alunoService.deleteById(alunoId);

            return ResponseEntity.noContent().build();

    }

}
