package com.example.hospital.management.Controller;


import com.example.hospital.management.Model.Patient;
import com.example.hospital.management.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
public class PatientController {

    private  final PatientService patientService;

    @PostMapping
    public  Patient addPatient(@RequestBody Patient patient, @RequestParam int DoctorId){
        Patient response = patientService.addPatient(patient,DoctorId);
        return  response;
    }
    @GetMapping
    public List<Patient> getAllPatient(){
        List<Patient> response = patientService.getAllPatient();
        return response;
    }

    @GetMapping("/id")
    public Patient findById(@RequestParam int patientId){
        Patient response = patientService.findById(patientId);
        return response;
    }

    @DeleteMapping
    public String deleteById(@RequestParam int patientId){
        String response = patientService.deleteById(patientId);
        return  response;
    }
}
