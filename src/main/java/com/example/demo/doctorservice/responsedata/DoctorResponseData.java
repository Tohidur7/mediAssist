package com.example.demo.doctorservice.responsedata;

import com.example.demo.doctorservice.constant.DoctorCity;
import com.example.demo.doctorservice.constant.DoctorSpeciality;

public class DoctorResponseData {

    private String id ;
    private String name ;
    private DoctorCity city ;
    private String email ;
    private String phoneNo ;
    private DoctorSpeciality speciality ;


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

    @Override
    public String toString() {
        return "DoctorResponseData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", speciality=" + speciality +
                '}';
    }
}
