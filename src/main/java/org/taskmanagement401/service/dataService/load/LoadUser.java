package org.taskmanagement401.service.dataService.load;

import org.taskmanagement401.entity.Message;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ChatRepository;
import org.taskmanagement401.repository.UserRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

public class LoadUser {

        public Optional<Exception> load(UserRepository userRepository)  {
            try {
                BufferedReader br = new BufferedReader(
                        new FileReader("src/main/java/org/taskmanagement401/data/user.csv"));
                String line;
                int id=0;
                while ((line=br.readLine())!= null){
                    String[] elements=line.split(",");

                    User user = new User(Integer.parseInt(elements[0]),elements[1],elements[2],elements[3],
                            Integer.parseInt(elements[4]));
                    userRepository.getUsersMap().put(user.getId(),user);
                    userRepository.setCurrentId(++id);
                }
                br.close();
            }
            catch (Exception e) {
                return Optional.of(e);
            }
            return Optional.empty();
        }
}
