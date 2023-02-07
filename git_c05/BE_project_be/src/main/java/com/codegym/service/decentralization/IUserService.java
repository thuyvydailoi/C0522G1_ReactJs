package com.codegym.service.decentralization;





import com.codegym.dto.decentralization.IUserDto;
import com.codegym.model.decentralization.User;

import java.util.List;
import java.util.Optional;


public interface IUserService {
    User findByUsername(String name);

//    User checkUser(String username, String password);

    Optional<User> checkUser(String username, String password);

    List<User> findAll();
}
