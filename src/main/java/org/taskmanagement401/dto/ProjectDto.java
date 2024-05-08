package org.taskmanagement401.dto;

public class ProjectDto {


    private String name;
    private String discription;



    public ProjectDto ( String name, String discription) {

        this.name = name;
        this.discription = discription;

    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return discription;
    }

}
