package com.smarttask.taskplatform.dto;

import com.smarttask.taskplatform.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data

public class TaskDto {

    @NotBlank(message = "Title is required")
    private String title;
    private String description;

    @NotNull(message = "Priority is required")
    private Priority priority;
    private UUID userId;
    private LocalDateTime dueDate;

    public TaskDto() {
    }

    public TaskDto(String title, String description, Priority priority, UUID userId, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.userId = userId;
        this.dueDate = dueDate;
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}