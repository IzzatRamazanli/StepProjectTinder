package com.tinder.model;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
    private String pictureUrl;

    public User(String email, String password, String firstname, String lastname, int age, String pictureUrl) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.pictureUrl = pictureUrl;
    }
}
