package com.example.demo.patientService.controller;

import com.example.demo.patientService.requestdata.PatientRequestData;
import com.example.demo.patientService.responsedata.PatientResponseData;
import com.example.demo.patientService.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(path = "/patients")
    public ResponseEntity<PatientResponseData> addPatient(@RequestBody PatientRequestData patientRequestData) {

        return new ResponseEntity<>(patientService.addPatient(patientRequestData), HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/patients/{id}")
    public ResponseEntity<String> removePatient(@PathVariable(name = "id") String id) {

        return new ResponseEntity<>(patientService.removePatient(id), HttpStatus.OK);
    }


    @GetMapping(path = "/patients")
    public ResponseEntity<List<PatientResponseData>> getAllPatient() {

        return new ResponseEntity<>(patientService.getAllPatient(), HttpStatus.OK);
    }


}
