package com.smartcoach.smartcoachBackend.Business.user.controllers;

import com.smartcoach.smartcoachBackend.Business.user.entities.Objetivo;
import com.smartcoach.smartcoachBackend.Business.user.services.ObjetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/objetivo")
public class ObjetivoController {

    @Autowired
    private ObjetivoService objetivoService;

    @GetMapping
    public List<Objetivo> findAll() {
        return objetivoService.findAll();
    }

    @GetMapping("/{id}")
    public Objetivo findById(@PathVariable Long id) {
        return objetivoService.findById(id);
    }

    @PostMapping
    public Objetivo save(@RequestBody Objetivo objetivo) {
        return objetivoService.save(objetivo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        objetivoService.deleteById(id);
    }
}
