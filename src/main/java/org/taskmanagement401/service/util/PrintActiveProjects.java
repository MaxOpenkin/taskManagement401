package org.taskmanagement401.service.util;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrintActiveProjects {
    public static Optional<Project> print(ProjectRepository projectRepository){
        List<Project> projects = new ArrayList<>(projectRepository.findAll().stream().
                filter(project -> !project.isStatus()).toList());
               // projectRepository.findAll();
        UserTalkService.printAllProjects(projects);

        int projectChoice = UserInput.inputPositiveInt("Choose a project by ID to edit: ");


        return  projects.stream()
                .filter(project -> project.getId() == projectChoice)
                .findFirst();
    }

}
