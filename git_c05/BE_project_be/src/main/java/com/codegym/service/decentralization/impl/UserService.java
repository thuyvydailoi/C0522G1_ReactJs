package com.codegym.service.decentralization.impl;

import com.codegym.dto.decentralization.IUserDto;
import com.codegym.model.decentralization.User;
import com.codegym.repository.decentralization.IUserRepository;
import com.codegym.service.decentralization.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

//    @Override
//    public User checkUser(String username, String password) {
//        return userRepository.checkUser(username, password);
//    }

    @Override
    public Optional<User> checkUser(String username, String password) {
        return userRepository.checkUser(username, password);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}