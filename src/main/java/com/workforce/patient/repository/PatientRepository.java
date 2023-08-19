package com.workforce.patient.repository;


import com.workforce.patient.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient,String> {

    Patient findByEmail(String email);
    Patient findByName(String name);
}
