package com.example.backend_latest.controller;


import com.example.backend_latest.model.HR;
import com.example.backend_latest.repository.HRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/HR")
public class HRController {

    @Autowired
    private HRRepository hrRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addHR(@RequestBody HR hr) {
        hrRepository.save(hr);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

    @GetMapping("/get")
    public ResponseEntity<List<HR>> getAllHR() {
        List<HR> hrs = hrRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(hrs);
    }

    @PostMapping("/update/{hrId}")
    public ResponseEntity<String> updateHR(@PathVariable Long hrId, @RequestBody HR hr) {
        if (hrRepository.existsById(hrId)) {
            hr.setHr_id(hrId);
            hrRepository.save(hr);
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failure while updating HR");
    }

    @DeleteMapping("/del/{hrId}")
    public ResponseEntity<String> deleteHR(@PathVariable Long hrId) {
        if (hrRepository.existsById(hrId)) {
            hrRepository.deleteById(hrId);
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("HR not found");
    }

    @GetMapping("/getHR/{hrId}")
    public ResponseEntity<HR> getHR(@PathVariable Long hrId) {
        return hrRepository.findById(hrId)
                .map(hr -> ResponseEntity.ok().body(hr))
                .orElse(ResponseEntity.notFound().build());
    }
}
