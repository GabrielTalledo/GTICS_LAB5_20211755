package com.example.gtics_lab5_20211755.repository;

import com.example.gtics_lab5_20211755.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

}
