package org.taskmanagement401.service.dataService.load;

import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.TaskRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Optional;

public class LoadTask {
    public Optional<Exception> load(TaskRepository taskRepository)  {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/org/taskmanagement401/data/task.csv"));
            String line;
            int id=0;
            while ((line=br.readLine())!= null){
                String[] elements=line.split(",");
                if(elements.length!=0) {
                    LocalDate date = LocalDate.of(Integer.parseInt(elements[2])
                            , Integer.parseInt(elements[3]), Integer.parseInt(elements[4]));
                    Task task = new Task(Integer.parseInt(elements[0]), elements[1], date, Integer.parseInt(elements[5]));

                    task.setTaskCompleted(elements[6].equals("1"));
                    taskRepository.findAll().add(task);
                    taskRepository.setId(++id);
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
