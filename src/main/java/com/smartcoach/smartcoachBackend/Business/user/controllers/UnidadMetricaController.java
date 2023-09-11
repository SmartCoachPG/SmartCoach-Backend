package com.smartcoach.smartcoachBackend.Business.user.controllers;

import com.smartcoach.smartcoachBackend.Business.user.entities.UnidadMetrica;
import com.smartcoach.smartcoachBackend.Business.user.services.UnidadMetricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidadmetrica")
public class UnidadMetricaController {

    @Autowired
    private UnidadMetricaService unidadMetricaService;

    @GetMapping
    public List<UnidadMetrica> findAll() {
        return unidadMetricaService.findAll();
    }

    @GetMapping("/{id}")
    public UnidadMetrica findById(@PathVariable int id) {
        return unidadMetricaService.findById(id).orElse(null);
    }

    @PostMapping
    public UnidadMetrica save(@RequestBody UnidadMetrica unidadMetrica) {
        return unidadMetricaService.save(unidadMetrica);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        unidadMetricaService.deleteById(id);
    }
}

