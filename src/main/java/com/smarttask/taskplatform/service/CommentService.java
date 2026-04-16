package com.smarttask.taskplatform.service;

import com.smarttask.taskplatform.dto.CommentDto;

import java.util.UUID;

public interface CommentService {
    CommentDto addComment(UUID taskId,CommentDto dto);
}
