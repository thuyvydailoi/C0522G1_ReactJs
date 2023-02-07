package com.codegym.controller;

import com.codegym.model.decentralization.User;
import com.codegym.payload.LoginResponse;
import com.codegym.service.decentralization.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/")
public class SecurityRestController {

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public ResponseEntity<?> authenticateUser(
            @Valid @RequestBody User user) {
//        System.out.println(user);
        Optional<User> findUser = userService.checkUser(user.getUsername(), user.getPassword());
        if (!findUser.isPresent()) {
            System.out.println("login no");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(
                new LoginResponse(
                        user.getUsername(),
                        user.getPassword()
                ));
    }


//    @GetMapping("findUsername/{username}")
//    public ResponseEntity<?> showUser(@PathVariable String usename) {
//
//        Optional<IUserDto> userTest = userService.checkUser(usename);
//        if (!userTest.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(userTest, HttpStatus.OK);
//    }

}
