package com.smartcoach.smartcoachBackend.Business.exercise.controllers;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.EquipoEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.EquipoEjercicioId;
import com.smartcoach.smartcoachBackend.Business.exercise.services.EquipoEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipoejercicio")
public class EquipoEjercicioController {

    @Autowired
    private EquipoEjercicioService service;

    @GetMapping
    public List<EquipoEjercicio> findAll() {
        return service.findAll();
    }

    @GetMapping("/{equipoItemid}/{ejercicioid}")
    public EquipoEjercicio findById(@PathVariable int equipoItemid, @PathVariable int ejercicioid) {
        EquipoEjercicioId id = new EquipoEjercicioId(equipoItemid, ejercicioid);
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public EquipoEjercicio save(@RequestBody EquipoEjercicio equipoEjercicio) {
        return service.save(equipoEjercicio);
    }

    @DeleteMapping("/{equipoItemid}/{ejercicioid}")
    public void deleteById(@PathVariable int equipoItemid, @PathVariable int ejercicioid) {
        EquipoEjercicioId id = new EquipoEjercicioId(equipoItemid, ejercicioid);
        service.deleteById(id);
    }
}

