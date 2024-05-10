package com.example.gtics_lab5_20211755.controller;

import com.example.gtics_lab5_20211755.entity.Technician;
import com.example.gtics_lab5_20211755.repository.TechnicianRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/technician")
public class TechinicianController {
    final TechnicianRepository technicianRepository;

    public TechinicianController(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @GetMapping(value = {"", "/"})
    public String listaProductos(Model model) {
        model.addAttribute("listaTecnicos", technicianRepository.findAll());
        return "technician/list";
    }

    @GetMapping("/new")
    public String nuevoTecnicoFrm(Model model, @ModelAttribute("tecnico") Technician tecnico) {
        return "technician/editFrm";
    }

    @GetMapping("/edit")
    public String editarTecnico(@ModelAttribute("product") Technician tecnico,
                                      Model model, @RequestParam("id") int id) {

        Optional<Technician> optTech = technicianRepository.findById(id);

        if (optTech.isPresent()) {
            tecnico = optTech.get();
            model.addAttribute("tecnico", tecnico);
            return "technician/editFrm";
        } else {
            return "redirect:/technician";
        }
    }
}
