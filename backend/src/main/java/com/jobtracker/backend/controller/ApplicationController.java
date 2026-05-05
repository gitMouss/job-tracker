package com.jobtracker.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.jobtracker.backend.dto.ApplicationDTO;
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

    @PostMapping
    public Application createApplication(@RequestBody ApplicationDTO dto) {


         Application application = Application.builder()
                .company(dto.getCompany())
                .position(dto.getPosition())
                .link(dto.getLink())
                .status(Enum.valueOf(com.jobtracker.backend.model.Status.class, dto.getStatus()))
                .applieDate(dto.getAppliedDate())
                .notes(dto.getNotes())
                .build();

        return applicationRepository.save(application);
    }

}
