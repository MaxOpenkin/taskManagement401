package org.taskmanagement401.service.dataService.save;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Optional;

public class SaveProject {
    public Optional<Exception> save(Project project){
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/java/org/taskmanagement401/data/project.csv", true));
            String strToAppend=project.getId()+","+project.getName()+","+ project.getDiscription()
                    +","+ (project.isStatus()?1:0);
            writer.append(strToAppend);
            writer.append("\n");
            writer.close();
        }catch (Exception e){
            return Optional.of(e);
        }
        return Optional.empty();
    }
    public Optional<Exception> saveAddUser(Project project,User user){
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/java/org/taskmanagement401/data/projectUserList.csv", true));
            String strToAppend=project.getId()+","+user.getId();
            writer.append(strToAppend);
            writer.append("\n");
            writer.close();
        }catch (Exception e){
            return Optional.of(e);
        }
        return Optional.empty();
    }
}
