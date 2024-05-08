package org.taskmanagement401.service.dataService.load;

import org.taskmanagement401.entity.Message;
import org.taskmanagement401.repository.ChatRepository;
import org.taskmanagement401.repository.UserRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class LoadSMS_Service {
    public  Optional<Exception> load(UserRepository userRepository,
                                           ChatRepository chatRepository)  {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/org/taskmanagement401/data/sms.csv"));
           String line;
           int id=0;
            while ((line=br.readLine())!= null){
                String[] elements=line.split(",");
                if(elements.length!=0) {
                    Message sms = getMessage(elements);
                    userRepository.getUserById(Integer.parseInt(elements[1])).get().getSms().add(
                            sms
                    );
                    chatRepository.getSms().add(sms);
                    chatRepository.setId(++id);
                }
            }
            br.close();
        }
        catch (Exception e) {
            return Optional.of(e);
        }
        return Optional.empty();
    }

    private Message getMessage(String[] elements) {
        LocalDateTime date= LocalDateTime.of(Integer.parseInt(elements[4]),
                Integer.parseInt(elements[5]),Integer.parseInt(elements[6]),
                Integer.parseInt(elements[7]),Integer.parseInt(elements[8]),
                Integer.parseInt(elements[9])
         );
        Message sms=new Message(Integer.parseInt(elements[0]),
                Integer.parseInt(elements[1]),
                        Integer.parseInt(elements[2]), elements[3],
                                date);
        return sms;
    }


}
