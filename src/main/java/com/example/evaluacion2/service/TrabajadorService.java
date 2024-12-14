/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.evaluacion2.service;

import com.example.evaluacion2.model.Trabajador;
import com.example.evaluacion2.repository.TrabajadorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    public List<Trabajador> findAll() {
        return trabajadorRepository.findAll();
    }

    public Trabajador save(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador findById(Long id) {
        return trabajadorRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        trabajadorRepository.deleteById(id);
    }
}