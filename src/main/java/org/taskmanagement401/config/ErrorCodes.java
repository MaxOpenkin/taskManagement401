package org.taskmanagement401.config;

public enum ErrorCodes {
    WRONGNAME("The length of name must be les then 20 and more then 2 letters.",400),
    WRONGLOGIN("The length of login must be les then 20 and more then 5 letters.",401),
    WRONGPASSLENGTH("The length of password must be les then 20 and more then 5 letters.",402),
    WRONGPASSCOMBINATION("The password must contain letters and numbers.",403),
    WRONGNEWLOGIN("The user with your login is already exist. Registration is impossible.",404),
    WRONGLOGINDATA("Login or password is wrong.",405),
    WRONGDESCRIPTIONLENGTH("Description length must be longer then 10 letters.",406),
    WRONGDATE("Wrong date",407),
    WRONGPRIORITYSTATUS("Wrong status",408),
    BLANKDATA("The entered data must not be blank. ",411),
    DATASAVING("Error with database update:  ",412);

    private String description;
    private int statusCode;


    ErrorCodes(String description, int statusCode) {
        this.description = description;
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
