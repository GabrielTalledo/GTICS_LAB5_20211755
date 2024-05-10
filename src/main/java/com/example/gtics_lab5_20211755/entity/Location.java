package com.example.gtics_lab5_20211755.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "location")
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationID",nullable = false)
    private int locationID;

    @Column(name = "City")
    private String city;

    @Column(name = "Country")
    private String country;
}
