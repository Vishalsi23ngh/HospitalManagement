package com.example.hospital.management.Service;

import com.example.hospital.management.Model.Doctor;
import com.example.hospital.management.Model.Hospital;
import com.example.hospital.management.Model.Patient;
import com.example.hospital.management.Repository.DoctorRepository;
import com.example.hospital.management.Repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private  final DoctorRepository doctorRepository;

    private final HospitalRepository hospitalRepository;

    public Doctor addDoctor(Doctor doctor , int hospitalId) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(hospitalId);
        if(optionalHospital.isPresent()){
            doctor.setHospital(optionalHospital.get());
            return doctorRepository.save(doctor);

        }else {
            throw  new RuntimeException("Hospital Not found");
        }

    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public String deleteById(int doctorId) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);

        if(optionalDoctor.isPresent()){
            doctorRepository.deleteById(doctorId);
            return "doctor deleted ";
        }
        else {
            return "no doctor exist with this id";
        }
    }
}
