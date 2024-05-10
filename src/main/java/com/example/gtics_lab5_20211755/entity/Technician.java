package com.example.gtics_lab5_20211755.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "technician")
@Getter
@Setter
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID",nullable = false)
    private int technicianID;

    @Column(name="FirstName",nullable = false)
    @Size(max = 100,message = "Solo se soportan 100 caractéres")
    @NotBlank
    private String firstName;

    @Column(name="LastName",nullable = false)
    @Size(max = 100,message = "Solo se soportan 100 caractéres")
    @NotBlank
    private String lastName;


}
