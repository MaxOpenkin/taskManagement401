package org.taskmanagement401.service.dataService.save;

import org.taskmanagement401.entity.Message;
import org.taskmanagement401.entity.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Optional;

public class SaveUser {
    public Optional<Exception> saveUser(User user){
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/java/org/taskmanagement401/data/user.csv", true));
            String strToAppend=user.getId()+","+user.getName()+","+ user.getLogin()+","+
                    user.getPassword()+","+user.getStatus();
            writer.append(strToAppend);
            writer.append("\n");
            writer.close();
        }catch (Exception e){
            return Optional.of(e);
        }
        return Optional.empty();
    }
}
