package org.taskmanagement401.service.validation;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.dto.error.ErrorDto;

import java.util.ArrayList;
import java.util.List;

public class ProjectValidation {
    public List<ErrorDto> checkProject(ProjectDto dto){
        List<ErrorDto> errors=new ArrayList<>();
        if(dto.getDescription().length()<10){
            errors.add(new ErrorDto(ErrorCodes.WRONGDESCRIPTIONLENGTH.getStatusCode(),
                    ErrorCodes.WRONGDESCRIPTIONLENGTH.getDescription()));
        }
        if(dto.getName().length()<3 || dto.getName().length()>20){
            errors.add(new ErrorDto(ErrorCodes.WRONGNAME.getStatusCode(), ErrorCodes.WRONGNAME.getDescription()));
        }
        return errors;
    }

    public List<ErrorDto> checkDescription(String description) {
        List<ErrorDto> errors = new ArrayList<>();

        if(description.length() < 10) {
            errors.add(new ErrorDto(ErrorCodes.WRONGDESCRIPTIONLENGTH.getStatusCode(),
                    ErrorCodes.WRONGDESCRIPTIONLENGTH.getDescription()));
        }
        return errors;
    }

}
