package com.smarttask.taskplatform.service.sericeimpl;

import com.smarttask.taskplatform.dto.TaskDto;
import com.smarttask.taskplatform.dto.TaskResponseDto;
import com.smarttask.taskplatform.entity.Task;
import com.smarttask.taskplatform.entity.User;
import com.smarttask.taskplatform.enums.Status;
import com.smarttask.taskplatform.repository.TaskRepository;
import com.smarttask.taskplatform.repository.UserRepository;
import com.smarttask.taskplatform.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepo;
    private final UserRepository userRepo;
    private final ModelMapper mapper;

    public TaskServiceImpl(TaskRepository taskRepo,
                           UserRepository userRepo,
                           ModelMapper mapper) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    @CacheEvict(value = "tasks", allEntries = true)
    public TaskResponseDto createTask(TaskDto dto) {

        Task task = mapper.map(dto, Task.class);

        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        task.setAssignedTo(user);
        task.setStatus(Status.OPEN);

        return mapper.map(taskRepo.save(task), TaskResponseDto.class);
    }



    @Override
    @Cacheable(
            value = "tasks",
            key = "#page + '-' + #size + '-' + #sortBy"
    )
    public Page<TaskResponseDto> getTasks(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return taskRepo.findAll(pageable)
                .map(task -> mapper.map(task, TaskResponseDto.class));
    }



    @Override
    @CacheEvict(value = "tasks", allEntries = true)
    public TaskResponseDto updateTask(UUID id, TaskDto dto) {

        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());

        return mapper.map(taskRepo.save(task), TaskResponseDto.class);
    }
}