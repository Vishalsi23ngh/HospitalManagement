package com.example.hospital.management.Repository;

import com.example.hospital.management.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital ,Integer> {
}
