package com.workforce.patient.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionModel {
    String message;
    String field;
    String rejectedValue;

}
