package com.example.demo.doctorservice.responsedata;

import java.util.Date;

public class DoctorErrorDetails {

    private Date timestamp ;
    private String message ;
    private String path ;

    public DoctorErrorDetails(Date timestamp, String message, String path) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
