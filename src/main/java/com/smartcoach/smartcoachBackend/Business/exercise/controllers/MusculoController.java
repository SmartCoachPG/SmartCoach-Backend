package com.smartcoach.smartcoachBackend.Business.exercise.controllers;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Musculo;
import com.smartcoach.smartcoachBackend.Business.exercise.services.MusculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/musculo")
public class MusculoController {

    @Autowired
    private MusculoService musculoService;

    @GetMapping
    public List<Musculo> findAll() {
        return musculoService.findAll();
    }

    @GetMapping("/{id}")
    public Musculo findById(@PathVariable Long id) {
        return musculoService.findById(id);
    }

    @PostMapping
    public Musculo save(@RequestBody Musculo musculo) {
        return musculoService.save(musculo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        musculoService.deleteById(id);
    }
}
