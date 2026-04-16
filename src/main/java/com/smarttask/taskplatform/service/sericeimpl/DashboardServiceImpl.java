package com.smarttask.taskplatform.service.sericeimpl;

import com.smarttask.taskplatform.dto.DashBoardDto;
import com.smarttask.taskplatform.enums.Status;
import com.smarttask.taskplatform.repository.TaskRepository;
import com.smarttask.taskplatform.service.DashBoardService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashBoardService {

    private final TaskRepository taskRepo;

    public DashboardServiceImpl(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public DashBoardDto getDashboard() {

        DashBoardDto dto = new DashBoardDto();

        // Total tasks
        dto.setTotalTasks(taskRepo.count());

        // Count by status
        dto.setTodoTasks(taskRepo.countByStatus(Status.OPEN));
        dto.setInProgressTasks(taskRepo.countByStatus(Status.IN_PROGRESS));
        dto.setDoneTasks(taskRepo.countByStatus(Status.DONE));

        return dto;
    }
}