package com.example.gtics_lab5_20211755.controller;

import com.example.gtics_lab5_20211755.repository.TicketRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stadistic")
public class StadisticController {

    final TicketRepository ticketRepository;

    public StadisticController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping(value = {"", "/"})
    public String lista(Model model) {
        model.addAttribute("listaIntervenciones", ticketRepository.obtenerIntervencionesPorSitio());
        return "stadistic/list";
    }

}
