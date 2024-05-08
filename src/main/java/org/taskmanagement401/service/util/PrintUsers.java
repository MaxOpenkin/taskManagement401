package org.taskmanagement401.service.util;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class PrintUsers {
    public static Optional<User> print(Project project,Task task) {
        List<User> usersInProject = project.getUsers();
        List<User> usersInTask = task.getAssignedUsers();
        usersInProject.removeIf(usersInTask::contains);
        if (usersInProject.isEmpty()) {
            return Optional.empty();
        } else {

            UserTalkService.printAllUsers(usersInProject);
            int userChoice = UserInput.inputPositiveInt("Choose a user by ID: ");
            return usersInProject.stream()
                    .filter(user -> user.getId() == userChoice)
                    .findFirst();
        }
    }

}
