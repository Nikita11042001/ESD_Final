package com.example.backend_latest.service;

import com.example.backend_latest.model.HR;
import com.example.backend_latest.repository.HRRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class HRService {

    private final HRRepository hrrepository;

    public HRService(HRRepository hrrepository) {
        this.hrrepository = hrrepository;
    }

    public Optional<HR> getHRByCompId(Long compId){

        //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return hrrepository.findById(compId);
    }
}
