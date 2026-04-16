package com.smarttask.taskplatform.controller;

import com.smarttask.taskplatform.dto.CommentDto;
import com.smarttask.taskplatform.response.SuccessResponse;
import com.smarttask.taskplatform.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<SuccessResponse<CommentDto>> addComment(
            @PathVariable UUID id,
            @RequestBody CommentDto dto) {

        CommentDto response = service.addComment(id, dto);

        return ResponseEntity.status(201).body(
                new SuccessResponse<>("Comment added", response)
        );
    }
}