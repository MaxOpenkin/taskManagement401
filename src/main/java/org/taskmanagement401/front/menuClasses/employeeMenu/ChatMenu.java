package org.taskmanagement401.front.menuClasses.employeeMenu;

import org.taskmanagement401.dto.ChatDTO;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.entity.Message;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.repository.ChatRepository;
import org.taskmanagement401.repository.UserRepository;
import org.taskmanagement401.service.ChatService;
import org.taskmanagement401.service.util.PrintChatContacts;
import org.taskmanagement401.service.util.UserInput;

import java.util.List;
import java.util.Optional;

public class ChatMenu {

    public ChatMenu(User user, UserRepository userRepository, ChatRepository chatRepository) {
        System.out.println("Select chat contact: ");
        Optional<User> userOptional = PrintChatContacts.print(userRepository,user.getId());
        if (userOptional.isEmpty()) {
            System.out.println("Invalid user selection");
        }else {
            ChatService chat=new ChatService(chatRepository);
            List<Message> message=chat.get_SMS_WithContact(userOptional.get(),user);
             PrintChatContacts.printChat(message,user.getId());
            ChatDTO commentDto = new ChatDTO(UserInput.inputText("Enter new comment or press Enter Key to exit."));
            if(!commentDto.getSms().isEmpty()) {
                ResponseDTO response = chat.addNewSMS(commentDto, user, userOptional.get().getId());
                System.out.println(response);
            }
        }
    }
}
