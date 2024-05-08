package org.taskmanagement401.front.menuClasses.bossMenu;

import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.UserRepository;
import org.taskmanagement401.service.AddUserToProjectService;
import org.taskmanagement401.service.AddUserToTaskService;
import org.taskmanagement401.service.util.PrintActiveProjects;
import org.taskmanagement401.service.util.PrintSelectedProjectsTasks;
import org.taskmanagement401.service.util.PrintUsers;
import org.taskmanagement401.service.util.PrintUsersInProject;

import java.util.Optional;

public class AddUserToProjectMenu {
    public AddUserToProjectMenu(ProjectRepository projectRepository,
                                UserRepository userRepository) {
        System.out.println("Select a project for adding user: ");
        Optional<Project> optionalProject = PrintActiveProjects.print(projectRepository);
        if (optionalProject.isEmpty()){
            System.out.println("Invalid project selection");}
        else {
            Optional<User> user=
                    PrintUsersInProject.print(optionalProject.get(),userRepository);
            if(user.isEmpty()){
                System.out.println("All users are already in this project");
            }    else{
                      ResponseDTO dtoResponse =
                                AddUserToProjectService.assignUser(optionalProject.get(),user.get());
                                System.out.println(dtoResponse);
            }
        }

    }
}

