package com.smartcoach.smartcoachBackend.Business.exercise.controllers;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.MusculoEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.MusculoEjercicioId;
import com.smartcoach.smartcoachBackend.Business.exercise.services.MusculoEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/musculoejercicio")
public class MusculoEjercicioController {

    @Autowired
    private MusculoEjercicioService service;

    @GetMapping
    public List<MusculoEjercicio> findAll() {
        return service.findAll();
    }

    @GetMapping("/{musculoId}/{ejercicioId}")
    public MusculoEjercicio findById(@PathVariable int musculoId, @PathVariable int ejercicioId) {
        MusculoEjercicioId id = new MusculoEjercicioId(musculoId, ejercicioId);
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public MusculoEjercicio save(@RequestBody MusculoEjercicio musculoEjercicio) {
        return service.save(musculoEjercicio);
    }

    @DeleteMapping("/{musculoId}/{ejercicioId}")
    public void deleteById(@PathVariable int musculoId, @PathVariable int ejercicioId) {
        MusculoEjercicioId id = new MusculoEjercicioId(musculoId, ejercicioId);
        service.deleteById(id);
    }
}

