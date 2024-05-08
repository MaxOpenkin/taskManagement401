package org.taskmanagement401.service.dataService.save;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Optional;

public class SaveTask {
    public Optional<Exception> save(Task task) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/java/org/taskmanagement401/data/task.csv", true));
            String strToAppend = task.getTaskID() + "," + task.getTaskName() + "," +
                    task.getEndDate().getYear() + "," + task.getEndDate().getMonthValue() +
                    "," + task.getEndDate().getDayOfMonth() + "," + task.getPriorityValue()
                    + "," + (task.isTaskCompleted() ? 1 : 0);
            writer.append(strToAppend);
            writer.append("\n");
            writer.close();

        } catch (Exception e) {
            return Optional.of(e);
        }
        return Optional.empty();
    }

    public Optional<Exception> saveList(Task task,Project project){
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/java/org/taskmanagement401/data/taskList.csv", true));
            String strToAppend=project.getId()+","+task.getTaskID();
            writer.append(strToAppend);
            writer.append("\n");
            writer.close();

        }catch (Exception e){
            return Optional.of(e);
        }
        return Optional.empty();
    }
    public Optional<Exception> saveAddUser(Task task, User user){
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/java/org/taskmanagement401/data/taskUserList.csv", true));
            String strToAppend=task.getTaskID()+","+user.getId();
            writer.append(strToAppend);
            writer.append("\n");
            writer.close();
        }catch (Exception e){
            return Optional.of(e);
        }
        return Optional.empty();
    }
}
