package com.smartcoach.smartcoachBackend.Business.admi.controllers;

import com.smartcoach.smartcoachBackend.Business.admi.entities.TipoEquipo;
import com.smartcoach.smartcoachBackend.Business.admi.services.TipoEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoequipo")
public class TipoEquipoController {

    @Autowired
    private TipoEquipoService service;

    @PostMapping
    public TipoEquipo create(@RequestBody TipoEquipo tipoEquipo) {
        return service.create(tipoEquipo);
    }

    @GetMapping("/{id}")
    public TipoEquipo getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<TipoEquipo> getAll() {
        return service.getAll();
    }

    @PutMapping
    public TipoEquipo update(@RequestBody TipoEquipo tipoEquipo) {
        return service.update(tipoEquipo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
