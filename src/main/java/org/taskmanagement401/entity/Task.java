package org.taskmanagement401.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task {
    private Integer taskID;
    private String taskName;
    private LocalDate endDate;
    private List<User> assignedUsers =new ArrayList<>();
    private Priority priority;
    private boolean taskCompleted;
    private List<Comment> comments=new ArrayList<>();
    private Project project;

    public Task(Integer taskID, String taskName, LocalDate endDate, int statusPriority) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.priority = fromStatusPriority(statusPriority);
        this.endDate = endDate;
    }

    public Integer getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<User> getAssignedUsers() {
        return assignedUsers;
    }


    public Priority getPriority() {
        return priority;
    }
    public int getPriorityValue(){
        return priority.getStatusPriority();
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public List<Comment> getComments() {
        return comments;
    }

   public void setTaskID(Integer taskID) {
        this.taskID = taskID;
    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public static Priority fromStatusPriority(int statusPriority) {
        if (statusPriority == 3) {
            return Priority.HIGH;
        } else if (statusPriority == 2) {
            return Priority.MEDIUM;
        } else if (statusPriority == 1) {
            return Priority.LOW;
        }
        return null;
    }

    public Project getProject() {
        return project;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Task task)) return false;
        return Objects.equals(taskID, task.taskID) && Objects.equals(taskName, task.taskName) && Objects.equals(assignedUsers, task.assignedUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskID, taskName, assignedUsers);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskID='" + taskID + '\'' +
                ", taskName='" + taskName + '\'' +
                ", endDate=" + endDate +
                ", assignedUsers=" + assignedUsers +
                ", priority=" + priority +
                ", taskCompleted=" + taskCompleted +
                ", comments=" + comments +
                '}';
    }
}
