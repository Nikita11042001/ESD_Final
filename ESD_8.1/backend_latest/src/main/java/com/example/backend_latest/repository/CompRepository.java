package com.example.backend_latest.repository;

import com.example.backend_latest.model.Comp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CompRepository extends JpaRepository<Comp,Long> {
}

