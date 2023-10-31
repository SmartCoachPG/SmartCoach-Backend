package com.smartcoach.smartcoachBackend.Business.exercise.controllers;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Ejercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.services.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ejercicio")
public class EjercicioController {

    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping
    public List<Ejercicio> findAll() {
        return ejercicioService.findAll();
    }

    @GetMapping("/{id}")
    public Ejercicio findById(@PathVariable Long id) {
        return ejercicioService.findById(id);
    }

    @PostMapping
    public Ejercicio save(@RequestBody Ejercicio ejercicio) {
        return ejercicioService.save(ejercicio);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        ejercicioService.deleteById(id);
    }
}
