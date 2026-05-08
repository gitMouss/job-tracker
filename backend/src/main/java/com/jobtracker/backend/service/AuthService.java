package com.jobtracker.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobtracker.backend.dto.AuthResponse;
import com.jobtracker.backend.dto.LoginRequest;
import com.jobtracker.backend.dto.RegisterRequest;
import com.jobtracker.backend.exception.InvalidCredentialsException;
import com.jobtracker.backend.exception.UserNotFoundException;
import com.jobtracker.backend.model.Role;
import com.jobtracker.backend.model.User;
import com.jobtracker.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {
        
        User user = new User();

               user.setFirstname(request.getFirstname());
               user.setLastname(request.getLastname());
               user.setEmail(request.getEmail());
               user.setPassword(passwordEncoder.encode(request.getPassword()));
               user.setRole(Role.USER);

               userRepository.save(user);

               String token = jwtService.generateToken(user.getEmail());

               return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                 .orElseThrow(() -> new UserNotFoundException("User not found"));

                 if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                    throw new InvalidCredentialsException("Invalid password");
                 }

                 String token = jwtService.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

    

}
