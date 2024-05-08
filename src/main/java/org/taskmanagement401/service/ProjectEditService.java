package org.taskmanagement401.service;

import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.dataService.rewrite.RewriteProject;
import org.taskmanagement401.service.validation.ProjectValidation;

import java.util.List;

public class ProjectEditService {

    private ProjectRepository projectRepository;
    private ProjectValidation validation;

    public ProjectEditService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        this.validation = new ProjectValidation();
    }


    public ResponseDTO<String> editProjectDescription(int projectId, String newDescription) {
        // Валидация нового описания
        List<ErrorDto> validationErrors = validation.checkDescription(newDescription);
        if (!validationErrors.isEmpty()) {
            return new ResponseDTO<>(400, validationErrors.toString());
        }

        // Обновление описания проекта
        boolean updateSuccess = projectRepository.updateProjectDescription(projectId, newDescription);
        if (updateSuccess) {
            RewriteProject rewriteProject=new RewriteProject();
            rewriteProject.rewrite(projectRepository);
            return new ResponseDTO<>(200, "Description updated successfully.");
        } else {
            return new ResponseDTO<>(404, "Project not found.");
        }
    }

}
