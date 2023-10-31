package com.smartcoach.smartcoachBackend.Business.user.controllers;

import com.smartcoach.smartcoachBackend.Business.user.entities.NivelActividadFisica;
import com.smartcoach.smartcoachBackend.Business.user.services.NivelActividadFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/nivelactividadfisica")
public class NivelActividadFisicaController {

    @Autowired
    private NivelActividadFisicaService service;

    @GetMapping
    public List<NivelActividadFisica> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NivelActividadFisica> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NivelActividadFisica create(@RequestBody NivelActividadFisica nivelActividadFisica) {
        return service.save(nivelActividadFisica);
    }

    @PutMapping
    public NivelActividadFisica update(@RequestBody NivelActividadFisica nivelActividadFisica) {
        return service.save(nivelActividadFisica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
