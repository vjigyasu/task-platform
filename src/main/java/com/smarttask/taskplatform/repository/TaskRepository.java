package com.smarttask.taskplatform.repository;

import com.smarttask.taskplatform.entity.Task;
import com.smarttask.taskplatform.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    @Query("SELECT t.status, COUNT(t) FROM Task t GROUP BY t.status")
    List<Object[]> getTaskStats();

    long countByStatus(Status status);

}
