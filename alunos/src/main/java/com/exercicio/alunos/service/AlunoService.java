package com.exercicio.alunos.service;


import com.exercicio.alunos.controller.dto.UpdateAlunoDTO;
import com.exercicio.alunos.model.Aluno;
import com.exercicio.alunos.controller.dto.CreateAlunoDTO;
import com.exercicio.alunos.repository.IAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoService {

    private IAlunoRepository _alunoRepository;

    @Autowired
    private PasswordEncoder hashPassword;

    public AlunoService(IAlunoRepository alunoRepository) {
        _alunoRepository = alunoRepository;
    }

    public UUID createAluno(CreateAlunoDTO dto){

        String hash = hashPassword.encode(dto.password());

        var entity = new Aluno(
                dto.name(),
                dto.dataNascimento(),
                dto.email(),
                hash,
                dto.sexo(),
                dto.telefone(),
                dto.curso());

        var savedEntity = _alunoRepository.save(entity);

        return savedEntity.getId();
    }
    public Optional<Aluno> getUserById(String id){

        var entity = _alunoRepository.findById(UUID.fromString(id));
        return entity.stream().findFirst();
    }

    public List<Aluno> getUsers(){
        return _alunoRepository.findAll();
    }
    public void updateAluno(String alunoId, UpdateAlunoDTO dto){
        var id = UUID.fromString(alunoId);

        var entityAluno = _alunoRepository.findById(id);

        if(entityAluno.isPresent()){
            var aluno = entityAluno.get();

            if (dto.name() != null){
                aluno.setName(dto.name());
            }
            if (dto.curso() != null){
                aluno.setCurso(dto.curso());
            }
            if (dto.email() != null){
                aluno.setEmail(dto.email());
            }
            _alunoRepository.save(aluno);
        }
    }

    public void deleteById(String alunoId){
        var id = UUID.fromString(alunoId);

        var alunoExist = _alunoRepository.existsById(id);

        if (alunoExist) {
            _alunoRepository.deleteById(id);
        }
    }

}
