package org.taskmanagement401.repository;

import org.taskmanagement401.dto.CommentDto;
import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface CommentInterface {
    public Comment add(User user, CommentDto commentDto, Task task);

    List<Comment> findAll();
    public Comment getCommentById(Integer id);
    public HashMap<Integer, Comment> getCommentList();



}
