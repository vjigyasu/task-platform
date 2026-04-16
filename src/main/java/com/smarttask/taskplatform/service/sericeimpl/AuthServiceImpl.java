package com.smarttask.taskplatform.service.sericeimpl;

import com.smarttask.taskplatform.dto.AuthResponseDto;
import com.smarttask.taskplatform.dto.LoginDto;
import com.smarttask.taskplatform.entity.User;
import com.smarttask.taskplatform.repository.UserRepository;
import com.smarttask.taskplatform.service.AuthService;
import com.smarttask.taskplatform.utils.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository,
                           JwtUtil jwtUtil,
                           ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponseDto login(LoginDto dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());

        return new AuthResponseDto(token, user.getRole().name());
    }
}
