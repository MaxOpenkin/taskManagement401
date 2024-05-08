package org.taskmanagement401.service;

import org.junit.jupiter.api.Test;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationServiceTest {

    @Test
    void registration() {
        UserDto dto=new UserDto("j","k","");
        UserRepository repository =new UserRepository();
        RegistrationService service=new RegistrationService(repository);
        ResponseDTO responseDTO=service.registration(dto);
        assertEquals(400,responseDTO.getCode());
    }
    @Test
    void registration2() {
        UserDto dto=new UserDto("User","User11","password11");
        UserRepository repository =new UserRepository();
        RegistrationService service=new RegistrationService(repository);
        ResponseDTO responseDTO=service.registration(dto);
        assertEquals(200,responseDTO.getCode());
    }
    @Test
    void registration3() {
        UserDto dto=new UserDto("111","11","11");
        UserRepository repository =new UserRepository();
        RegistrationService service=new RegistrationService(repository);
        ResponseDTO responseDTO=service.registration(dto);
        assertEquals(400,responseDTO.getCode());
    }
}