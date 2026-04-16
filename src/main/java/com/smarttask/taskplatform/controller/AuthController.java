package com.smarttask.taskplatform.controller;

import com.smarttask.taskplatform.dto.AuthResponseDto;
import com.smarttask.taskplatform.dto.LoginDto;
import com.smarttask.taskplatform.response.SuccessResponse;
import com.smarttask.taskplatform.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessResponse<AuthResponseDto>> login(@Valid @RequestBody LoginDto dto){
        AuthResponseDto response = authService.login(dto);
        return ResponseEntity.ok(new SuccessResponse<>("Login Successful",response));
    }
}
