package com.jobtracker.backend.repository;

import com.jobtracker.backend.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long>{

}
