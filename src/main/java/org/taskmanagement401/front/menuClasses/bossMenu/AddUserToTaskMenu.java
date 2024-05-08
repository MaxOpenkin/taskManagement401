package org.taskmanagement401.front.menuClasses.bossMenu;

import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.repository.UserRepository;
import org.taskmanagement401.service.AddUserToTaskService;
import org.taskmanagement401.service.util.*;
import java.util.Optional;

public class AddUserToTaskMenu {
    public AddUserToTaskMenu(ProjectRepository projectRepository,

                             TaskRepository taskRepository) {

        System.out.println("Select a project to find task for adding user: ");
       Optional<Project> optionalProject = PrintActiveProjects.print(projectRepository);

        if (optionalProject.isEmpty()){
            System.out.println("Invalid project selection");}
        else {
            System.out.println("Select a task for adding user: ");
             Optional<Task> taskOptional = PrintSelectedProjectsTasks.print(taskRepository, optionalProject.get());


            if (taskOptional.isEmpty()) {
                System.out.println("Invalid task selection");
            } else {

                System.out.println("Select a user for adding to selected task: ");
                Optional<User> userOptional = PrintUsers.print(optionalProject.get(),taskOptional.get());

                if (userOptional.isEmpty()) {
                    System.out.println("All of project users are in task");
                }else {
                        ResponseDTO dtoResponse =
                                AddUserToTaskService.assignUser(taskOptional.get(), userOptional.get());
                        System.out.println(dtoResponse);

                }

            }

        }
    }
}
