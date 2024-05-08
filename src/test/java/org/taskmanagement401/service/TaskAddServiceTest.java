package org.taskmanagement401.service;

import org.junit.jupiter.api.Test;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.repository.TaskRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskAddServiceTest {

    @Test
    void registration() {
        LocalDate localDate = LocalDate.of(2023,5,20);
        TaskDto taskDto=new TaskDto("Task1",localDate,1);
        TaskRepository taskRepository= new TaskRepository();
        TaskAddService taskAddService = new TaskAddService(taskRepository);
        ResponseDTO responseDTO = taskAddService.registration(taskDto,new Project(
                1,"Test Project","Description")
        );
        assertEquals(400,responseDTO.getCode());
    }

    @Test
    void registration2() {
        LocalDate localDate = LocalDate.of(2024,4,20);
        TaskDto taskDto=new TaskDto("Task2",localDate,1);
        TaskRepository taskRepository= new TaskRepository();
        TaskAddService taskAddService = new TaskAddService(taskRepository);
        ResponseDTO responseDTO = taskAddService.registration(taskDto,new Project(
                1,"Test Project","Description")
        );
        assertEquals(200,responseDTO.getCode());
    }
}