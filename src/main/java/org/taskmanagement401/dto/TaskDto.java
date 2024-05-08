package org.taskmanagement401.dto;

import org.taskmanagement401.entity.Priority;
import org.taskmanagement401.entity.Task;

import java.time.LocalDate;

public class TaskDto {
    private String taskName;
    private LocalDate endDate;
    private Priority priority;

    public TaskDto(String taskName, LocalDate endDate, int statusPriority) {
        this.taskName = taskName;
        this.endDate = endDate;
        this.priority = Task.fromStatusPriority(statusPriority);
    }

    public String getTaskName() {
        return taskName;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Priority getPriority() {
        return priority;
    }

}
