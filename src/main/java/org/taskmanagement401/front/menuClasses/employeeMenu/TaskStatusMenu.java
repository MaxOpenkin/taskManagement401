package org.taskmanagement401.front.menuClasses.employeeMenu;

import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.TaskChangeStatusService;
import org.taskmanagement401.service.dataService.rewrite.RewriteTask;
import org.taskmanagement401.service.util.PrintUserTasks;

import java.util.Optional;

public class TaskStatusMenu {
    public TaskStatusMenu(User user,TaskRepository taskRepository) {
        if(user.getActiveTask().isEmpty()){
            System.out.println("You don`t have active tasks");
        }else {
            Optional<Task> taskOptional = PrintUserTasks.print(user);
            if (taskOptional.isEmpty()) {
                System.out.println("Wrong input data");
            } else {
                TaskChangeStatusService service=new TaskChangeStatusService();
                ResponseDTO responseDTO=service.changeStatus(taskOptional.get(),taskRepository);
                taskOptional.get().setTaskCompleted(true);
                RewriteTask rewriteTask=new RewriteTask();
                rewriteTask.rewrite(taskRepository);
                System.out.println(responseDTO);
            }
        }
    }
}
