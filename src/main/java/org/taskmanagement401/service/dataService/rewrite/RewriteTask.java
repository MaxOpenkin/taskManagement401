package org.taskmanagement401.service.dataService.rewrite;

import org.taskmanagement401.entity.Task;
import org.taskmanagement401.repository.TaskRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Optional;

public class RewriteTask {
    public Optional<Exception> rewrite(TaskRepository taskRepository){
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/java/org/taskmanagement401/data/task.csv", false));
            boolean start=true;
            for(Task task: taskRepository.findAll() ){
                String strToAppend = task.getTaskID() + "," + task.getTaskName() + "," +
                        task.getEndDate().getYear() + "," + task.getEndDate().getMonthValue() +
                        "," + task.getEndDate().getDayOfMonth() + "," + task.getPriorityValue()
                        + "," + (task.isTaskCompleted() ? 1 : 0);
                if(!start) {
                    writer.append("\n");
                }
                writer.append(strToAppend);
                start=false;
            }
            writer.close();
        }catch (Exception e){
            return Optional.of(e);
        }
        return Optional.empty();
    }
}
