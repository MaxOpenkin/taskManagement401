package org.taskmanagement401.dto;

import java.util.List;

public class ResponseDTO<T> {
    private Integer code;
    private T answer;

    public ResponseDTO(Integer code, T answer) {
        this.code = code;
        this.answer = answer;

    }

    public Integer getCode() {
        return code;
    }

    public T getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "code=" + code +
                ", answer=" + answer +
                '}';
    }
}
