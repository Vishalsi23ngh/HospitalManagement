package com.example.hospital.management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int patientId ;

    String patientName;

    int  age;

    String gender;

    @Temporal(TemporalType.TIMESTAMP)
    Date lastVisited;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "doctorId")
    Doctor doctor;
}
