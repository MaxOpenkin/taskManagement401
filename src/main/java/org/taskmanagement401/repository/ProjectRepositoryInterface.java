package org.taskmanagement401.repository;

import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.entity.Project;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface ProjectRepositoryInterface {

    public Project addProject(ProjectDto dto);

    public Optional<Project> findById(int id);


    public List<Project> findAll();
    public HashMap<Integer, Project> getProjects();
    public List<Project> findAllActiveProjects();
    public boolean updateProjectDescription(int projectId, String newDescription);

}
