package com.letras.pfc_letras.services.impl;

import com.letras.pfc_letras.models.UsersModels.UserModel;
import com.letras.pfc_letras.repositories.UserRepository;
import com.letras.pfc_letras.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public Optional<UserModel> findUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    @Override
    public Optional<UserModel> saveUser(UserModel newUser) {
        return Optional.ofNullable(Optional.of(userRepository.save(newUser))
                       .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del usuario ya existe")));
    }
}
