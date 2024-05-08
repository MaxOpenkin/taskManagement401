package org.taskmanagement401.front.menuClasses.bossMenu;

import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.front.manus.Menu;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.TaskEditService;
import org.taskmanagement401.service.util.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class EditTaskMenu {
    private Menu menu = new Menu();
    private TaskEditService editService;

    public EditTaskMenu(ProjectRepository projectRepository, TaskRepository taskRepository) {
        System.out.println("List of all active Projects:");
        Optional<Project> optionalProject = PrintActiveProjects.print(projectRepository);


        if (optionalProject.isEmpty()) {
            System.out.println("Wrong input data");

        } else if (optionalProject.isPresent()) {
            System.out.println("List of all active Tasks:");
            Optional<Task> optionalTask = PrintSelectedProjectsTasks.print(taskRepository, optionalProject.get());

            if (optionalTask.isEmpty()) {
                System.out.println("Tasks list is empty");
            } else if (optionalTask.isPresent()) {
                Task task = optionalTask.get();
                System.out.println("Chosen task: " +" "+ task.getTaskName()+" " + task.getEndDate() +" " + task.getPriority());
                System.out.println("Choose what want you to edit (1 - Task Name, 2 - Task date of end, 3 - Task priority)");
                int answer = menu.getUserChoice(3);

                switch (answer) {
                    case -1:
                        menu.printError();
                        break;
                    case 1:
                        editService = new TaskEditService(taskRepository);
                        String newName = UserInput.inputText("The name must have from 3 to 20 letters.");
                        ResponseDTO<String> response = editService.editTaskName(task.getTaskID(), newName);
                        System.out.println(response.getAnswer());
                        break;
                    case 2:
                        editService = new TaskEditService(taskRepository);
                        LocalDate newDate = UserInput.inputDate("Enter your date. It should be in format dd.mm.yyyy");
                        ResponseDTO<String> response2 = editService.editDateEnd(task.getTaskID(), newDate);
                        System.out.println(response2.getAnswer());
                        break;
                    case 3:
                        editService = new TaskEditService(taskRepository);
                        int newPriority = UserInput.inputPositiveInt("Enter you new priority level(Use 3 for High priority, 2 - Medium, 1 - Low)");
                        ResponseDTO<String> response3 = editService.editPriority(task.getTaskID(), newPriority);
                        System.out.println(response3.getAnswer());
                        break;
                }
            }

        } else {
            System.out.println("Invalid project selection.");
        }


    }
}
