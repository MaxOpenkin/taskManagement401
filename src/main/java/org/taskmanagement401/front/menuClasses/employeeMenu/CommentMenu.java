package org.taskmanagement401.front.menuClasses.employeeMenu;

import org.taskmanagement401.dto.CommentDto;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.CommentRepository;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.service.CommentService;
import org.taskmanagement401.service.util.*;
import java.util.Optional;

public class CommentMenu {
    public CommentMenu(User user,
                       CommentRepository commentRepository) {
        if(user.getTask().isEmpty()){
            System.out.println("You don`t have active tasks");
        }else {
            Optional<Task> taskOptional = PrintUserTasks.print(user);
            if (taskOptional.isEmpty()) {
                System.out.println("Wrong input data");
            } else {
                CommentDto commentDto = new CommentDto(UserInput.inputText("Enter new comment"));
                CommentService commentService = new CommentService(commentRepository);
                ResponseDTO responseDTO = commentService.addNewComment(user, commentDto, taskOptional.get());
                if(responseDTO.getCode()==200){
                   responseDTO=new ResponseDTO<>(200,"Status ok");
                }
                System.out.println(responseDTO);
            }
        }
        }

    }

