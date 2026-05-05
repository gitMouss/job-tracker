package com.jobtracker.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.jobtracker.backend.model.Application;
import com.jobtracker.backend.repository.ApplicationRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationRepository applicationRepository;

    @GetMapping
    public List<Application> getApplication() {
        return applicationRepository.findAll();
    }

}
