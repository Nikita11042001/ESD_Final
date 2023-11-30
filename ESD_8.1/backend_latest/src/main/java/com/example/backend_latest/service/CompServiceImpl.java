package com.example.backend_latest.service;

import com.example.backend_latest.model.Comp;
import com.example.backend_latest.repository.CompRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class CompServiceImpl implements CompService{
    @Autowired
    private CompRepository comprepository;

    public Comp saveComp (Comp comp){return comprepository.save(comp);}
    @Override
    public ResponseEntity<List<Comp>> getAllComp()
    {
        return (ResponseEntity<List<Comp>>) comprepository.findAll();
    }

}
