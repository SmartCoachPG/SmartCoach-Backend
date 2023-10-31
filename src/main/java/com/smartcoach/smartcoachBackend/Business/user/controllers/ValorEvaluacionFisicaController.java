package com.smartcoach.smartcoachBackend.Business.user.controllers;

import com.smartcoach.smartcoachBackend.Business.user.entities.ValorEvaluacionFisica;
import com.smartcoach.smartcoachBackend.Business.user.services.ValorEvaluacionFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/valorevaluacionfisica")
public class ValorEvaluacionFisicaController {

    @Autowired
    private ValorEvaluacionFisicaService valorEvaluacionFisicaService;

    @GetMapping("/libre")
    public List<ValorEvaluacionFisica> findAll() {
        return valorEvaluacionFisicaService.findAll();
    }

    @GetMapping("/{id}")
    public ValorEvaluacionFisica findById(@PathVariable int id) {
        return valorEvaluacionFisicaService.findById(id).orElse(null);
    }

    @PostMapping
    public ValorEvaluacionFisica save(@RequestBody ValorEvaluacionFisica valorEvaluacionFisica) {
        return valorEvaluacionFisicaService.save(valorEvaluacionFisica);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        valorEvaluacionFisicaService.deleteById(id);
    }
}
