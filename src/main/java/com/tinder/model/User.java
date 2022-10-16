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

    public User(int age, String email, String password, String firstname, String lastname, String pictureUrl) {
        this.age = age;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pictureUrl = pictureUrl;
    }
}
