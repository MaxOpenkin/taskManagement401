package org.taskmanagement401.service.dataService.rewrite;

import org.taskmanagement401.entity.Project;
import org.taskmanagement401.repository.ProjectRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Optional;

public class RewriteProject {
    public Optional<Exception> rewrite(ProjectRepository projectRepository){
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/java/org/taskmanagement401/data/project.csv", false));
            boolean start=true;
            for(Project project: projectRepository.findAll() ){
                String strToAppend=project.getId()+","+project.getName()+","+ project.getDiscription()
                        +","+ (project.isStatus()?1:0);
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
