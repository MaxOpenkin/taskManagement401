package org.taskmanagement401.service.dataService.save;

import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Optional;

public class SaveComment {
    public Optional<Exception> save(Comment comment) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/java/org/taskmanagement401/data/comment.csv", true));
            String strToAppend = comment.getId() + "," + comment.getUser().getId() + "," +
                    comment.getMessage();

            writer.append(strToAppend);
            writer.append("\n");
            writer.close();

        } catch (Exception e) {
            return Optional.of(e);
        }
        return Optional.empty();
    }
    public Optional<Exception> saveList(Task task, Comment comment){
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/java/org/taskmanagement401/data/commentList.scv", true));
            String strToAppend=task.getTaskID()+","+comment.getId();
            writer.append(strToAppend);
            writer.append("\n");
            writer.close();

        }catch (Exception e){
            return Optional.of(e);
        }
        return Optional.empty();
    }
}
