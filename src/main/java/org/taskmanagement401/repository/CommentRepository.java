package org.taskmanagement401.repository;

import org.taskmanagement401.dto.CommentDto;
import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CommentRepository implements CommentInterface {

    private HashMap<Integer,Comment> commentList;
    private int id = 0;

    public CommentRepository() {
        this.commentList = new HashMap<>();
    }

  private Comment create ( CommentDto commentDto,User user){
        return new Comment(++id,user,commentDto.getComment());
  }
    @Override
    public Comment add(User user, CommentDto commentDto, Task task) {
        Comment comment=create(commentDto,user);
        commentList.put(comment.getId(),comment);
        task.getComments().add(comment);
      return comment;

    }
    @Override
    public Comment getCommentById(Integer id){
        return commentList.get(id);
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public HashMap<Integer, Comment> getCommentList() {
        return commentList;
    }
    @Override
    public List<Comment> findAll(){
        return new ArrayList<>(commentList.values());
    }
}
