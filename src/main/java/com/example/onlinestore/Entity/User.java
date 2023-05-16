package com.example.onlinestore.Entity;

import jakarta.persistence.*;

//merged test
@Entity
@Table(name = "user")
public class User {
    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    @Column(name = "password")
    private String userPassword;

    private String jwtToken;

    public User(Integer id, String userName, String userPassword, String jwtToken) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.jwtToken = jwtToken;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
