package org.taskmanagement401.front.manus;




import org.taskmanagement401.service.util.UserInput;

import java.util.ArrayList;

public class Menu {

    public void printMenu(ArrayList<String> menus){
        System.out.println("Menu");
        for (int i=0;i<menus.size();i++){
            System.out.println();
            System.out.println((i+1)+": "+menus.get(i));
        }
    }
    public int getUserChoice(int count){
        int i= UserInput.inputPositiveInt("Enter your`s choose");
        System.out.println();
        if (i>0 && i<=count){
            return i;
        }else {
            return -1;
        }
    }
    public void printError() {
        System.out.println("You entered wrong data, please be careful!");
        System.out.println();
    }
}
