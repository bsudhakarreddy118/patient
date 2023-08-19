package com.workforce.patient.config;

import com.workforce.patient.model.Patient;
import com.workforce.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PatientValidator  implements Validator {

    @Autowired
    private PatientRepository patientRepository;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    @Override
    public boolean supports(Class<?> clazz) {
        return Patient.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Patient patient = (Patient) target;
        if (patientRepository.findByEmail(patient.getEmail()) != null) {
            errors.rejectValue("email", "duplicate email", "Email already exists");
        }
        if (patientRepository.findByName(patient.getName()) != null) {
            errors.rejectValue("name", "duplicate patient", "Patient already exists");
        }
    }
    }
