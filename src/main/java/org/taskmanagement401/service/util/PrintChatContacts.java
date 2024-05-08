package org.taskmanagement401.service.util;

import org.taskmanagement401.entity.Message;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class PrintChatContacts {
    public static Optional<User> print(UserRepository userRepository,int userID){
        List<User> users = userRepository.getUsers();
        UserTalkService.printAllUsersForChat(userRepository.getUsers(),userID);

        int userChoice = UserInput.inputPositiveInt("Choose a user by ID: ");


        return  users.stream()
                .filter(user -> user.getId() == userChoice)
                .findFirst();
    }
    public static void printChat(List<Message> sms, int userId){
        for(Message message : sms){
            if(message.getReceiver()==userId){
                System.out.println(message.getSendTime());
                System.out.println(message.getContents());
                System.out.println();
            }else{
                System.out.println("                   "+message.getSendTime());
                System.out.println("                   "+message.getContents());
                System.out.println();
            }
        }
    }
}
