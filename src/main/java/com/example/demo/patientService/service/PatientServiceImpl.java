package com.example.demo.patientService.service;

import com.example.demo.doctorservice.constant.Constants;
import com.example.demo.patientService.entity.Patient;
import com.example.demo.patientService.exception.EntityNotFoundException;
import com.example.demo.patientService.repository.PatientRepository;
import com.example.demo.patientService.requestdata.PatientRequestData;
import com.example.demo.patientService.responsedata.PatientResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository ;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public PatientResponseData addPatient(PatientRequestData patientRequestData) {

        Patient patient = mapToEntity(patientRequestData);

        String temp = "patient:" + UUID.randomUUID();
        patient.setId(temp);

        patientRepository.save(patient);
        return mapToDto(patient);
    }

    @Override
    public String removePatient(String id) {

        Optional<Patient> byId = patientRepository.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("patient data is not exist with the given id");
        }
        Patient patient = byId.get();
        patientRepository.delete(patient);

        return Constants.DELETE_MSG_DOCTOR;
    }

    @Override
    public List<PatientResponseData> getAllPatient() {

        List<Patient> all = patientRepository.findAll();
        return all.stream().map(patient -> mapToDto(patient)).collect(Collectors.toList());
    }



    // METHOD TO CONVERT ENTITY INTO DTO
    private PatientResponseData mapToDto(Patient patient) {

        PatientResponseData patientResponseData = new PatientResponseData();
        patientResponseData.setId(patient.getId());
        patientResponseData.setName(patient.getName());
        patientResponseData.setCity(patient.getCity());
        patientResponseData.setEmail(patient.getEmail());
        patientResponseData.setPhoneNo(patient.getPhoneNo());
        patientResponseData.setSymptom(patient.getSymptom());
        return patientResponseData ;
    }

    // METHOD TO CONVERT ENTITY INTO DTO
    private Patient mapToEntity(PatientRequestData patientRequestData) {

        Patient patient= new Patient();

        patient.setName(patientRequestData.getName());
        patient.setCity(patientRequestData.getCity());
        patient.setEmail(patientRequestData.getEmail());
        patient.setPhoneNo(patientRequestData.getPhoneNo());
        patient.setSymptom(patientRequestData.getSymptom());

        return patient ;
    }
}
