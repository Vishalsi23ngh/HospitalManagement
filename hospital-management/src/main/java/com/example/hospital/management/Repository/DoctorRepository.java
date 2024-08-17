package com.example.hospital.management.Repository;

import com.example.hospital.management.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor ,Integer> {
}
