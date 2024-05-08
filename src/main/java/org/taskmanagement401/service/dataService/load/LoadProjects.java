package org.taskmanagement401.service.dataService.load;
import org.taskmanagement401.entity.Project;
import org.taskmanagement401.repository.ProjectRepository;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

public class LoadProjects {
    public Optional<Exception> load(ProjectRepository projectRepository)  {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/org/taskmanagement401/data/project.csv"));
            String line;
            int id=0;
            while ((line=br.readLine())!= null){
                String[] elements=line.split(",");
                if(elements.length!=0) {
                    Project project = new Project(Integer.parseInt(elements[0]), elements[1], elements[2]);
                    project.setStatus(elements[3].equals("1"));
                    projectRepository.getProjects().put(project.getId(), project);
                    projectRepository.setCurrentId(++id);
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
