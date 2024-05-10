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
    @Size(min=3,max = 100,message = "Nombre debe ser de 3 a 100 caractéres")
    @NotBlank
    private String firstName;

    @Column(name="LastName",nullable = false)
    @Size(min=3,max = 100,message = "Apellido debe ser de 3 a 100 caractéres")
    @NotBlank
    private String lastName;

    @Column(name="Dni",nullable = false)
    @Size(min = 8, max = 8,message = "El DNI debe ser de 8 caracteres")
    @NotBlank
    private String dni;

    @Column(name="Phone",nullable = false)
    @Size(min=9, max = 9,message = "Teléfono debe ser de 9 caractéres")
    @NotBlank
    private String phone;

    @Column(name="Age",nullable = false)
    @Digits(integer = 3,fraction = 0)
    @Positive(message = "La edad debe ser positiva")
    @Max(value = 100,message = "La edad máxima es 100 años")
    private int age;


}
