package org.taskmanagement401.service;

import org.junit.jupiter.api.Test;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.ProjectRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProjectStatusCheckServiceTest {

    @Test
    void testHasIncompleteTasksWithIncompleteTasks() {
        Project project = new Project(4, "Project5", "Project5 description bla bla bla");
        Task task = new Task(7, "Task6", LocalDate.of(2024,4,25),2);
        task.setTaskCompleted(false);
        project.getTasks().add(task);
        ProjectRepository repository = new ProjectRepository() {
            @Override
            public Optional<Project> findById(int id) {
                if (id == project.getId()) {
                    return Optional.of(project);
                }
                return Optional.empty();
            }
        };
        ProjectStatusCheckService service = new ProjectStatusCheckService(repository);
        boolean result = service.hasIncompleteTasks(project.getId());
        assertTrue(result, "Should return true for a project with incomplete tasks.");
    }

    @Test
    void testHasIncompleteTasksWithAllTasksCompleted() {
        Project project = new Project(4, "Project5", "Project5 description bla bla bla");
        Task task = new Task(7, "Task6", LocalDate.of(2024,4,25),2);
        task.setTaskCompleted(true);
        project.getTasks().add(task);
        ProjectRepository repository = new ProjectRepository() {
            @Override
            public Optional<Project> findById(int id) {
                if (id == project.getId()) {
                    return Optional.of(project);
                }
                return Optional.empty();
            }
        };
        ProjectStatusCheckService service = new ProjectStatusCheckService(repository);
        boolean result = service.hasIncompleteTasks(project.getId());
        assertFalse(result, "Should return false for a project with incomplete tasks.");
    }

}