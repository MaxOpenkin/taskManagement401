package org.taskmanagement401.front.menuClasses.employeeMenu;

import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.service.util.PrintUserTasksWithComments;

import java.util.ArrayList;
import java.util.List;

public class CheckCommentMenuUser {
    public CheckCommentMenuUser(User user) {
        if(user.getTask().isEmpty()){
            System.out.println("You don`t have active Tasks");
        }else {
            List<Task> tasks =new ArrayList<>( user.getTask()
                   .stream().filter(x -> !x.getComments().isEmpty()).toList());
            if (tasks.isEmpty()) {
                System.out.println("You don`t have comments in uor Tasks");
            } else {
                PrintUserTasksWithComments print = new PrintUserTasksWithComments();
                print.print(tasks);
            }
        }
    }
}
