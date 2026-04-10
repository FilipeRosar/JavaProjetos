package com.exercicio.alunos.service;


import com.exercicio.alunos.model.Aluno;
import com.exercicio.alunos.model.CreateAlunoDTO;
import com.exercicio.alunos.repository.IAlunoRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoService {

    private IAlunoRepository _alunoRepository;

    public AlunoService(IAlunoRepository alunoRepository) {
        _alunoRepository = alunoRepository;
    }

    public UUID createAluno(CreateAlunoDTO dto){
        var entity = new Aluno(
                dto.name(),
                dto.dataNascimento(),
                dto.email(),
                dto.password(),
                Instant.now(),
                null,
                dto.curso());
        var savedEntity = _alunoRepository.save(entity);

        return savedEntity.getId();
    }
    public Optional<Aluno> getUserById(String id){
        var entity = _alunoRepository.findById(UUID.fromString(id));
        return entity.stream().findFirst();
    }

}
