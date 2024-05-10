package com.example.gtics_lab5_20211755.controller;

import com.example.gtics_lab5_20211755.entity.Technician;
import com.example.gtics_lab5_20211755.repository.TechnicianRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String editarTecnico(@ModelAttribute("tecnico") Technician tecnico,
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

    @PostMapping("/save")
    public String guardarTecnico(RedirectAttributes attr, Model model,
                                  @ModelAttribute("tecnico") @Valid Technician tecnico, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {

            if (tecnico.getTechnicianID() == 0) {
                attr.addFlashAttribute("msg", "Técnico " + tecnico.getFirstName() + " " + tecnico.getLastName() + " creado exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Técnico " + tecnico.getFirstName() + " " + tecnico.getLastName() + " actualizado exitosamente");
            }
            technicianRepository.save(tecnico);
            return "redirect:/technician";

        } else { //Error
            return "technician/editFrm";
        }
    }

    @GetMapping("/delete")
    public String borrarTecnico(@RequestParam("id") int id,
                                      RedirectAttributes attr) {
        Optional<Technician> optTech = technicianRepository.findById(id);

        if (optTech.isPresent()) {
            technicianRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Técnico borrado exitosamente");
        }
        return "redirect:/technician";
    }
}
