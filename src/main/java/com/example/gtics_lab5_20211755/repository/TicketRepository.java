package com.example.gtics_lab5_20211755.repository;

import com.example.gtics_lab5_20211755.dto.IntervencionesPorSitio;
import com.example.gtics_lab5_20211755.entity.Technician;
import com.example.gtics_lab5_20211755.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "SELECT count(t.TicketID) as CantidadIntervenciones, s.SiteName as NombreSitio, l.City as Ciudad, l.Country as Pais  FROM ticket t INNER JOIN site s ON t.SiteID=s.SiteID INNER JOIN location l ON l.LocationID=s.LocationID GROUP BY s.SiteID",
            nativeQuery = true)
    List<IntervencionesPorSitio> obtenerIntervencionesPorSitio();
}
