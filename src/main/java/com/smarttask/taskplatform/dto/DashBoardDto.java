package com.smarttask.taskplatform.dto;


import lombok.Data;

@Data
public class DashBoardDto {
    private long totalTasks;
    private long todoTasks;
    private long inProgressTasks;
    private long doneTasks;

    public DashBoardDto() {
    }

    public DashBoardDto(long totalTasks, long todoTasks, long inProgressTasks, long doneTasks) {
        this.totalTasks = totalTasks;
        this.todoTasks = todoTasks;
        this.inProgressTasks = inProgressTasks;
        this.doneTasks = doneTasks;
    }

    public long getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(long totalTasks) {
        this.totalTasks = totalTasks;
    }

    public long getTodoTasks() {
        return todoTasks;
    }

    public void setTodoTasks(long todoTasks) {
        this.todoTasks = todoTasks;
    }

    public long getInProgressTasks() {
        return inProgressTasks;
    }

    public void setInProgressTasks(long inProgressTasks) {
        this.inProgressTasks = inProgressTasks;
    }

    public long getDoneTasks() {
        return doneTasks;
    }

    public void setDoneTasks(long doneTasks) {
        this.doneTasks = doneTasks;
    }
}
