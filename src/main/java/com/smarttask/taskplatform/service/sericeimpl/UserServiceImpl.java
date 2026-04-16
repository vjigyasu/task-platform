package com.smarttask.taskplatform.service.sericeimpl;

import com.smarttask.taskplatform.dto.UserDto;
import com.smarttask.taskplatform.dto.UserResponseDto;
import com.smarttask.taskplatform.entity.User;
import com.smarttask.taskplatform.repository.UserRepository;
import com.smarttask.taskplatform.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDto createUser(UserDto dto) {
        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        User user = modelMapper.map(dto,User.class);

        user.setPassword(passwordEncoder.encode(dto.getPassword()));



        User saved = userRepository.save(user);

        return modelMapper.map(saved,UserResponseDto.class);
    }
}
