package org.taskmanagement401.service;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.UserRepository;
import org.taskmanagement401.service.dataService.save.SaveSMS_Service;
import org.taskmanagement401.service.dataService.save.SaveUser;
import org.taskmanagement401.service.util.UserTalkService;
import org.taskmanagement401.service.validation.UserValidation;

import java.util.List;
import java.util.Optional;

public class RegistrationService {

    private UserValidation validation=new UserValidation();
    private UserRepository repository;

    public RegistrationService(UserRepository repository) {

        this.repository = repository;
    }

    public ResponseDTO registration(UserDto dto){
        List<ErrorDto> errors=validation.checkUser(dto);
        if(errors.isEmpty()){
            Optional<User> user=repository.addNewUser(dto,false);
            if(user.isEmpty()){
                errors.add(new ErrorDto(ErrorCodes.WRONGNEWLOGIN.getStatusCode(),
                        ErrorCodes.WRONGNEWLOGIN.getDescription()));
                return new ResponseDTO<>(400,errors);
            }else{
                SaveUser save=new SaveUser();
                Optional<Exception> result=save.saveUser(user.get());
                if(result.isPresent()){
                    errors.add(new ErrorDto(ErrorCodes.DATASAVING.getStatusCode(),
                            ErrorCodes.DATASAVING.getDescription()+result.get().getMessage()));
                    return new ResponseDTO<>(400,errors);
                }else {
                    return new ResponseDTO<>(200, user.get());
                }
            }

        }else{
            return new ResponseDTO<>(400,errors);
        }
    }
}
