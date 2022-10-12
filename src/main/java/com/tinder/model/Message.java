package com.tinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Message {
    private int sender;
    private int receiver;
    private String content;
    private String sendDate;
}
