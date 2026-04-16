package com.smarttask.taskplatform.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private String message;
    private int status;

    private T data;
    private LocalDateTime timestamp;

    public ApiResponse() {
    }



    public ApiResponse(String message, int status, T data, LocalDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.data = data;
        this.timestamp = timestamp;
    }

    public ApiResponse(String message, int status, T data) {

        this.message = message;
        this.status = status;
        this.data = data;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}