package org.taskmanagement401.dto.error;

public class ErrorDto {
    int code;
    String Description;

    public ErrorDto(int code, String description) {
        this.code = code;
        Description = description;
    }

    @Override
    public String toString() {
        return "ErrorDto{" +
                "code=" + code +
                ", Description='" + Description + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }
}
