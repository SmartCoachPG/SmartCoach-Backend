package com.smartcoach.smartcoachBackend.Business.exercise.controllers;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Ejercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.RutinaEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.RutinaEjercicioId;
import com.smartcoach.smartcoachBackend.Business.exercise.services.RutinaEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/rutinaejercicio")
public class RutinaEjercicioController {

    @Autowired
    private RutinaEjercicioService service;

    @GetMapping
    public List<RutinaEjercicio> findAll() {
        return service.findAll();
    }

    @GetMapping("/{rutinaId}/{ejercicioId}")
    public RutinaEjercicio findById(@PathVariable Integer rutinaId, @PathVariable Integer ejercicioId) {
        return service.findById(new RutinaEjercicioId(rutinaId, ejercicioId));
    }

    @PostMapping
    public RutinaEjercicio save(@RequestBody RutinaEjercicio rutinaEjercicio) {
        return service.save(rutinaEjercicio);
    }

    @DeleteMapping("/{rutinaId}/{ejercicioId}")
    public void deleteById(@PathVariable Integer rutinaId, @PathVariable Integer ejercicioId) {
        service.deleteById(new RutinaEjercicioId(rutinaId, ejercicioId));
    }

    @GetMapping("/getByRutinaId/{rutinaId}")
    public List<Ejercicio> findById(@PathVariable Integer rutinaId) {
        return service.getEjerciciosByRutinaId(rutinaId);
    }
}

