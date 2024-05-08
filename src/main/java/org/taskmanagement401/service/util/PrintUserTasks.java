package org.taskmanagement401.service.util;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

public class PrintUserTasks {
    public static Optional<Task> print(User user){
        List<Task> tasks = user.getTask();
        UserTalkService.printAllTasksWithProjects(tasks);
        int projectChoice = UserInput.inputPositiveInt("Choose a task by ID: ");
           return tasks.stream()
                    .filter(task -> task.getTaskID() == projectChoice)
                    .findFirst();
    }
}
