package org.taskmanagement401.service.util;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.TaskRepository;
import java.util.List;
import java.util.Optional;

public class PrintSelectedProjectsTasks {
    public static Optional<Task> print(TaskRepository taskRepository, Project selectedProject){
        List<Task> tasks = selectedProject.getTasks();
        UserTalkService.printSelectedProjectTask(selectedProject);

        int taskChoice = UserInput.inputPositiveInt("Choose a task by ID to edit: ");


        return  tasks.stream()
                .filter(task -> task.getTaskID() == taskChoice)
                .findFirst();
    }


//    public static Optional<Task> print(TaskRepository taskRepository, Optional <Project> selectedProject){
//        List<Task> tasks = taskRepository.findAll();
//        UserTalkService.printSelectedProjectTask(tasks, selectedProject);
//
//        int taskChoice = UserInput.inputPositiveInt("Choose a task by ID to edit: ");
//
//
//        return  tasks.stream()
//                .filter(task -> task.getTaskID() == taskChoice)
//                .findFirst();
//    }

}
