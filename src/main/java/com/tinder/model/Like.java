package com.tinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Like {

    private int from;
    private int to;
    private boolean status;

}
