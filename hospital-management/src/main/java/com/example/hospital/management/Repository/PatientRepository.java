package com.example.hospital.management.Repository;

import com.example.hospital.management.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient ,Integer> {
}
