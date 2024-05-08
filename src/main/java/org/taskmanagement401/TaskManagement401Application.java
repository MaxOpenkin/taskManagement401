package org.taskmanagement401;

import org.taskmanagement401.config.Preloader;
import org.taskmanagement401.service.ServicesGeneration;
import org.taskmanagement401.front.manus.MainMenu;

public class TaskManagement401Application {

    public static void main(String[] args) {

        ServicesGeneration mainServices=new ServicesGeneration();

        Preloader preloader=new Preloader(mainServices);

        MainMenu app=new MainMenu(mainServices);

    }

}
