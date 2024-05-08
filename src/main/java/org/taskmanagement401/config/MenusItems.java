package org.taskmanagement401.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MenusItems {
    private  final HashMap<String, ArrayList<String>> menus=new HashMap<>();

    public MenusItems() {
        ArrayList<String> menu=new ArrayList<>(Arrays.
                asList( "Registration",
                        "Authorization",
                        "Exit"));
        menus.put("Main",menu);


        menu=new ArrayList<>(Arrays.
        asList( "Add project",
                "Editing project",
                "Add task",
                "Add user to project",
                "Add user to task",
                "Check progress of projects",
                "Chat",
                "Check tasks comments",
                "Edit task",
                "Exit"));
        menus.put("Chef",menu);

        menu=new ArrayList<>(Arrays.
        asList(
                "Comment task",
                "Change task status",
                "Chat",
                "Check tasks comments",
                "Exit"));
        menus.put("Employee",menu);


    }
    public  ArrayList<String> getMenu(String menuItem){
        return menus.get(menuItem);
    }
}
