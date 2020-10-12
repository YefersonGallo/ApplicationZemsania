package com.zemsania.application.controller;

public class User {

    private String user;
    private String pwd;
    private String token;

    public User(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    public User() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}