package org.taskmanagement401.service;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.repository.ProjectRepository;

import java.util.Optional;

public class ProjectStatusCheckService {

    private final ProjectRepository projectRepository;

    public ProjectStatusCheckService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public boolean hasIncompleteTasks(int projectId) {
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        if (projectOpt.isPresent()) {
            Project project = projectOpt.get();
            return project.getTasks().stream().anyMatch(task -> !task.isTaskCompleted());
        }
        return false;
    }
}
