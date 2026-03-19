package com.example.demo.controller;

import com.example.demo.entity.Enrollement;
import com.example.demo.service.EnrollementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollements")
public class EnrollementController {

    private final EnrollementService enrollementRepository; // Renommé par souci de cohérence avec le service

    public EnrollementController(EnrollementService enrollementService){
        this.enrollementRepository = enrollementService;
    }

    @GetMapping
    public List<Enrollement> getAllEnrollements(){
        return enrollementRepository.getAllEnrollements();
    }

    @GetMapping("/{id}")
    public Optional<Enrollement> getEnrollementById(@PathVariable Long id){
        return enrollementRepository.getEnrollementById(id);
    }

    @PostMapping
    public Enrollement createEnrollement(@RequestBody Enrollement enrollement){
        return enrollementRepository.createEnrollement(enrollement);
    }

    @PutMapping("/{id}")
    public Enrollement updateEnrollement(@PathVariable Long id,@RequestBody Enrollement enrollement){
        return enrollementRepository.updateEnrollement(id,enrollement);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollement(@PathVariable Long id){
        enrollementRepository.deleteEnrollement(id);
    }

    // workflow validation
    @PutMapping("/{id}/validate")
    public Enrollement validateEnrollement(@PathVariable Long id){
        return enrollementRepository.validateEnrollement(id);
    }
}