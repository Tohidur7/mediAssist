package com.example.demo.doctorservice.service;

import com.example.demo.doctorservice.constant.Constants;
import com.example.demo.doctorservice.entity.Doctor;
import com.example.demo.doctorservice.exception.EntityNotFoundException;
import com.example.demo.doctorservice.repository.DoctorRepository;
import com.example.demo.doctorservice.requestdata.DoctorRequestData;
import com.example.demo.doctorservice.responsedata.DoctorResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService{

    private DoctorRepository doctorRepository ;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @Override
    public DoctorResponseData addDoctor(DoctorRequestData doctorRequestData) {

        Doctor doctor = mapToEntity(doctorRequestData);
        String temp = "doctor:"+ UUID.randomUUID() ;
        doctor.setId(temp);

        doctorRepository.save(doctor);
        return mapToDto(doctor);
    }

    @Override
    public String deleteDoctor(String id) {

        Optional<Doctor> byId = doctorRepository.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("doctor data does not exist with this id");
        }
        Doctor doctor = byId.get();
        doctorRepository.delete(doctor);
        return Constants.DELETE_MSG_DOCTOR;
    }

    @Override
    public List<DoctorResponseData> getAllDoctor() {

        List<Doctor> all = doctorRepository.findAll();
        return all.stream().map(doctor -> mapToDto(doctor)).collect(Collectors.toList());
    }





    //CONVERT ENTITY INTO DTO
    private DoctorResponseData mapToDto(Doctor doctor) {

        DoctorResponseData doctorResponseData = new DoctorResponseData();

        doctorResponseData.setId(doctor.getId());
        doctorResponseData.setName(doctor.getName());
        doctorResponseData.setCity(doctor.getCity());
        doctorResponseData.setEmail(doctor.getEmail());
        doctorResponseData.setPhoneNo(doctor.getPhoneNo());
        doctorResponseData.setSpeciality(doctor.getSpeciality());

        return doctorResponseData ;
    }


    //CONVERT DTO INTO ENTITY
    private Doctor mapToEntity(DoctorRequestData doctorRequestData) {

        Doctor doctor = new Doctor();

        doctor.setName(doctorRequestData.getName());
        doctor.setCity(doctorRequestData.getCity());
        doctor.setEmail(doctorRequestData.getEmail());
        doctor.setPhoneNo(doctorRequestData.getPhoneNo());
        doctor.setSpeciality(doctorRequestData.getSpeciality());

        return doctor ;
    }
}
