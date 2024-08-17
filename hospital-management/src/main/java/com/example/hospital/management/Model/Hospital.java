package com.example.hospital.management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int hospitalId;

    String name;

    String address;

    @JsonIgnore
    @OneToMany(mappedBy = "hospital" ,cascade = CascadeType.ALL)
    List<Doctor> doctors;

}
