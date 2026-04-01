package com.exercici.filipe.controller;

import com.exercici.filipe.entity.User;
import com.exercici.filipe.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> CreateUser(@RequestBody CreateUserDto createUserDto) {
        var userId = userService.createUser(createUserDto);
        return  ResponseEntity.created(URI.create("/v1/users/" + userId.toString())).build();
    }
    @GetMapping("/{userId}")
    public  ResponseEntity<User> GetUser(@PathVariable String userId) {
        return  null;
    }
}
