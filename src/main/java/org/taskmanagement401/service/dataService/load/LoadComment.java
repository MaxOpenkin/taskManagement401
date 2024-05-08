package org.taskmanagement401.service.dataService.load;

import org.taskmanagement401.entity.Comment;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.CommentRepository;
import org.taskmanagement401.repository.TaskRepository;
import org.taskmanagement401.repository.UserRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

public class LoadComment {
    public Optional<Exception> load(UserRepository userRepository, CommentRepository commentRepository)  {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/org/taskmanagement401/data/comment.csv"));
            String line;
            int id=0;
            while ((line=br.readLine())!= null){
                String[] elements=line.split(",");
                if(elements.length!=0) {
                    User user = userRepository.getUserById(Integer.parseInt(elements[1])).get();
                    Comment comment =
                            new Comment(Integer.parseInt(elements[0]),
                                    user
                                    , elements[2]);
                    commentRepository.setId(++id);
                    commentRepository.getCommentList().put(id,comment);


                }
            }
            br.close();
        }
        catch (Exception e) {
            return Optional.of(e);
        }
        return Optional.empty();
    }
}
