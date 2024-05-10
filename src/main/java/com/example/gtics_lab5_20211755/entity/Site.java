package com.example.gtics_lab5_20211755.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "site")
@Getter
@Setter
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteID",nullable = false)
    private int ticketID;

    @Column(name = "SiteName")
    private String siteName;

    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Location location;

    @Column(name = "InstallationDate")
    private Date installationDate;

    @Column(name = "Latitude")
    private String latitude;

    @Column(name = "Longitude")
    private String longitude;
}
