package org.taskmanagement401.service.util;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.UserRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class PrintUsersInProject {
    public static Optional<User> print(Project project, UserRepository userRepository){
        List<User> usersInProject = project.getUsers();
        List<User> allUsers = userRepository.getUsersWithoutBoss();
        allUsers.removeIf(usersInProject::contains);
         if(allUsers.isEmpty()){
            return Optional.empty();
        }else{
            UserTalkService.printAllUsers(allUsers);
            int userChoice = UserInput.inputPositiveInt("Choose a user by ID: ");
            return  allUsers.stream()
                    .filter(user -> user.getId() == userChoice)
                    .findFirst();
        }

    }
}
