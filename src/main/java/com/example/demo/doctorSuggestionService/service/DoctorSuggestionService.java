package com.example.demo.doctorSuggestionService.service;

import com.example.demo.doctorservice.responsedata.DoctorResponseData;

import java.util.List;

public interface DoctorSuggestionService {
    List<DoctorResponseData> getDoctorSuggestion(String id);
}
