package org.taskmanagement401.service;

import org.junit.jupiter.api.Test;
import org.taskmanagement401.dto.CommentDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.CommentRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceTest {

    @Test
    void addNewComment() {
        CommentDto dto=new CommentDto("   ");
        CommentService service=new CommentService(new CommentRepository());

        ResponseDTO response=service.addNewComment(new User(1,"user1",
                        "login","password1",1)
                ,dto,new Task(1,"Task1", LocalDate.now(),1));
        assertEquals(400,response.getCode());
    }
}