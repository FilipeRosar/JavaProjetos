package com.livraria.books_on.application.service;


import com.livraria.books_on.domain.dto.authDTOs.LoginDto;
import com.livraria.books_on.domain.repository.UserRepository;
import com.livraria.books_on.infrastructure.exception.BussinessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(JwtService jwtService, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    public String login(LoginDto dto){
        var user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new BussinessException("Usuário não encontrado com o email: " + dto.email()));

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new BussinessException("Senha incorreta!");
        }
        return jwtService.generateToken(user);
    }
}
