package com.example.demo.doctorservice.controller;

import com.example.demo.doctorservice.requestdata.DoctorRequestData;
import com.example.demo.doctorservice.responsedata.DoctorResponseData;
import com.example.demo.doctorservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping(path = "/doctors")
    public ResponseEntity<DoctorResponseData> addDoctor(@RequestBody DoctorRequestData doctorRequestData) {

        return new ResponseEntity<>(doctorService.addDoctor(doctorRequestData), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/doctors/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable(name = "id") String id) {

        return new ResponseEntity<>(doctorService.deleteDoctor(id), HttpStatus.OK);
    }


    @GetMapping(path = "/doctors")
    public ResponseEntity<List<DoctorResponseData>> getDoctor() {

        return new ResponseEntity<>(doctorService.getAllDoctor(), HttpStatus.OK);
    }


//    @PutMapping(path = "/doctors/{id}")
//    public ResponseEntity<DoctorResponseData> updateDoctor(@RequestBody DoctorRequestData doctorRequestData, @PathVariable(name = "id") String id) {
//
//        return new ResponseEntity<>(doctorService.updateDoctor(doctorRequestData, id), HttpStatus.OK);
//    }


}
