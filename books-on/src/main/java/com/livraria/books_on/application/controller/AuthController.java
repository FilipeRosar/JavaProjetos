package com.livraria.books_on.application.controller;

import com.livraria.books_on.domain.dto.authDTOs.AuthResponseDto;
import com.livraria.books_on.domain.dto.authDTOs.LoginDto;
import com.livraria.books_on.application.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    private AuthService _authService;

    @Autowired
    public AuthController(AuthService _authService) {
        this._authService = _authService;
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        String token = _authService.login(loginDto);
        return ResponseEntity.ok(new AuthResponseDto(token));
    }
}
