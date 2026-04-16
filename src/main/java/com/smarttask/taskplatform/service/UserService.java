package com.smarttask.taskplatform.service;

import com.smarttask.taskplatform.dto.UserDto;
import com.smarttask.taskplatform.dto.UserResponseDto;

public interface UserService {
   UserResponseDto createUser(UserDto dto);
}
