/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.evaluacion2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.evaluacion2.model.Trabajador;
import com.example.evaluacion2.service.TrabajadorService;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public String listarTrabajadores(Model model) {
        model.addAttribute("trabajadores", trabajadorService.findAll());
        return "trabajadores"; // Vista para listar trabajadores
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoTrabajador(Model model) {
        model.addAttribute("trabajador", new Trabajador());
        return "formularioTrabajador"; // Vista para el formulario de nuevo trabajador
    }

    @PostMapping("/nuevo")
    public String guardarNuevoTrabajador(@ModelAttribute Trabajador trabajador) {
        trabajadorService.save(trabajador);
        return "redirect:/trabajadores"; // Redirige a la lista de trabajadores
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarTrabajador(@PathVariable("id") Long id, Model model) {
        Trabajador trabajador = trabajadorService.findById(id);
        model.addAttribute("trabajador", trabajador);
        return "formularioTrabajador"; // Vista para editar trabajador
    }

    @PostMapping("/editar/{id}")
    public String guardarEdicionTrabajador(@PathVariable("id") Long id, @ModelAttribute Trabajador trabajador) {
        trabajador.setId(id);
        trabajadorService.save(trabajador);
        return "redirect:/trabajadores"; // Redirige a la lista de trabajadores
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTrabajador(@PathVariable("id") Long id) {
        trabajadorService.delete(id);
        return "redirect:/trabajadores"; // Redirige a la lista de trabajadores
    }
}
