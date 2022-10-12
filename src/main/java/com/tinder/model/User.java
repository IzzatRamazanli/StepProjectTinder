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
    private final String name;
    private final String surname;
    private final int age;
    private final String pictureUrl;


}
