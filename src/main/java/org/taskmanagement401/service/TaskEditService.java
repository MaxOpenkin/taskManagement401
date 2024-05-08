package org.taskmanagement401.service;

import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.entity.Priority;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.dataService.rewrite.RewriteTask;
import org.taskmanagement401.service.validation.TaskValidation;

import java.time.LocalDate;
import java.util.List;

public class TaskEditService {
    private TaskRepository taskRepository;
    private TaskValidation taskValidation;


    public TaskEditService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.taskValidation = new TaskValidation();
    }

    public ResponseDTO<String> editTaskName(int taskId, String newName) {
        List<ErrorDto> validationErrors = taskValidation.checkName(newName);
        if (!validationErrors.isEmpty()) {
            return new ResponseDTO<>(400, validationErrors.toString());
        }

        boolean updateSuccess = taskRepository.updateTaskName( taskId, newName);
        if (updateSuccess) {
            RewriteTask rewriteTask = new RewriteTask();
            rewriteTask.rewrite(taskRepository);
            return new ResponseDTO<>(200, "Task name updated successfully.");
        } else {
            return new ResponseDTO<>(404, "Task not found.");
        }
    }

    public ResponseDTO<String> editDateEnd(int taskId, LocalDate date) {
        List<ErrorDto> validationErrors = taskValidation.checkDate(date);
        if (!validationErrors.isEmpty()) {
            return new ResponseDTO<>(400, validationErrors.toString());
        }

        boolean updateSuccess = taskRepository.updateTaskDate( taskId, date);
        if (updateSuccess) {
            RewriteTask rewriteTask = new RewriteTask();
            rewriteTask.rewrite(taskRepository);
            return new ResponseDTO<>(200, "Task date updated successfully.");
        } else {
            return new ResponseDTO<>(404, "Task not found.");
        }
    }
    public ResponseDTO<String> editPriority(int taskId, int ststusPriority) {
        List<ErrorDto> validationErrors = taskValidation.checkPriority(ststusPriority);
        if (!validationErrors.isEmpty()) {
            return new ResponseDTO<>(400, validationErrors.toString());
        }

        boolean updateSuccess = taskRepository.updateTaskPriority(taskId,ststusPriority);
        if (updateSuccess) {
            RewriteTask rewriteTask = new RewriteTask();
            rewriteTask.rewrite(taskRepository);
            return new ResponseDTO<>(200, "Task priority updated successfully.");
        } else {
            return new ResponseDTO<>(404, "Task not found.");
        }
    }
}
