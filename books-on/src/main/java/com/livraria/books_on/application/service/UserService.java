package com.livraria.books_on.application.service;

import com.livraria.books_on.domain.entity.User;
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
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SecurityConfig encoder;

    public UUID createUser(String username,String email, String password){
        var passwordEncoder = new BCryptPasswordEncoder();
        if(userRepository.findByEmail(email).isPresent()){
            throw new BussinessException("Email já existente");
        }
        User user = new User();
        user.setName(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        return userRepository.save(user).getId();

    }
}
