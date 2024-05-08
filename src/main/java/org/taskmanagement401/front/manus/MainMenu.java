package org.taskmanagement401.front.manus;






import org.taskmanagement401.config.MenusItems;
import org.taskmanagement401.dto.ResponseDTO;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.entity.User;
import org.taskmanagement401.service.AuthorizationService;
import org.taskmanagement401.service.RegistrationService;
import org.taskmanagement401.service.ServicesGeneration;
import org.taskmanagement401.service.util.UserTalkService;

import java.util.ArrayList;


public class MainMenu {


    private Menu menu=new Menu();
    private MenusItems items=new MenusItems();
    private ArrayList<String> maneMenu= items.getMenu("Main");
    private RegistrationService registrationService;
    private AuthorizationService authorizationService;
    private  ServicesGeneration servicesGeneration;
    public MainMenu(ServicesGeneration services) {
        servicesGeneration=services;
        registrationService=new RegistrationService(services.getUserRepository());
        authorizationService=new AuthorizationService(services.getUserRepository());
        int userAnswer=0;
        while (userAnswer!=maneMenu.size()){
            menu.printMenu(maneMenu);
            userAnswer=menu.getUserChoice(maneMenu.size());
            manageMain(userAnswer);
        }
    }
    private void manageMain(int answer){
        switch (answer){
            case -1:
                menu.printError();
                break;
            case 1:
                UserTalkService.registrationInstructions();
                UserDto dto=UserTalkService.getUserParameters(true);
                ResponseDTO response=registrationService.registration(dto);
                if(response.getCode()==400){
                    System.out.println(response.getAnswer());
                }else{
                    User user =(User) response.getAnswer();
                    EmployeeMenu employeeMenu=new EmployeeMenu(user,servicesGeneration);
                }
                break;
            case 2:
                UserDto dtoAuthorization= UserTalkService.getUserParameters(false);
                ResponseDTO responseAuthorization=authorizationService.verification(dtoAuthorization);
                if(responseAuthorization.getCode()==400){
                    System.out.println(responseAuthorization.getAnswer());
                }else{
                    User user =(User) responseAuthorization.getAnswer();
                    if(user.getStatus()==2) {
                        EmployeeMenu employeeMenu = new EmployeeMenu(user,servicesGeneration);
                    }else{
                        BossMenu bossMenu=new BossMenu(user,servicesGeneration);
                    }
                }

                break;
        }
    }

}
