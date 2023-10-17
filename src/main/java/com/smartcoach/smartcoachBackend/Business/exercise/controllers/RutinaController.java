package com.smartcoach.smartcoachBackend.Business.exercise.controllers;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Rutina;
import com.smartcoach.smartcoachBackend.Business.exercise.services.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutina")
public class RutinaController {

    @Autowired
    private RutinaService rutinaService;

    @GetMapping
    public List<Rutina> findAll() {
        return rutinaService.findAll();
    }

    @GetMapping("/{id}")
    public Rutina findById(@PathVariable int id) {
        return rutinaService.findById(id);
    }

    @PostMapping("/crear")
    public Rutina save(@RequestBody Rutina rutina) {
        return rutinaService.save(rutina);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        rutinaService.deleteById(id);
    }

    @GetMapping("/getByUser/{id}")
    public List<Rutina> getByUsuarioClienteId(@PathVariable  int id) {
        return rutinaService.getByUsuarioClienteId(id);
    }

}
