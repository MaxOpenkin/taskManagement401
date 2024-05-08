package org.taskmanagement401.service;

import org.junit.jupiter.api.Test;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.repository.ProjectRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProjectStatusChangeServiceTest {

    @Test
    void testMarkProjectAsCompletedSuccess() {
        ProjectRepository repository = new ProjectRepository() {
            private final Map<Integer, Project> projects = new HashMap<>();
            private int currentId = 1;
            @Override
            public Optional<Project> findById(int id) {
                return Optional.ofNullable(projects.get(id));
            }
            @Override
            public Project addProject(ProjectDto projectDto) {
                Project project = new Project(currentId++, projectDto.getName(), projectDto.getDescription());
                projects.put(project.getId(), project);
                return project;
            }
        };

        ProjectDto projectDto = new ProjectDto("Test Project", "This is a test project.");
        repository.addProject(projectDto);

        ProjectStatusChangeService service = new ProjectStatusChangeService(repository);
        boolean result = service.markProjectAsCompleted(1);

        assertTrue(result, "The method should return true, indicating a successful status change.");
        Optional<Project> updatedProject = repository.findById(1);
        assertTrue(updatedProject.isPresent() && updatedProject.get().isStatus(), "The project status should be changed to 'completed'.");
    }


    @Test
    void testMarkProjectAsCompletedProjectNotFound() {
        ProjectRepository repository = new ProjectRepository() {
            private final Map<Integer, Project> projects = new HashMap<>();
            private int currentId = 1;
            @Override
            public Optional<Project> findById(int id) {
                return Optional.ofNullable(projects.get(id));
            }
            @Override
            public Project addProject(ProjectDto projectDto) {
                Project project = new Project(currentId++, projectDto.getName(),  projectDto.getDescription());
                projects.put(project.getId(), project);
                return project;
            }

        };

        ProjectStatusChangeService service = new ProjectStatusChangeService(repository);
        boolean result = service.markProjectAsCompleted(1);
        assertFalse(result, "The method should return false, as the project with the specified ID was not found.");
    }

}