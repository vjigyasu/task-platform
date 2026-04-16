package com.smarttask.taskplatform.service;

import com.smarttask.taskplatform.dto.TaskDto;
import com.smarttask.taskplatform.dto.TaskResponseDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface TaskService {

    TaskResponseDto createTask(TaskDto dto);
    Page<TaskResponseDto> getTasks(int page, int size,String sortBy);
    TaskResponseDto updateTask(UUID id,TaskDto dto);
}
