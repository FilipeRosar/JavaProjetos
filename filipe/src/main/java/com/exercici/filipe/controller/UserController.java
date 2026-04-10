package com.exercici.filipe.controller;

import com.exercici.filipe.entity.User;
import com.exercici.filipe.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {

    private final UserService _userService;

    public UserController(UserService userService) {
        _userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> CreateUser(@RequestBody CreateUserDto createUserDto) {
        var userId = _userService.createUser(createUserDto);
        return  ResponseEntity.created(URI.create("/v1/users/" + userId.toString())).build();
    }
    @GetMapping("/{userId}")
    public  ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        var  user = _userService.getUserById(userId);

        return user
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        var users = _userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userId,
                                               @RequestBody UpdateUserDto updateUserDto) {
        _userService.updateUserById(userId, updateUserDto);
        return   ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public  ResponseEntity<Void> deleteUserById(@PathVariable("userId") String userId) {
        _userService.deleteById(userId);

        return ResponseEntity.noContent().build();
    }
}
