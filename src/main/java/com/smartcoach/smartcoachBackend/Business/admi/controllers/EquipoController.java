package com.smartcoach.smartcoachBackend.Business.admi.controllers;

import com.smartcoach.smartcoachBackend.Business.admi.entities.Equipo;
import com.smartcoach.smartcoachBackend.Business.admi.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/equipo")
public class EquipoController {

    @Autowired
    private EquipoService service;

    @PostMapping
    public Equipo create(@RequestBody Equipo equipo) {
        return service.create(equipo);
    }

    @GetMapping("/{id}")
    public Equipo getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Equipo> getAll() {
        return service.getAll();
    }

    @PutMapping
    public Equipo update(@RequestBody Equipo equipo) {
        return service.update(equipo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/getTipoEquipoByItemId/{itemId}")
    public Integer findTipoEquipoIdByItemId(@PathVariable Long itemId) {
        return service.findTipoEquipoIdByItemId(itemId);
    }
}
