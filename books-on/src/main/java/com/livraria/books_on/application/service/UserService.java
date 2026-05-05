package com.livraria.books_on.application.service;

import com.livraria.books_on.application.dto.authDTOs.CreateUserDto;
import com.livraria.books_on.domain.entity.User;
import com.livraria.books_on.domain.enume.Role;
import com.livraria.books_on.domain.repository.UserRepository;
import com.livraria.books_on.infrastructure.exception.BussinessException;
import com.livraria.books_on.infrastructure.security.SecurityConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final SecurityConfig encoder;

    public UserService(UserRepository userRepository, SecurityConfig encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public UUID createUser(CreateUserDto dto){
        var passwordEncoder = new BCryptPasswordEncoder();
        if(userRepository.findByEmail(dto.email()).isPresent()){
            throw new BussinessException("Email já existente");
        }
        User user = new User();
        user.setName(dto.username());
        user.setEmail(dto.email());
        user.setCpf(dto.Cpf());
        user.setRole(Role.SELLER);
        user.setPassword(passwordEncoder.encode(dto.password()));

        return userRepository.save(user).getId();

    }
}
