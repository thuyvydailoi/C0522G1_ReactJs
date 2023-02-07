package com.codegym.repository.decentralization;

import com.codegym.dto.decentralization.IUserDto;
import com.codegym.model.decentralization.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

    User findByUsername(String name);

    @Query(value = "SELECT * from  user where username =:username and password =:password", nativeQuery = true)
    Optional<User> checkUser(@Param("username") String username, @Param("password") String password);



}
