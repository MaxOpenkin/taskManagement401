package org.taskmanagement401.service.dataService.save;

import org.taskmanagement401.entity.Message;
import org.taskmanagement401.repository.ChatRepository;

import javax.print.attribute.standard.MediaSize;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Optional;

public class SaveSMS_Service {
    public Optional<Exception> saveSMS(Message message){
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/java/org/taskmanagement401/data/sms.csv", true));
            String strToAppend=message.getId()+","+message.getSender()+","+ message.getReceiver()+","+
                    message.getContents()+","+message.getSendTime().getYear()+","
                    +message.getSendTime().getMonthValue()+","+message.getSendTime().getDayOfMonth()+","+
                    message.getSendTime().getHour()+","+message.getSendTime().getMinute()+","
                    +message.getSendTime().getSecond();
            writer.append(strToAppend);
            writer.append("\n");
            writer.close();
        }catch (Exception e){
            return Optional.of(e);
        }
        return Optional.empty();
    }
}
