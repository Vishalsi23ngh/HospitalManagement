package com.example.hospital.management.Controller;

import com.example.hospital.management.Model.Hospital;
import com.example.hospital.management.Service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hospital")
@RequiredArgsConstructor
public class HospitalController {
    private  final HospitalService hospitalService;

    @PostMapping
    public  Hospital addHospital(@RequestBody Hospital hospital){
        Hospital response = hospitalService.addHospital(hospital);
        return  response;
    }

    @GetMapping("/all")
    public List<Hospital> findAll(){
        List<Hospital> response = hospitalService.findAll();
        return response;
    }

    @GetMapping("/id")
    public  Hospital findById(@RequestParam int hospitalId){
        Hospital response = hospitalService.findById(hospitalId);
        return response;
    }

    @DeleteMapping
    public String deleteById(@RequestParam int hospitalId){
        String response = hospitalService.deleteById(hospitalId);
        return response;
    }

}
