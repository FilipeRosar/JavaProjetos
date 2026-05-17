package com.livraria.books_on.application.controller;

import com.livraria.books_on.application.service.UserService;
import com.livraria.books_on.domain.dto.userDTOs.UserResponseDto;
import com.livraria.books_on.domain.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/user")
public class UserController {
    private final UserService _userService;

    public UserController(UserService _userService) {
        this._userService = _userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(UUID userId){
        var id = _userService.getUserById(userId);
        return ResponseEntity.of(id);
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUser(){
        var users = _userService.getUser();
        return ResponseEntity.ok(users);
    }
}
