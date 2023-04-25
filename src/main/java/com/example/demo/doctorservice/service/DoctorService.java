package com.example.demo.doctorservice.service;

import com.example.demo.doctorservice.requestdata.DoctorRequestData;
import com.example.demo.doctorservice.responsedata.DoctorResponseData;

import java.util.List;

public interface DoctorService {
    DoctorResponseData addDoctor(DoctorRequestData doctorRequestData);

    String deleteDoctor(String id);

 //   DoctorResponseData updateDoctor(DoctorRequestData doctorRequestData, String id);

    List<DoctorResponseData> getAllDoctor();
}
