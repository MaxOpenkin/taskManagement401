package org.taskmanagement401.front.menuClasses.bossMenu;

import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.CheckTaskCommentService;
import org.taskmanagement401.service.util.PrintActiveProjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CheckCommentMenu {
    public CheckCommentMenu(ProjectRepository projectRepository, TaskRepository taskRepository) {
        System.out.println("Select a project to check task comments: ");
        Optional<Project> optionalProject = PrintActiveProjects.print(projectRepository);
        if (optionalProject.isEmpty()){
            System.out.println("Invalid project selection");}
        else {
            CheckTaskCommentService check=new CheckTaskCommentService();
            HashMap<String, List<Comment>> comments=
                    check.comments(optionalProject.get());
            if(comments.isEmpty()){
                System.out.println("Project don`t has comments");
            }else{
                for(Map.Entry <String, List<Comment>> entry: comments.entrySet()){
                    System.out.println("Task : "+entry.getKey());
                    for(Comment comment:entry.getValue()){
                        System.out.println("        - "+comment.getUser().getName()+" : "+comment.getMessage());
                    }
                }
            }

        }
    }
}
