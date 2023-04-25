package com.example.demo.doctorSuggestionService.controller;

import com.example.demo.doctorSuggestionService.service.DoctorSuggestionService;
import com.example.demo.doctorservice.responsedata.DoctorResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class DoctorSuggestionController {

    private DoctorSuggestionService doctorSuggestionService ;

    @Autowired
    public DoctorSuggestionController(DoctorSuggestionService doctorSuggestionService) {
        this.doctorSuggestionService = doctorSuggestionService;
    }

    @GetMapping(path = "/doctor-suggestion/{id}")
    public ResponseEntity<List<DoctorResponseData>> getDoctorSuggestion(@PathVariable(name = "id") String id) {

        return new ResponseEntity<>(doctorSuggestionService.getDoctorSuggestion(id), HttpStatus.OK);

    }
}
