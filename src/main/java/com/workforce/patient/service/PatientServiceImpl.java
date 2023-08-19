package com.workforce.patient.service;

import com.mongodb.DuplicateKeyException;
import com.workforce.patient.model.Patient;
import com.workforce.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PatientServiceImpl  implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public Patient createPatient(Patient patient) {
        return  patientRepository.save(patient);


    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(String id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient updatePatient(String id, Patient patient) {
        patient.setId(id);
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(String id) {
        patientRepository.deleteById(id);

    }
}
