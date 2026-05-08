package com.jobtracker.backend.controller;

import org.springframework.web.bind.annotation.*;

import com.jobtracker.backend.dto.AuthResponse;
import com.jobtracker.backend.dto.LoginRequest;
import com.jobtracker.backend.dto.RegisterRequest;
import com.jobtracker.backend.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {        
        return authService.login(request);
    }
    
    

}
