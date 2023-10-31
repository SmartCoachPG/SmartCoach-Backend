package com.smartcoach.smartcoachBackend.Business.user.controllers;

import com.smartcoach.smartcoachBackend.Business.user.entities.ProgresoxEjercicio;
import com.smartcoach.smartcoachBackend.Business.user.services.ProgresoxEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/progresoxejercicio")
public class ProgresoxEjercicioController {

    @Autowired
    private ProgresoxEjercicioService progresoxEjercicioService;

    @GetMapping
    public List<ProgresoxEjercicio> findAll() {
        return progresoxEjercicioService.findAll();
    }

    @GetMapping("/{id}")
    public ProgresoxEjercicio findById(@PathVariable Long id) {
        return progresoxEjercicioService.findById(id);
    }

    @PostMapping
    public ProgresoxEjercicio save(@RequestBody ProgresoxEjercicio progresoxEjercicio) {
        return progresoxEjercicioService.save(progresoxEjercicio);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        progresoxEjercicioService.deleteById(id);
    }

    @GetMapping("/getByUser/{id}")
    public List<ProgresoxEjercicio> getByUsuarioClienteId(@PathVariable Integer id) {
        return progresoxEjercicioService.findByUsuarioClienteId(id);
    }
}
