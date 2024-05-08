package org.taskmanagement401.front.manus;

import org.taskmanagement401.config.MenusItems;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.front.menuClasses.bossMenu.*;
import org.taskmanagement401.service.*;
import org.taskmanagement401.front.menuClasses.employeeMenu.ChatMenu;

import java.util.ArrayList;

public class BossMenu {
    private Menu menu=new Menu();
    private MenusItems items=new MenusItems();
    ServicesGeneration servicesGeneration;
    ArrayList<String> bossMenu= items.getMenu("Chef");
    User user;
    public BossMenu(User user, ServicesGeneration servicesGeneration) {
       this.user=user;
        this.servicesGeneration=servicesGeneration;
        int userAnswer=0;
        while (userAnswer!=bossMenu.size()){
            menu.printMenu(bossMenu);
            userAnswer=menu.getUserChoice(bossMenu.size());
            manageMain(userAnswer);
        }
    }
    private void manageMain(int answer){
        switch (answer){
            case -1:
                menu.printError();
                break;
            case 1:
                AddProjectMenu addProjectMenu=new AddProjectMenu(
                        servicesGeneration.getProjectRepository()
                );

                break;
            case 2:
                EditProjectMenu editProjectMenu=new EditProjectMenu(
                        servicesGeneration.getProjectRepository()
                );
                break;
            case 3:
                AddTaskMenu addTaskMenu=new
                AddTaskMenu(servicesGeneration.getProjectRepository(),
                        servicesGeneration.getTaskRepository()
                );
                break;
            case 4:
                AddUserToProjectMenu addUserToProjectMenu=new AddUserToProjectMenu(
                        servicesGeneration.getProjectRepository(),
                        servicesGeneration.getUserRepository()
                );
                break;

            case 5:
                AddUserToTaskMenu addUserToTaskMenu=new AddUserToTaskMenu(
                  servicesGeneration.getProjectRepository(),
                        servicesGeneration.getTaskRepository()
                );
                break;
            case 6:
                CheckProjectMenu checkProjectMenu=new CheckProjectMenu(
                        servicesGeneration.getProjectRepository()
                );
                break;
            case 7:
            ChatMenu chatMenu=new ChatMenu(user,servicesGeneration.getUserRepository(),
                    servicesGeneration.getChatRepository());
                break;
            case 8:
                CheckCommentMenu checkComment=new CheckCommentMenu(servicesGeneration.getProjectRepository(),
                        servicesGeneration.getTaskRepository());
                break;
            case 9:
                EditTaskMenu editTaskMenu=new EditTaskMenu(servicesGeneration.getProjectRepository(),
                        servicesGeneration.getTaskRepository());
                break;
        }
    }
}
