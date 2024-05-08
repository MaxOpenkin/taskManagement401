package org.taskmanagement401.entity;

public class Comment {
    private int id;
    private User user;
    private String message;

    public Comment(int id,User user, String message) {
        this.id=id;
        this.user = user;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", message='" + message + '\'' +
                '}';
    }
}
