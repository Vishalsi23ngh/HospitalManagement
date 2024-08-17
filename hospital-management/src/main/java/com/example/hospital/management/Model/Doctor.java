package com.example.hospital.management.Model;

import com.example.hospital.management.ENUM.Specialisation;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int doctorId;

    String name;

    String specialisation;

    @ManyToOne
    @JoinColumn(name = "hospitalId")
    Hospital hospital;

    @OneToMany(mappedBy = "doctor" ,cascade =  CascadeType.ALL)
    List<Patient> patients;
}
