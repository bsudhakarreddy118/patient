package com.workforce.patient.service;

import com.workforce.patient.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PatientService {

    public Patient createPatient(Patient patient);

    public List<Patient> getAllPatients();

    public Patient getPatientById(String id);
    public Patient updatePatient(String id,Patient patient);

    public void deletePatient(String id);




}
