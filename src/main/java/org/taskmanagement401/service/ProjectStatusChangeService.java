package org.taskmanagement401.service;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.dataService.rewrite.RewriteProject;

import java.util.Optional;

public class ProjectStatusChangeService {

    private final ProjectRepository projectRepository;

    public ProjectStatusChangeService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public boolean markProjectAsCompleted(int projectId) {
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        if (projectOpt.isPresent()) {
            Project project = projectOpt.get();
            project.setStatus(true);
            RewriteProject rewriteProject=new RewriteProject();
            rewriteProject.rewrite(projectRepository);
            return true;
        }
        return false;
    }
}
