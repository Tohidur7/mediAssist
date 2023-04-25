package com.example.demo.doctorSuggestionService.service;

import com.example.demo.doctorservice.constant.DoctorSpeciality;
import com.example.demo.doctorservice.entity.Doctor;
import com.example.demo.doctorservice.repository.DoctorRepository;
import com.example.demo.doctorservice.responsedata.DoctorResponseData;
import com.example.demo.patientService.constant.PatientSymptom;
import com.example.demo.patientService.entity.Patient;
import com.example.demo.patientService.exception.EntityNotFoundException;
import com.example.demo.patientService.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DoctorSuggestionServiceImpl implements DoctorSuggestionService{

    private DoctorRepository doctorRepository ;
    private PatientRepository patientRepository ;

    @Autowired
    public DoctorSuggestionServiceImpl(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<DoctorResponseData> getDoctorSuggestion(String id) {

        Optional<Patient> byId = patientRepository.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("patient id is invalid.");
        }
        Patient patient = byId.get();
        String patientCity = patient.getCity();


        List<Doctor> all = doctorRepository.findAll();
        if (patientCity!=null) {

            //finding doctors in the same city
            List<Doctor> doctorInSameCity = getDoctorWithCity(patientCity, all);
            System.out.println("doctors in same city**************");
            doctorInSameCity.forEach(doctor -> System.out.println(doctor));

            if (doctorInSameCity.isEmpty()) {
                throw new com.example.demo.doctorservice.exception.
                        EntityNotFoundException("We are still waiting to expand to your location");
            } else {
                //finding specialist doctors with patient's symptoms
                PatientSymptom symptom = patient.getSymptom();
                List<Doctor> specialistDoctorInSameCity = getDoctorWithSymptoms(doctorInSameCity, symptom);
                System.out.println("specialist doctor in same city**************");
                specialistDoctorInSameCity.forEach(doctor -> System.out.println(doctor));

                if (specialistDoctorInSameCity.isEmpty()) {
                    throw new com.example.demo.doctorservice.exception.
                            EntityNotFoundException("There isn’t any doctor present at your location for your symptom");
                } else {
                    List<DoctorResponseData> collect = specialistDoctorInSameCity.stream().map(doctor -> mapToDto(doctor)).collect(Collectors.toList());
                    System.out.println("doctor response data**************");
                    collect.forEach(doctor -> System.out.println(doctor));
                    return collect;
                }
            }
        }
        return null ;
    }

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

    private List<Doctor> getDoctorWithCity( String city, List<Doctor> all) {
        final String patientCity = city.toUpperCase().trim() ;

        return all.stream().filter(doctor -> patientCity.equals(String.valueOf(doctor.getCity()))).collect(Collectors.toList());
    }


    private List<Doctor> getDoctorWithSymptoms(List<Doctor> doctorInCity,PatientSymptom symptom) {

        if (symptom == PatientSymptom.ARTHRITIS || symptom == PatientSymptom.BACK_PAIN || symptom == PatientSymptom.TISSUE_INJURIES) {
            return doctorInCity.stream().filter(doctor -> doctor.getSpeciality() == DoctorSpeciality.ORTHOPEDIC)
                    .collect(Collectors.toList());
        }

        else if (symptom == PatientSymptom.DYSMENORRBEA) {
            return doctorInCity.stream().filter(doctor -> doctor.getSpeciality() == DoctorSpeciality.GYNECOLOGY)
                    .collect(Collectors.toList());
        }

        else if (symptom == PatientSymptom.SKIN_INFECTION || symptom == PatientSymptom.SKIN_BURN ) {
            return doctorInCity.stream().filter(doctor -> doctor.getSpeciality() == DoctorSpeciality.DERMATOLOGY)
                    .collect(Collectors.toList());
        }

        //symptom == PatientSymptom.EAR_PAIN
        else {
            return doctorInCity.stream().filter(doctor -> doctor.getSpeciality() == DoctorSpeciality.ENT_SPECIALIST)
                    .collect(Collectors.toList());
        }
    }


}