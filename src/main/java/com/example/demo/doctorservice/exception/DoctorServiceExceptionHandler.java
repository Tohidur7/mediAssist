package com.example.demo.doctorservice.exception;

import com.example.demo.doctorservice.responsedata.DoctorErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class DoctorServiceExceptionHandler extends ResponseEntityExceptionHandler {

    //handle specific exception
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<DoctorErrorDetails> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest webRequest) {

        DoctorErrorDetails errorDetails = new DoctorErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
