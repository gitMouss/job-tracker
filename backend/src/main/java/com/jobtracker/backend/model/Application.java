package com.jobtracker.backend.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String position;
    private String link;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate applieDate;
    @Column(length = 1000)
    private String notes;

}
