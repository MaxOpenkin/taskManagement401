package org.taskmanagement401.service.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.error.ErrorDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectValidationTest {

    private ProjectValidation validation;

    @BeforeEach
    void setUp() {
        validation = new ProjectValidation();
    }

    @Test
    void checkProject_ValidProject() {
        ProjectDto projectDto = new ProjectDto("Valid Name", "Valid description that is definitely longer than 10 characters");
        assertTrue(validation.checkProject(projectDto).isEmpty());
    }

    @Test
    void checkProject_InvalidName() {
        ProjectDto projectDto = new ProjectDto("No", "Valid description that is definitely longer than 10 characters");
        List<ErrorDto> errors = validation.checkProject(projectDto);
        assertEquals(1, errors.size());
        assertEquals(ErrorCodes.WRONGNAME.getStatusCode(), errors.get(0).getCode());
    }

    @Test
    void checkProject_InvalidDescription() {
        ProjectDto projectDto = new ProjectDto("Valid Name", "Short");
        List<ErrorDto> errors = validation.checkProject(projectDto);
        assertEquals(1, errors.size());
        assertEquals(ErrorCodes.WRONGDESCRIPTIONLENGTH.getStatusCode(), errors.get(0).getCode());
    }

    @Test
    void checkDescription_ValidDescription() {
        String validDescription = "This is a valid project description that is definitely longer than 10 characters.";
        assertTrue(validation.checkDescription(validDescription).isEmpty());
    }

    @Test
    void checkDescription_InvalidDescription() {
        String shortDescription = "Short";
        List<ErrorDto> errors = validation.checkDescription(shortDescription);
        assertEquals(1, errors.size());
        assertEquals(ErrorCodes.WRONGDESCRIPTIONLENGTH.getStatusCode(), errors.get(0).getCode());
    }

}