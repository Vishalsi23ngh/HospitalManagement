package com.example.hospital.management.Controller;


import com.example.hospital.management.Model.Doctor;
import com.example.hospital.management.Model.Patient;
import com.example.hospital.management.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private  final DoctorService doctorService;

    @PostMapping
    public  Doctor addPatient(@RequestBody Doctor doctor , @RequestParam int hospitalId){
        Doctor response = doctorService.addDoctor(doctor , hospitalId);
        return  response;
    }
    @GetMapping("/findAll")
    public List<Doctor> findAllDoctor(){
        return doctorService.findAll();
    }

    @DeleteMapping
    public String deleteDoctor(@RequestParam int doctorId){
        String response = doctorService.deleteById(doctorId);
        return  response;
    }
}
