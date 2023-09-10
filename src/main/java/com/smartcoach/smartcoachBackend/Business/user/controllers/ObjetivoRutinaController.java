package com.smartcoach.smartcoachBackend.Business.user.controllers;

import com.smartcoach.smartcoachBackend.Business.user.entities.ObjetivoRutina;
import com.smartcoach.smartcoachBackend.Business.user.services.ObjetivoRutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objetivorutina")
public class ObjetivoRutinaController {

    @Autowired
    private ObjetivoRutinaService service;

    @PostMapping
    public ObjetivoRutina create(@RequestBody ObjetivoRutina objetivoRutina) {
        return service.create(objetivoRutina);
    }

    @GetMapping("/{id}")
    public ObjetivoRutina getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ObjetivoRutina> getAll() {
        return service.getAll();
    }

    @PutMapping
    public ObjetivoRutina update(@RequestBody ObjetivoRutina objetivoRutina) {
        return service.update(objetivoRutina);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

