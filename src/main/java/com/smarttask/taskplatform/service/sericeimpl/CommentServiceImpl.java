package com.smarttask.taskplatform.service.sericeimpl;

import com.smarttask.taskplatform.dto.CommentDto;
import com.smarttask.taskplatform.entity.Comment;
import com.smarttask.taskplatform.entity.Task;
import com.smarttask.taskplatform.entity.User;
import com.smarttask.taskplatform.repository.CommentRepository;
import com.smarttask.taskplatform.repository.TaskRepository;
import com.smarttask.taskplatform.repository.UserRepository;
import com.smarttask.taskplatform.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepo;
    private final TaskRepository taskRepo;
    private final UserRepository userRepo;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepo,
                              TaskRepository taskRepo,
                              UserRepository userRepo,
                              ModelMapper modelMapper) {
        this.commentRepo = commentRepo;
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto addComment(UUID taskId, CommentDto dto) {


        Task task = taskRepo.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));


        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));


        Comment comment = modelMapper.map(dto, Comment.class);


        comment.setTask(task);
        comment.setUser(user);


        Comment saved = commentRepo.save(comment);


        return modelMapper.map(saved, CommentDto.class);
    }
}