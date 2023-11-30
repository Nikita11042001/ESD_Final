package com.example.backend_latest.service;

import com.example.backend_latest.model.Comp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CompService {
    public Comp saveComp(Comp comp);
    public ResponseEntity<List<Comp>> getAllComp();
}
