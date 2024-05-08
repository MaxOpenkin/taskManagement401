package org.taskmanagement401.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.entity.Project;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProjectRepositoryTest {

    private ProjectRepository repository;

    @BeforeEach
    void setUp() {
        repository = new ProjectRepository();
    }

    @Test
    void addProjectTest() {
        ProjectDto testProjectDto = new ProjectDto("Test Project", "This is a test project");
        repository.addProject(testProjectDto);
        Optional<Project> addedProjectOpt = repository.findById(1);
        assertTrue(addedProjectOpt.isPresent());
        addedProjectOpt.ifPresent(project -> {
            assertEquals("Test Project", project.getName());
            assertEquals("This is a test project", project.getDiscription());
        });
    }

    @Test
    void updateProjectDescription_Success() {
        ProjectDto testProjectDto = new ProjectDto("Test Project", "Initial Description");
        repository.addProject(testProjectDto);
        boolean isUpdated = repository.updateProjectDescription(1, "Updated Description");

        assertTrue(isUpdated);

        Optional<Project> updatedProject = repository.findById(1);
        assertTrue(updatedProject.isPresent());
        updatedProject.ifPresent(project ->
                assertEquals("Updated Description", project.getDiscription())
        );
    }

    @Test
    void updateProjectDescription_Failure_ProjectNotFound() {
        boolean isUpdated = repository.updateProjectDescription(99, "Updated Description");
        assertFalse(isUpdated);
    }

    @Test
    void findById_ProjectExists() {
        ProjectDto testProjectDto = new ProjectDto("Test Project", "Test Description");
        repository.addProject(testProjectDto);
        Optional<Project> foundProject = repository.findById(1);

        assertTrue(foundProject.isPresent());

        foundProject.ifPresent(project -> {
            assertEquals("Test Project", project.getName());
            assertEquals("Test Description", project.getDiscription());
        });
    }

    @Test
    void findById_ProjectDoesNotExist() {
        Optional<Project> foundProject = repository.findById(99);

        assertFalse(foundProject.isPresent());
    }

    @Test
    void findAll_WithNoProjects() {
        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    void findAll_WithProjects() {
        repository.addProject(new ProjectDto("Project 1", "Description 1"));
        repository.addProject(new ProjectDto("Project 2", "Description 2"));

        assertEquals(2, repository.findAll().size());
    }

    @Test
    void findAllActiveProjects_OnlyActive() {
        ProjectDto activeProjectDto = new ProjectDto("Active Project", "Active Description");
        ProjectDto completedProjectDto = new ProjectDto("Completed Project", "Completed Description");

        repository.addProject(activeProjectDto);
        repository.addProject(completedProjectDto);

        Optional<Project> completedProjectOpt = repository.findAll().stream()
                .filter(project -> "Completed Project".equals(project.getName()))
                .findFirst();

        assertTrue(completedProjectOpt.isPresent());
        Project completedProject = completedProjectOpt.get();
        completedProject.setStatus(true);

        List<Project> activeProjects = repository.findAllActiveProjects();
        assertEquals(1, activeProjects.size());
        assertEquals("Active Project", activeProjects.get(0).getName());
    }

}