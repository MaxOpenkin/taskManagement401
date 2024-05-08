package org.taskmanagement401.service;

import org.junit.jupiter.api.Test;
import org.taskmanagement401.dto.ChatDTO;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ChatRepository;

import static org.junit.jupiter.api.Assertions.*;

class ChatServiceTest {

    @Test
    void addNewSMS() {
        ChatDTO dto=new ChatDTO("   ");
        ChatRepository chatRepository =new ChatRepository();
        User user=new User(1,"user1","login","password1",1);
        ChatService service=new ChatService(chatRepository);
        ResponseDTO responseDTO=service.addNewSMS(dto,user,2);
        assertEquals(400,responseDTO.getCode());
    }

}