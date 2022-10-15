package com.tinder.model;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    private int id;
    private final String email;
    @Getter
    private final String password;
    private final String firstname;
    private final String lastname;
    private final int age;
    private final String pictureUrl;


}
