package com.jobtracker.backend.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import com.jobtracker.backend.dto.ApplicationDTO;
import com.jobtracker.backend.model.Application;
import com.jobtracker.backend.model.Status;
import com.jobtracker.backend.repository.ApplicationRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationRepository applicationRepository;


    @GetMapping
    public Page<Application> getAllApplications(@NonNull Pageable pageable) {
        return applicationRepository.findAll(pageable);
    }

    @PostMapping
    public Application createApplication(@Valid @RequestBody ApplicationDTO dto) {


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

    @GetMapping("/status/{status}")
    public List<Application> getByStatus(@PathVariable Status status) {
        return applicationRepository.findByStatus(status);
    }

    @GetMapping("/search")
    public List<Application> searchByCompany(@RequestParam String company) {
        return applicationRepository.findByCompanyContainingIgnoreCase(company);
    }

}
