package com.workforce.patient.controller;

import com.workforce.patient.config.PatientValidator;
import com.workforce.patient.model.Patient;
import com.workforce.patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientValidator patientValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(patientValidator);
    }




   @PostMapping("/patients")
   public ResponseEntity<Patient>  createPatient( @Valid @RequestBody Patient patient){
        Patient newPatient= patientService.createPatient(patient);
        return  new ResponseEntity<>(newPatient, HttpStatus.CREATED);
   }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients(){
         List<Patient> patients=  patientService.getAllPatients();
         return  new ResponseEntity<>(patients,HttpStatus.OK);
    }
    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id){
        Patient patient= patientService.getPatientById(id);
        if(patient==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(patient,HttpStatus.OK);
    }
     @PutMapping("/patients/patient/{id}")
    public  ResponseEntity<Patient> updatePatient(@PathVariable String id, Patient patient){
       Patient updatedPatient= patientService.updatePatient(id,patient);
       return  new ResponseEntity<>(updatedPatient,HttpStatus.OK);
    }
     @DeleteMapping("/patients/patient/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String id){
       patientService.deletePatient(id);
       return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }









}
