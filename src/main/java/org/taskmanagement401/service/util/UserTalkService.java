package org.taskmanagement401.service.util;

import org.taskmanagement401.dto.ProjectDto;
import org.taskmanagement401.dto.TaskDto;
import org.taskmanagement401.dto.UserDto;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserTalkService {
    public static UserDto getUserParameters(boolean getWithUserName){
        String name="";
        if(getWithUserName){
            name=UserInput.inputText("Enter name of user");
        }
        String lastname=UserInput.inputText("Enter login");
        String position=UserInput.inputText("Enter password");
        return new UserDto(name,lastname,position);
    }
    public static void registrationInstructions(){
        System.out.println("The name must have from 3 to 20 letters.");
        System.out.println("The login and the password must have from 6 to 20 letters.");
        System.out.println("The password must contains letters and numbers." );
        System.out.println();
    }
    public static void projectInformation(){
        System.out.println("The name must have from 3 to 20 letters.");
        System.out.println("Description length must be longer then 10 letters.");
        System.out.println();
    }
    public static ProjectDto getProjectParameters(){
        String name="";
        name=UserInput.inputText("Enter name of project");
        String description=UserInput.inputText("Enter description");
        return new ProjectDto(name,description);
    }
    public  static TaskDto getTaskParameters(){
        String name= UserInput.inputText("Enter name of Task");
        LocalDate date = UserInput.inputDate("Enter deadline date in format dd.mm.yyyy");
        int priority = UserInput.inputPositiveInt("Enter priority(Use 3 for High priority, 2 - Medium, 1 - Low)");
        return new TaskDto(name, date, priority);
    }
    public static void taskInformation(){
        System.out.println("The task name should be from 3 to 20 letters.");
        System.out.println("Enter your date in (dd.mm.yy) format");
        System.out.println("Enter priority(Use 3 for High priority, 2 - Medium, 1 - Low)");
        System.out.println();
    }
    public static void printAllProjects(List<Project> projects){
        for(Project project:projects){
            if(!project.isStatus()){
                System.out.println(project.getId()+" "+project.getName());
            }
        }
     // public int getAnswer ukazali id projecra
     //
    }

    public static void printSelectedProjectTask(Project selectedProject) {
        List<Task> tasks = selectedProject.getTasks();
        for (Task task : tasks) {
            if (!task.isTaskCompleted()) {
                System.out.println(task.getTaskID() + " " + task.getTaskName());

               }

            }

        }


    public static void printAllTasks(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getPriority).reversed());
        for (Task task : tasks) {
            if (!task.isTaskCompleted()) {
                System.out.println(task.getTaskID() + " " + task.getTaskName() + " " + task.getPriority() + " " + task.getEndDate());

            }
        }
    }


    public static void printAllUsers(List<User> users){
        for(User user : users){
            if ( user.getStatus() != 1 ) {
            System.out.println(user.getId() + " " + user.getName());}
            if (!user.getTask().isEmpty()){
            System.out.println("                     user has tasks in other project: " );
            for (Task task : user.getTask()) {
                System.out.println("                     " + task.getTaskName());
            }
            }
        }
    }
    public static void printAllUsersForChat(List<User> users,int userID){
        for(User user : users){
                if(user.getId()!=userID) {
                    System.out.println(user.getId() + " " + user.getName());
                }
            }
    }
    public static void printAllTasksWithProjects(List<Task> tasks){
        tasks.sort(Comparator.comparing(Task::getProject).thenComparing(Task::getPriority));
        String projectName="";
        for(Task task : tasks){
            if(!projectName.equals(task.getProject().getName())){
                System.out.println("Project : "+task.getProject().getName());
                projectName=task.getProject().getName();
            }
                System.out.println("            Id - "+task.getTaskID()+":  "+task.getPriority()+"/"+ task.getTaskName() + "/" + task.getEndDate());

        }
    }

}
