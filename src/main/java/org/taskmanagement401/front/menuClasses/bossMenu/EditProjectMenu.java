package org.taskmanagement401.front.menuClasses.bossMenu;

import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.ProjectEditService;
import org.taskmanagement401.service.util.UserInput;
import org.taskmanagement401.service.util.UserTalkService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EditProjectMenu {

    public EditProjectMenu(ProjectRepository projectRepository) {
        System.out.println("Select a project to edit:");
       // List<Project> projects = projectRepository.findAll();
        List<Project> projects = new ArrayList<>(projectRepository.findAll().stream().
                filter(project -> !project.isStatus()).toList());
        UserTalkService.printAllProjects(projects);

        int projectChoice = UserInput.inputPositiveInt("Choose a project by ID to edit: ");

        Optional<Project> optionalProject = projects.stream()
                .filter(project -> project.getId() == projectChoice)
                .findFirst();

        if (optionalProject.isPresent()) {

            Project selectedProject = optionalProject.get();

            System.out.println("Current description: " + selectedProject.getDiscription());

            String newDescription = UserInput.inputText("Enter new description: ");

            ProjectEditService editService = new ProjectEditService(projectRepository);

            ResponseDTO<String> response = editService.editProjectDescription(selectedProject.getId(), newDescription);
            System.out.println(response.getAnswer());
        } else {
            System.out.println("Invalid project selection.");
        }

    }
}
