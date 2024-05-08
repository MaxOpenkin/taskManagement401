package org.taskmanagement401.service.validation;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.dto.error.ErrorDto;

import java.util.ArrayList;
import java.util.List;

public class UserValidation {
    public List<ErrorDto> checkUser(UserDto dto){
        List<ErrorDto> errors=new ArrayList<>();
        if(dto.getName().length()<3 || dto.getName().length()>20){
            errors.add(new ErrorDto(ErrorCodes.WRONGNAME.getStatusCode(), ErrorCodes.WRONGNAME.getDescription()));
        }
        if(dto.getLogin().length()<6 || dto.getLogin().length()>20){
            errors.add(new ErrorDto(ErrorCodes.WRONGLOGIN.getStatusCode(), ErrorCodes.WRONGLOGIN.getDescription()));
        }
        if(dto.getPassword().length()<6 || dto.getPassword().length()>20){
            errors.add(new ErrorDto(ErrorCodes.WRONGPASSLENGTH.getStatusCode(), ErrorCodes.WRONGPASSLENGTH.getDescription()));
        }
        if(!checkPass(dto.getPassword())){
            errors.add(new ErrorDto(ErrorCodes.WRONGPASSCOMBINATION.getStatusCode(), ErrorCodes.WRONGPASSCOMBINATION.getDescription()));
        }
        return errors;
    }
    public List<ErrorDto> checkUserAuthorization(UserDto dto){
        List<ErrorDto> errors=new ArrayList<>();
        if(dto.getLogin().isBlank() || dto.getPassword().isBlank()){
            errors.add(new ErrorDto(ErrorCodes.WRONGLOGINDATA.getStatusCode(),
                    ErrorCodes.WRONGLOGINDATA.getDescription()));
        }
        return errors;
    }
    private boolean checkPass(String pass) {
        boolean letters = false;
        boolean numbers = false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isLetter(pass.charAt(i))) {
                letters = true;
            }
            if ((int) pass.charAt(i) > 47 && (int) pass.charAt(i) < 58) {
                numbers = true;
            }

        }
        return letters && numbers;
    }
}
