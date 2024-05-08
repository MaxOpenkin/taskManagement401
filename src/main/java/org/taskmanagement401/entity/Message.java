package org.taskmanagement401.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private int id;
    private int sender;
    private int receiver;
    private String contents;
    private LocalDateTime sendTime;

    public Message(int id, int sender, int receiver, String contents, LocalDateTime sendTime) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.contents = contents;
        this.sendTime = sendTime;
    }

    public int getSender() {
        return sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public String getContents() {
        return contents;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public int getId() {
        return id;
    }


}


