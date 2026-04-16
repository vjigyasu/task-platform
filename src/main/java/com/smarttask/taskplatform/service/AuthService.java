package com.smarttask.taskplatform.service;

import com.smarttask.taskplatform.dto.AuthResponseDto;
import com.smarttask.taskplatform.dto.LoginDto;

public interface AuthService {
    AuthResponseDto login(LoginDto dto);
}
