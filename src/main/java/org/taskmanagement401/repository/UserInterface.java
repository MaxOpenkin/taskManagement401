package org.taskmanagement401.repository;

import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserInterface {
    public Optional<User> addNewUser(UserDto dto);
    public Optional<User> addNewUser(UserDto dto,boolean boss);
    public Optional<User> getUserById(int id);
    public List<User> getUsersWithoutBoss();
}
