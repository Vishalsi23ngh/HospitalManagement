package com.example.hospital.management.Service;

import com.example.hospital.management.Model.Doctor;
import com.example.hospital.management.Model.Patient;
import com.example.hospital.management.Repository.DoctorRepository;
import com.example.hospital.management.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private  final PatientRepository patientRepository;

    private  final DoctorRepository doctorRepository;

    public Patient addPatient(Patient patient, int doctorId) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);

        if(optionalDoctor.isPresent()){
            patient.setDoctor(optionalDoctor.get());
            return patientRepository.save(patient);

        }else{
            throw  new RuntimeException("no doctor Exist with this id");
        }
    }

    public List<Patient> getAllPatient() {
        return  patientRepository.findAll();
    }

    public Patient findById(int patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if(optionalPatient.isPresent()){
            return optionalPatient.get();
        }else {
            throw new RuntimeException("patient not Exist with this id");
        }
    }

    public String deleteById(int patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if(optionalPatient.isPresent()){
            patientRepository.deleteById(patientId);
        }else{
            throw new RuntimeException("patient not exist with this Id");
        }
        return "Patient deleted successfully";
    }
}
