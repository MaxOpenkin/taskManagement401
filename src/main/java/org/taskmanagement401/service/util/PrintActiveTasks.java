package org.taskmanagement401.service.util;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

public class PrintActiveTasks {
    public static Optional<Task> print(ProjectRepository projectRepository, TaskRepository taskRepository){
        List<Task> tasks = taskRepository.findAll();
        UserTalkService.printAllTasks(tasks);

        int taskChoice = UserInput.inputPositiveInt("Choose a Task: ");

        return tasks.stream()
                .filter(task -> !task.isTaskCompleted())
                .filter(project -> project.getTaskID() == taskChoice)
                .findFirst();

    }

}
