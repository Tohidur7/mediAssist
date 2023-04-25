package com.example.demo.patientService.exception;

import com.example.demo.patientService.responsedata.PatientErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class PatientServiceExceptionHandler extends ResponseEntityExceptionHandler {

    //handle specific exception
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<PatientErrorDetails> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest webRequest) {

        PatientErrorDetails errorDetails = new PatientErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
