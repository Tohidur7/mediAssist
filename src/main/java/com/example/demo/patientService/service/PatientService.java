package com.example.demo.patientService.service;

import com.example.demo.patientService.requestdata.PatientRequestData;
import com.example.demo.patientService.responsedata.PatientResponseData;

import java.util.List;

public interface PatientService {
    PatientResponseData addPatient(PatientRequestData patientRequestData);

    String removePatient(String id);

    List<PatientResponseData> getAllPatient();
}
