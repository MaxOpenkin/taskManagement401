package org.taskmanagement401.repository;

import org.taskmanagement401.entity.Message;
import org.taskmanagement401.entity.User;

import java.util.List;

public interface ChatInterface {

     Message addSMS(String content, User sender, int receiver);

}
