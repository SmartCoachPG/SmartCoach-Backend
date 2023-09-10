package com.smartcoach.smartcoachBackend.Business.admi.controllers;

import com.smartcoach.smartcoachBackend.Business.admi.entities.Mapa;
import com.smartcoach.smartcoachBackend.Business.admi.services.MapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mapa")
public class MapaController {

    @Autowired
    private MapaService mapaService;

    @GetMapping
    public List<Mapa> findAll() {
        return mapaService.findAll();
    }

    @GetMapping("/{id}")
    public Mapa findById(@PathVariable Long id) {
        return mapaService.findById(id);
    }

    @PostMapping
    public Mapa save(@RequestBody Mapa mapa) {
        return mapaService.save(mapa);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        mapaService.deleteById(id);
    }
}
