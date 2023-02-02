package com.example.lumet13.Request.Authorization.Models;


public class User {
    String login;
    String password;
    String email;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
}
