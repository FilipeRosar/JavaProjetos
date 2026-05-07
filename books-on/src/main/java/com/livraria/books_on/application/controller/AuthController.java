package com.livraria.books_on.application.controller;

import com.livraria.books_on.application.dto.authDTOs.CreateUserDto;
import com.livraria.books_on.domain.dto.authDTOs.AuthResponseDto;
import com.livraria.books_on.domain.dto.authDTOs.LoginDto;
import com.livraria.books_on.application.service.AuthService;
import com.livraria.books_on.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    private AuthService _authService;
    private UserService _userService;

    public AuthController(AuthService _authService, UserService _userService) {
        this._authService = _authService;
        this._userService = _userService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        String token = _authService.login(loginDto);
        return ResponseEntity.ok(new AuthResponseDto(token));
    }
    @PostMapping("/register")
    public ResponseEntity<CreateUserDto> createUser(@RequestBody CreateUserDto dto){
        var userID = _userService.createUser(dto);

        return ResponseEntity.created(URI.create("v1/user/" + userID.toString())).build();
    }
}
