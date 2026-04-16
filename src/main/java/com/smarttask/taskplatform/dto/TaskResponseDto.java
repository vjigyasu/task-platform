package com.smarttask.taskplatform.dto;

import com.smarttask.taskplatform.enums.Priority;
import com.smarttask.taskplatform.enums.Status;

import java.util.UUID;

public class TaskResponseDto {

    private UUID id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;

    public TaskResponseDto() {
    }

    public TaskResponseDto(UUID id, String title, String description, Status status, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
