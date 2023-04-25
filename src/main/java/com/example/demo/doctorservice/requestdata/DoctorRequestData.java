package com.example.demo.doctorservice.requestdata;


import com.example.demo.doctorservice.constant.DoctorCity;
import com.example.demo.doctorservice.constant.DoctorSpeciality;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DoctorRequestData {

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name should be at least 3 characters")
    private String name ;

    @Size(max = 20, message = "City should be at most 20 characters")
    private DoctorCity city ;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email ;

    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "\\d{10}", message = "Phone number should be at least 10 digits")
    private String phoneNo ;
    private DoctorSpeciality speciality ;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoctorCity getCity() {
        return city;
    }

    public void setCity(DoctorCity city) {
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

    public DoctorSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(DoctorSpeciality speciality) {
        this.speciality = speciality;
    }
}
