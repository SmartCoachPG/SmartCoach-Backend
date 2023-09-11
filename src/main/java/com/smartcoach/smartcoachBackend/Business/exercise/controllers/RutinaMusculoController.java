package com.smartcoach.smartcoachBackend.Business.exercise.controllers;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.RutinaMusculo;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.RutinaMusculoId;
import com.smartcoach.smartcoachBackend.Business.exercise.services.RutinaMusculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/rutinamusculo")
public class RutinaMusculoController {

    @Autowired
    private RutinaMusculoService service;

    @GetMapping
    public List<RutinaMusculo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{rutinaId}/{musculoId}")
    public RutinaMusculo findById(@PathVariable Long rutinaId, @PathVariable Long musculoId) {
        RutinaMusculoId id = new RutinaMusculoId(rutinaId, musculoId);
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public RutinaMusculo save(@RequestBody RutinaMusculo rutinaMusculo) {
        return service.save(rutinaMusculo);
    }

    @DeleteMapping("/{rutinaId}/{musculoId}")
    public void deleteById(@PathVariable Long rutinaId, @PathVariable Long musculoId) {
        RutinaMusculoId id = new RutinaMusculoId(rutinaId, musculoId);
        service.deleteById(id);
    }
}
