package org.taskmanagement401.repository;

import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UserRepository implements UserInterface {
    private final HashMap<Integer,User> users = new HashMap<>();
    private int currentId=0;
    public Optional<User> getUserIdByLoginAndPassword(UserDto dto){
        Optional<User> user=findUserByLogin(dto.getLogin());
        if (user.isEmpty()){
            return user;
        } else {
            if (user.get().getPassword().equals(dto.getPassword())) {
                    return user;
                }
                return Optional.empty();
        }
    }
    @Override
    public Optional<User> addNewUser(UserDto dto){
            Optional<User>user=createNewUser(dto,false);
            if(user.isEmpty()){
                return Optional.empty();
            }else{
                users.put(user.get().getId(),user.get());
                return user;
            }
    }
    @Override
    public Optional<User> addNewUser(UserDto dto,boolean boss){
        Optional<User>user=createNewUser(dto,boss);
        if(user.isEmpty()){
            return Optional.empty();
        }else{
            users.put(user.get().getId(),user.get());
            return user;
        }
    }
    private Optional<User> createNewUser(UserDto dto,boolean boss){
        if (findUserByLogin(dto.getLogin()).isEmpty()){
            currentId++;
            User user;
            if(boss) {
                user = new User(currentId, dto.getName(),
                        dto.getLogin(), dto.getPassword(), 1);
            }else{
                user = new User(currentId, dto.getName(), dto.getLogin(), dto.getPassword(), 2);
            }
            return Optional.of(user);
        }
        return Optional.empty();
    }
    private Optional<User> findUserByLogin(String login) {
        for (User user : users.values()) {
            if (user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
    public HashMap<Integer,User> getUsersMap() {
        return  users;
    }
    public List<User> getUsers() {
        if(users.isEmpty()){
            return new ArrayList<>();
        }
        return new ArrayList<>(users.values());
    }
    @Override
    public List<User> getUsersWithoutBoss() {
        if(users.isEmpty()){
            return new ArrayList<>();
        }
        return new ArrayList<>(users.values().stream().filter(x->x.getStatus()!=1).toList());
    }
    @Override
    public Optional<User> getUserById(int id){
        User user=users.get(id);
        if(user != null){
            return Optional.of(user);
        }else{
            return Optional.empty();
        }
    }

    public void setCurrentId(int currentId) {
        this.currentId = currentId;
    }
}
