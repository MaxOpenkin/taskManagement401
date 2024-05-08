package org.taskmanagement401.repository;

import org.taskmanagement401.entity.Message;
import org.taskmanagement401.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChatRepository implements ChatInterface {

        private List<Message> sms=new ArrayList<>();
        private int id=0;
    @Override
        public Message addSMS(String content, User sender, int receiver){
            Message newSMS=createSMS(content, sender, receiver);
            sms.add(newSMS);
            sender.getSms().add(newSMS);
            return newSMS;
        }
        private Message createSMS(String content, User sender, int receiver){
            return new Message(++id,sender.getId(),receiver,content, LocalDateTime.now());
        }

        public List<Message> getSms() {
            return sms;
        }

        public void setSms(List<Message> sms) {
            this.sms = sms;
        }

    public void setId(int id) {
        this.id = id;
    }
}


