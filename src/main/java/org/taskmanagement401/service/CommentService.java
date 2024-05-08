package org.taskmanagement401.service;

import org.taskmanagement401.config.ErrorCodes;
import org.taskmanagement401.dto.CommentDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.error.ErrorDto;
import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.CommentRepository;
import org.taskmanagement401.service.dataService.save.SaveComment;
import org.taskmanagement401.service.validation.CommentValidation;

import java.util.List;
import java.util.Optional;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    private Comment commentCreate(){
        return null;
    }
    //vernut DTO response
    public ResponseDTO addNewComment(User user, CommentDto commentDto, Task task) {
        CommentValidation validation = new CommentValidation();
        List<ErrorDto> errors =
                validation.checkComment(commentDto);

        if (errors.isEmpty()) {
            Comment comment=commentRepository.add(user, commentDto, task);
            SaveComment saveComment= new SaveComment();
            Optional<Exception> result=saveComment.save(comment);
            if(result.isPresent()){
                errors.add(new ErrorDto(ErrorCodes.DATASAVING.getStatusCode(),
                        ErrorCodes.DATASAVING.getDescription()+result.get().getMessage()));
                return new ResponseDTO<>(400,errors);
            }
            result=saveComment.saveList(task,comment);
            if(result.isPresent()){
                errors.add(new ErrorDto(ErrorCodes.DATASAVING.getStatusCode(),
                        ErrorCodes.DATASAVING.getDescription()+result.get().getMessage()));
                return new ResponseDTO<>(400,errors);
            }else {
                return new ResponseDTO<>(200, "Status ok");
            }
      } else {
            return new ResponseDTO<>(400, errors);
        }
    }
}

