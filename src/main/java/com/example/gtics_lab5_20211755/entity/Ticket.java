package com.example.gtics_lab5_20211755.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ticket")
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID",nullable = false)
    private int ticketID;

    @ManyToOne
    @JoinColumn(name = "TechnicianID")
    private Technician technician;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site site;

    @Column(name = "Status")
    private String status;

    @Column(name = "OpenedDate")
    private Date openedDate;

    @Column(name = "ClosedDate")
    private Date closedDate;


}
