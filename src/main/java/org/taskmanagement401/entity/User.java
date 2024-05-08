package org.taskmanagement401.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private int status;
    private List<Task> task=new ArrayList<>();
    private List<Message> sms=new ArrayList<>();

    public User(int id, String name, String login, String password, int status) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getStatus() {
        return status;
    }

    public List<Task> getTask() {
        return task;
    }
    public List<Task> getActiveTask() {
        List<Task> result=new ArrayList<>(task.stream()
                .filter(task1 -> !task1.isTaskCompleted()).toList());

        return result;
    }

    public List<Message> getSms() {
        return sms;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
