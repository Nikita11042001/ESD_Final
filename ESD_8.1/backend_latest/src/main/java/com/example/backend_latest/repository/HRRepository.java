package com.example.backend_latest.repository;

import com.example.backend_latest.model.HR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HRRepository extends JpaRepository<HR,Long> {
}
