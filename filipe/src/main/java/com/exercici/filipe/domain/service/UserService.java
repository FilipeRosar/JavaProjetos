package com.exercici.filipe.domain.service;

import com.exercici.filipe.application.dto.CreateUserDto;
import com.exercici.filipe.application.dto.UpdateUserDto;
import com.exercici.filipe.domain.entity.User;
import com.exercici.filipe.domain.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private IUserRepository _userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(IUserRepository userRepository) {
        _userRepository = userRepository;
    }

    public  UUID createUser( CreateUserDto createUserDto) {

        String passwordHash = passwordEncoder.encode(createUserDto.password());

        var entity = new User(
                createUserDto.username(),
                createUserDto.email(),
                passwordHash,
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

    public List<User> getAllUsers() {
        return _userRepository.findAll();
    }
    public void updateUserById(String userId, UpdateUserDto updateUserDto) {
       var id = UUID.fromString(userId);

       var userEntity = _userRepository.findById(id);

       if (userEntity.isPresent()) {
            var user = userEntity.get();

            if (updateUserDto.username() != null) {
                user.setUsername(updateUserDto.username());
            }
            if (updateUserDto.password() != null){
                user.setPassword(updateUserDto.password());
            }
         _userRepository.save(user);
       }
    }

    public void deleteById(String userId) {
        var id = UUID.fromString(userId);

        var userExists = _userRepository.existsById(id);
        if (userExists) {
            _userRepository.deleteById(id);
        }
    }
}

