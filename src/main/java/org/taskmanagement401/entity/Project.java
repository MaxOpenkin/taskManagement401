package org.taskmanagement401.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project implements Comparable<Project>{

    private int id;
    private String name;
    private String discription;

    private List<User> users = new ArrayList<>();;
    private List<Task> tasks = new ArrayList<>();;

    private boolean status;

    /*на коллекции не добавляла пока Getter&Setter, а сами поля закомментировала, потому что ошибку выдает -
    нет переменной, на которую можно сослаться

     */


    public Project(int id, String name, String discription) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.users = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                ", users=" + users +
                ", tasks=" + tasks +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        return status == project.status && Objects.equals(id, project.id) && Objects.equals(name, project.name) && Objects.equals(discription, project.discription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, discription, status);
    }


    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public int compareTo(Project o) {
        return o.getId()-id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}

