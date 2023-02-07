package com.codegym.model.decentralization;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String username;
    private String password;
    private boolean isDelete;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, boolean isEnable, boolean isDelete) {
        this.username = username;
        this.password = password;
        this.isDelete = isDelete;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean is_Delete) {
        this.isDelete = is_Delete;
    }

}
