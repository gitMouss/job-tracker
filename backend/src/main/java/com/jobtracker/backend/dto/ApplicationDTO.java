package com.jobtracker.backend.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ApplicationDTO {

    private String company;
    private String position;
    private String link;
    private String status;
    private LocalDate appliedDate;
    private String notes;

}
