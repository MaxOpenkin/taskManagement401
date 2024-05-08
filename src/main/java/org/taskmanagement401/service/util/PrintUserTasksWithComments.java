package org.taskmanagement401.service.util;

import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Task;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrintUserTasksWithComments {
    public void print(List<Task> tasks){
        tasks.sort(Comparator
                .comparing(Task::getProject).thenComparing(Task::getPriority));
        String projectName="";
        for(Task task : tasks){
            if(!projectName.equals(task.getProject().getName())){
                System.out.println("Project : "+task.getProject().getName());
                projectName=task.getProject().getName();
            }
            System.out.println("    Task: "+task.getTaskName());
            for(Comment comment: task.getComments()){
                System.out.println("              "+comment.getUser().getName()+" : "+comment.getMessage());
            }

        }
    }
}
