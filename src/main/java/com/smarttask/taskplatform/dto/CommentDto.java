package com.smarttask.taskplatform.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class CommentDto {

    private UUID id;
    private UUID userId;
    private String message;
}