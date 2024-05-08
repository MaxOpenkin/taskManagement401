package org.taskmanagement401.service;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.service.dataService.save.SaveProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddUserToProjectService {
    public static ResponseDTO assignUser (Project project, User user){
        List<ErrorDto> errors=new ArrayList<>();
        project.getUsers().add(user);
        SaveProject saveProject=new SaveProject();
        Optional<Exception> result=saveProject.saveAddUser(project,user);
        if(result.isPresent()){
            errors.add(new ErrorDto(ErrorCodes.DATASAVING.getStatusCode(),
                    ErrorCodes.DATASAVING.getDescription()+result.get().getMessage()));
            return new ResponseDTO<>(400,errors);
        }else {
            return new ResponseDTO<>(200, "Status ok");
        }

    }
}
