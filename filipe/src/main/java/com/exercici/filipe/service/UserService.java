package com.exercici.filipe.service;

import com.exercici.filipe.controller.CreateUserDto;
import com.exercici.filipe.entity.User;
import com.exercici.filipe.repository.IUserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private IUserRepository _userRepository;

    public UserService(IUserRepository userRepository) {
        _userRepository = userRepository;
    }

    public  UUID createUser( CreateUserDto createUserDto) {

        var entity = new User(
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),
                Instant.now(),
                null);
       var userSaved =  _userRepository.save(entity);

       return userSaved.getUserId();
    }
    public User getUser(UUID id){
        var entity = _userRepository.findById(id);
        return entity.get();
    }
    public Optional<User> getUserById(String userId) {
        var user = _userRepository.findById(UUID.fromString(userId));
        return  user.stream().findFirst();
        }
    }

