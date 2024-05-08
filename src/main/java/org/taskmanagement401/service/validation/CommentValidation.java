package org.taskmanagement401.service.validation;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.ChatDTO;
import org.taskmanagement401.dto.CommentDto;
import org.taskmanagement401.dto.error.ErrorDto;

import java.util.ArrayList;
import java.util.List;

public class CommentValidation {
    public List<ErrorDto> checkComment (CommentDto text){
        List<ErrorDto> errors=new ArrayList<>();

        if(text.getComment().isBlank()) {
            errors.add(new ErrorDto(ErrorCodes.BLANKDATA.getStatusCode(),
                    ErrorCodes.BLANKDATA.getDescription()));
        }
        return errors;
    }
}
