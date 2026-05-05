package com.jobtracker.backend.repository;

import com.jobtracker.backend.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long>{

    List<Application> findByStatus(Status status);

    List<Application> findByCompanyContainingIgnoreCase(String company);

}
