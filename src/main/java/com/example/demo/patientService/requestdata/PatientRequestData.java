package com.example.demo.patientService.requestdata;

import com.example.demo.patientService.constant.PatientSymptom;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PatientRequestData {

    @NotNull(message = "Name can not be null")
    @Size(min = 3, message = "Name should be at least 3 characters")
    private String name;

    @Size(max = 20,message = "city should be at most 20 characters")
    private String city ;

    @NotNull(message = "Email can not be null")
    @Email
    private String email ;

    @NotNull(message = "phone number can not be null")
    @Pattern(regexp = "\\d{10}",message = "phone number should be at least 10 digits")
    private String phoneNo ;
    private PatientSymptom symptom ;

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
