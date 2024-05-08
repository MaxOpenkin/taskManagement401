package org.taskmanagement401.service;

import org.junit.jupiter.api.Test;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.repository.ProjectRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectAddServiceTest {

    @Test
    void registration() {
        ProjectDto projectDto = new ProjectDto("Project1", "This is project 1");
        ProjectRepository projectRepository = new ProjectRepository();
        ProjectAddService projectAddService = new ProjectAddService(projectRepository);
        ResponseDTO responseDTO = projectAddService.registration(projectDto);
        assertEquals(200, responseDTO.getCode());
    }
    @Test
    void registration2() {
        ProjectDto projectDto = new ProjectDto("P", "");
        ProjectRepository projectRepository = new ProjectRepository();
        ProjectAddService projectAddService = new ProjectAddService(projectRepository);
        ResponseDTO responseDTO = projectAddService.registration(projectDto);
        assertEquals(400, responseDTO.getCode());
    }
}