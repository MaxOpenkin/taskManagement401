package org.taskmanagement401.service;

import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;

import java.util.HashMap;
import java.util.List;

public class CheckTaskCommentService {
    public HashMap<String, List<Comment>> comments(Project project){
        HashMap<String, List<Comment>> map=new HashMap<>();
        for (Task task :project.getTasks()){
            if(!task.getComments().isEmpty()){
                map.put(task.getTaskName(),task.getComments());
            }
        }
        return map;
    }
}
