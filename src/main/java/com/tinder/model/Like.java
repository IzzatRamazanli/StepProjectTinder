package com.tinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Like {

    private int id;
    private int from;
    private int to;
    private boolean status;

    public Like(int from, int to, boolean status) {
        this.from = from;
        this.to = to;
        this.status = status;
    }
}
