package org.taskmanagement401.service;


import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.repository.UserRepository;
import org.taskmanagement401.service.dataService.save.SaveTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddUserToTaskService {

    public static ResponseDTO assignUser (Task task, User user){
        List<ErrorDto> errors=new ArrayList<>();
        task.getAssignedUsers().add(user);
        user.getTask().add(task);
        SaveTask saveTask =new SaveTask();
        Optional<Exception> result=saveTask.saveAddUser(task,user);
        if(result.isPresent()){
            errors.add(new ErrorDto(ErrorCodes.DATASAVING.getStatusCode(),
                    ErrorCodes.DATASAVING.getDescription()+result.get().getMessage()));
            return new ResponseDTO<>(400,errors);
        }else {
            return new ResponseDTO<>(200, "Status ok");
        }
    }


}
