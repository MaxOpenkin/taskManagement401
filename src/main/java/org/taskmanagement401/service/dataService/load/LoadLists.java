package org.taskmanagement401.service.dataService.load;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.ProjectRepository;
import org.taskmanagement401.service.ServicesGeneration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

public class LoadLists {
    public Optional<Exception> loadTasks(ServicesGeneration servicesGeneration)  {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/org/taskmanagement401/data/taskList.csv"));
            String line;
            while ((line=br.readLine())!= null){
                String[] elements=line.split(",");
                if(elements.length!=0) {
                    Task task=servicesGeneration.getTaskRepository()
                            .findById(Integer.parseInt(elements[1])).get();
                    servicesGeneration.getProjectRepository().findById(Integer.parseInt(elements[0])).get()
                            .getTasks().add(task);
                    task.setProject(servicesGeneration.getProjectRepository().findById(Integer.parseInt(elements[0])).get());

                }
              }
            br.close();
        }
        catch (Exception e) {
            return Optional.of(e);
        }
        return Optional.empty();
    }
    public Optional<Exception> loadUserToProject(ServicesGeneration servicesGeneration)  {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/org/taskmanagement401/data/projectUserList.csv"));
            String line;
            while ((line=br.readLine())!= null){
                String[] elements=line.split(",");
                if(elements.length!=0) {
                    servicesGeneration.getProjectRepository().findById(Integer.parseInt(elements[0])).get()
                            .getUsers().add(servicesGeneration.getUserRepository().getUserById
                                    (Integer.parseInt(elements[1])).get());
                }
            }
            br.close();
        }
        catch (Exception e) {
            return Optional.of(e);
        }
        return Optional.empty();
    }
    public Optional<Exception> loadUserToTask(ServicesGeneration servicesGeneration)  {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/org/taskmanagement401/data/taskUserList.csv"));
            String line;
            while ((line=br.readLine())!= null){
                String[] elements=line.split(",");
                if(elements.length!=0) {
                    Task task=servicesGeneration.getTaskRepository().findById(Integer.parseInt(elements[0])).get();
                    task
                            .getAssignedUsers().add(servicesGeneration.getUserRepository().getUserById
                                    (Integer.parseInt(elements[1])).get());
                    servicesGeneration.getUserRepository().getUserById
                            (Integer.parseInt(elements[1])).get().getTask().add(task

                    );
                }
            }
            br.close();
        }
        catch (Exception e) {
            return Optional.of(e);
        }
        return Optional.empty();
    }
    public Optional<Exception> loadCommentList(ServicesGeneration servicesGeneration)  {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/org/taskmanagement401/data/commentList.scv"));
            String line;
            while ((line=br.readLine())!= null){
                String[] elements=line.split(",");
                if(elements.length!=0) {
                    servicesGeneration.getTaskRepository().findById(Integer.parseInt(elements[0])).get()
                            .getComments().add(servicesGeneration.getCommentRepository().getCommentById
                                    (Integer.parseInt(elements[1])));
                }
            }
            br.close();
        }
        catch (Exception e) {
            return Optional.of(e);
        }
        return Optional.empty();
    }
}
