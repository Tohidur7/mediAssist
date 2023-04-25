package com.example.demo.patientService.entity;

import com.example.demo.patientService.constant.PatientSymptom;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Patient {

    @Id
    private String id;
    private String name ;
    private String city ;
    private String email ;
    private String phoneNo ;
    @Enumerated(EnumType.STRING)
    private PatientSymptom symptom ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public PatientSymptom getSymptom() {
        return symptom;
    }

    public void setSymptom(PatientSymptom symptom) {
        this.symptom = symptom;
    }
}
