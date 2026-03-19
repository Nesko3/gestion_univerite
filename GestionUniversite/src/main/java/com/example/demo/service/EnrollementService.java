package com.example.demo.service;

import com.example.demo.entity.Enrollement;
import com.example.demo.entity.Status;
import com.example.demo.repository.EnrollementRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollementService {

    private final EnrollementRepository enrollementRepository;

    public EnrollementService(EnrollementRepository enrollementRepository){
        this.enrollementRepository = enrollementRepository;
    }

    public List<Enrollement> getAllEnrollements(){
        return enrollementRepository.findAll();
    }

    public Optional<Enrollement> getEnrollementById(Long id){
        return enrollementRepository.findById(id);
    }

    public Enrollement createEnrollement(Enrollement enrollement){

        enrollement.setEnrollementDate(LocalDate.now());
        enrollement.setStatus(Status.PENDING);

        return enrollementRepository.save(enrollement);
    }

    public Enrollement updateEnrollement(Long id, Enrollement enrollement){

        Optional<Enrollement> existingEnrollement = enrollementRepository.findById(id);

        if(existingEnrollement.isPresent()){
            enrollement.setId(id);
            return enrollementRepository.save(enrollement);
        }

        return null;
    }

    public void deleteEnrollement(Long id){
        enrollementRepository.deleteById(id);
    }

    // VALIDATION (workflow)
    public Enrollement validateEnrollement(Long id){

        Optional<Enrollement> enrollement = enrollementRepository.findById(id);

        if(enrollement.isPresent()){

            Enrollement e = enrollement.get();
            e.setStatus(Status.VALIDATED);

            return enrollementRepository.save(e);
        }

        return null;
    }
}