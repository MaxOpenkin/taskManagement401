package org.taskmanagement401.service;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.dataService.save.SaveProject;
import org.taskmanagement401.service.util.UserTalkService;
import org.taskmanagement401.service.validation.ProjectValidation;

import java.util.List;
import java.util.Optional;

public class ProjectAddService {
    ProjectValidation validation=new ProjectValidation();
    ProjectRepository projectRepository;

    public ProjectAddService(ProjectRepository projectRepository) {

        this.projectRepository = projectRepository;
    }
    public ResponseDTO registration(ProjectDto dto){

         List<ErrorDto> errors=
                validation.
                        checkProject(dto);
        if(errors.isEmpty()){
            SaveProject saveProject=new SaveProject();
            Optional<Exception> result=saveProject.save(projectRepository.addProject(dto));
            if(result.isPresent()){
                errors.add(new ErrorDto(ErrorCodes.DATASAVING.getStatusCode(),
                        ErrorCodes.DATASAVING.getDescription()+result.get().getMessage()));
                return new ResponseDTO<>(400,errors);
            }else {
                return new ResponseDTO<>(200, "Status ok");
            }
            }else {
            return new ResponseDTO<>(400, errors);
        }
    }
}
