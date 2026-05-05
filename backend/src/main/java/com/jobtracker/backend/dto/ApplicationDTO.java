package com.jobtracker.backend.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ApplicationDTO {

    @NotBlank
    private String company;

    @NotBlank
    private String position;

    private String link;

    @NotBlank
    private String status;

    @NotNull
    private LocalDate appliedDate;
    private String notes;

}
