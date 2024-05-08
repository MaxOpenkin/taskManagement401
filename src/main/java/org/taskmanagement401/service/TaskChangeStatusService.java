package org.taskmanagement401.service;

import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.TaskRepository;

public class TaskChangeStatusService {
    public ResponseDTO changeStatus(Task task, TaskRepository taskRepository){
        task.setTaskCompleted(true);
        return new ResponseDTO(200,"Status ok");
    }
}
