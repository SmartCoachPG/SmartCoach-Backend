package com.smartcoach.smartcoachBackend.Business.user.controllers;

import com.smartcoach.smartcoachBackend.Business.user.entities.PerfilMedico;
import com.smartcoach.smartcoachBackend.Business.user.services.PerfilMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfilmedico")
public class PerfilMedicoController {

    @Autowired
    private PerfilMedicoService perfilMedicoService;

    @GetMapping
    public List<PerfilMedico> findAll() {
        return perfilMedicoService.findAll();
    }

    @GetMapping("/{id}")
    public PerfilMedico findById(@PathVariable int id) {
        return perfilMedicoService.findById(id).orElse(null);
    }

    @PostMapping
    public PerfilMedico save(@RequestBody PerfilMedico perfilMedico) {
        return perfilMedicoService.save(perfilMedico);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        perfilMedicoService.deleteById(id);
    }
}
