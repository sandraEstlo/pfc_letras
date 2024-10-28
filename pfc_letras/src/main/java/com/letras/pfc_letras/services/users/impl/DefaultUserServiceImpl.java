package com.letras.pfc_letras.services.users.impl;

import com.letras.pfc_letras.models.users.UserModel;
import com.letras.pfc_letras.repositories.UserRepository;
import com.letras.pfc_letras.services.users.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultUserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public Optional<UserModel> findUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    @Override
    public Optional<UserModel> saveUser(UserModel newUser) {
        return Optional.of(userRepository.save(newUser));
    }
}
