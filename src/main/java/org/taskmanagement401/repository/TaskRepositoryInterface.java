package org.taskmanagement401.repository;

import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryInterface {
    Task addTask(TaskDto newTask);


    public Optional<Task> findById(Integer id);

    public Optional<Task> findByName(String taskName);

    public List<Task> findAll();
    public Optional<Task> getTaskById(int id);
    public void delete (String taskId);
}
