package com.smarttask.taskplatform.controller;

import com.smarttask.taskplatform.dto.TaskDto;
import com.smarttask.taskplatform.dto.TaskResponseDto;
import com.smarttask.taskplatform.response.SuccessResponse;
import com.smarttask.taskplatform.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // CREATE TASK (ADMIN + MANAGER)
    @PostMapping
    public ResponseEntity<SuccessResponse<TaskResponseDto>> createTask(
            @RequestBody TaskDto dto) {

        return ResponseEntity.status(201).body(
                new SuccessResponse<>("Task created",
                        service.createTask(dto))
        );
    }

    // GET TASKS (PAGINATION)
    @GetMapping
    public Page<TaskResponseDto> getTasks(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        return service.getTasks(page, size, sortBy);
    }

    // UPDATE TASK
    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<TaskResponseDto>> updateTask(
            @PathVariable UUID id,
            @RequestBody TaskDto dto) {

        return ResponseEntity.ok(
                new SuccessResponse<>("Task updated",
                        service.updateTask(id, dto))
        );
    }
}