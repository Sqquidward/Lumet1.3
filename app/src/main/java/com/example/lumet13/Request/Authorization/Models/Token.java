package com.example.lumet13.Request.Authorization.Models;

public class Token {
    String email;
    String emailtoken;

    public Token(String email, String emailtoken) {
        this.email = email;
        this.emailtoken = emailtoken;
    }
}
