package com.smartcoach.smartcoachBackend.Business.user.controllers;

import com.smartcoach.smartcoachBackend.Business.user.entities.RestriccionMedica;
import com.smartcoach.smartcoachBackend.Business.user.services.RestriccionMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restriccionmedica")
public class RestriccionMedicaController {

    @Autowired
    private RestriccionMedicaService restriccionMedicaService;

    @GetMapping("/libre")
    public List<RestriccionMedica> findAll() {
        return restriccionMedicaService.findAll();
    }

    @GetMapping("/{id}")
    public RestriccionMedica findById(@PathVariable int id) {
        return restriccionMedicaService.findById(id).orElse(null);
    }

    @PostMapping
    public RestriccionMedica save(@RequestBody RestriccionMedica restriccionMedica) {
        return restriccionMedicaService.save(restriccionMedica);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        restriccionMedicaService.deleteById(id);
    }
}
