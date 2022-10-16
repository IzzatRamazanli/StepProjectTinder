package com.tinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class Message {
    private int id;
    private int sender;
    private int receiver;
    private String content;
    private String sendDate;

    public Message(int sender, int receiver, String content) {
        this.sendDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

}
