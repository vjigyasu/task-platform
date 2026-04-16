package com.smarttask.taskplatform.controller;


import com.smarttask.taskplatform.dto.UserDto;
import com.smarttask.taskplatform.dto.UserResponseDto;
import com.smarttask.taskplatform.response.SuccessResponse;
import com.smarttask.taskplatform.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<UserResponseDto>> createUser(
            @Valid @RequestBody UserDto dto) {

        UserResponseDto response = service.createUser(dto);

        return ResponseEntity.status(201).body(
                new SuccessResponse<>("User Created", response)
        );
    }
}