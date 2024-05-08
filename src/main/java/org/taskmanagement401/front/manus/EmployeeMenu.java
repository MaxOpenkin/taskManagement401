package org.taskmanagement401.front.manus;

import org.taskmanagement401.front.menuClasses.employeeMenu.ChatMenu;
import org.taskmanagement401.front.menuClasses.employeeMenu.CheckCommentMenuUser;
import org.taskmanagement401.front.menuClasses.employeeMenu.CommentMenu;
import org.taskmanagement401.front.menuClasses.employeeMenu.TaskStatusMenu;
import org.taskmanagement401.config.MenusItems;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.service.ServicesGeneration;

import java.util.ArrayList;

public class EmployeeMenu {
    private Menu menu=new Menu();
    private MenusItems items=new MenusItems();
    private ArrayList<String> employeeMenu= items.getMenu("Employee");
    ServicesGeneration servicesGeneration;
    public EmployeeMenu(User user, ServicesGeneration servicesGeneration) {
        this.servicesGeneration=servicesGeneration;
        int userAnswer=0;
        while (userAnswer!=employeeMenu.size()){
            menu.printMenu(employeeMenu);
            userAnswer=menu.getUserChoice(employeeMenu.size());
            manageMain(userAnswer,user);
        }
    }
    private void manageMain(int answer, User user){


        switch (answer){
            case -1:
                menu.printError();
                break;
            case 1:
                CommentMenu commentMenu = new CommentMenu( user ,
                        servicesGeneration.getCommentRepository());
                 break;
            case 2:
                TaskStatusMenu taskStatusMenu= new TaskStatusMenu(user,servicesGeneration.getTaskRepository());
                break;
            case 3:
                ChatMenu chatMenu=new ChatMenu(user,servicesGeneration.getUserRepository(),
                        servicesGeneration.getChatRepository());
                break;
            case 4:
                CheckCommentMenuUser checkCommentMenuUser=new CheckCommentMenuUser(user);
                break;
        }
    }
}
