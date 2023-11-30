package com.example.backend_latest.controller;

//import
import com.example.backend_latest.model.Comp;
import com.example.backend_latest.repository.CompRepository;
import com.example.backend_latest.repository.HRRepository;
import com.example.backend_latest.service.CompService;
import com.example.backend_latest.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/api/comp")
    public class CompController {

        @Autowired
        private CompRepository comprepository;
        private HRRepository hrrepository;
        @Autowired
        private CompService compservice;
        private HRService hrservice;



//        public ResponseEntity<String> addComp(@RequestBody Comp comp) {
//
//            compRepository.save(comp);
//            return ResponseEntity.status(HttpStatus.OK).body("Success");
//        }
        @PostMapping("/add")
        public Comp addComp(@RequestBody Comp comp) {

            return compservice.saveComp(comp);

        }

        @GetMapping("/get")
        public ResponseEntity<List<Comp>> getAllComp() {
            List<Comp> comps = comprepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(comps);
        }

        @GetMapping("/getHRid/{compId}")
        public ResponseEntity<Comp> getHRByCompId(@PathVariable Long compId) {
            Optional<Comp> xd = comprepository.findById(compId);
            
            return xd.map(hr->ResponseEntity.ok().body(hr))
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/del/{compId}")
        public ResponseEntity<String> deleteComp(@PathVariable Long compId) {
            comprepository.deleteById(compId);
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        }
    }
