package org.taskmanagement401.front.menuClasses.bossMenu;

import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.ProjectAddService;
import org.taskmanagement401.service.util.UserTalkService;

public class AddProjectMenu {


    public AddProjectMenu(ProjectRepository projectRepository) {
        UserTalkService.projectInformation();
        ProjectAddService addService = new ProjectAddService(projectRepository);
        ProjectDto dto = UserTalkService.getProjectParameters();
        ResponseDTO dtoResponse = addService.registration(dto);
        if (dtoResponse.getCode() == 200) {
            System.out.println("Project successfully added: " + dtoResponse.getAnswer());
        } else {
            System.out.println("Error adding project: " + dtoResponse.getAnswer());
        }
    }
}
