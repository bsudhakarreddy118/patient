package com.workforce.patient.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection= "PatientsList")
public class Patient {

    @Id
    private String id;
    @NotNull(message = "patients name should not be null")
    private String name;
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "Invalid Email format shoud be in abc@email.com format")
    private String email;

    private PatientInfo patientInfo;

    public Patient(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }
}
