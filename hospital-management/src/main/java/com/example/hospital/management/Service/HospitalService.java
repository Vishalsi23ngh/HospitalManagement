package com.example.hospital.management.Service;

import com.example.hospital.management.Model.Hospital;
import com.example.hospital.management.Repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private  final HospitalRepository hospitalRepository;

    public Hospital addHospital(Hospital hospital) {
       return hospitalRepository.save(hospital);
    }

    public List<Hospital> findAll() {
        List<Hospital> hospitals = hospitalRepository.findAll();
        return  hospitals;
    }

    public Hospital findById(int hospitalId) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(hospitalId);
        if(optionalHospital.isPresent()){
            return optionalHospital.get();
        }else{
            throw new RuntimeException("no hospital exist with this id");
        }
    }

    public String deleteById(int hospitalId) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(hospitalId);
        if(optionalHospital.isPresent()){
            hospitalRepository.deleteById(hospitalId);
            return "hospital is Deleted";
        }else{
            throw new RuntimeException("no hospital present with this id");
        }
    }
}
