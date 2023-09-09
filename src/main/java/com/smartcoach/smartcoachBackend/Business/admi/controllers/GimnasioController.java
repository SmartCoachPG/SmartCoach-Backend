package com.smartcoach.smartcoachBackend.Business.admi.controllers;
import com.smartcoach.smartcoachBackend.Business.admi.entities.Gimnasio;
import com.smartcoach.smartcoachBackend.Business.admi.services.GimnasioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gimnasio")
public class GimnasioController {

    @Autowired
    private GimnasioService gimnasioService;

    @GetMapping
    public List<Gimnasio> findAll() {
        return gimnasioService.findAll();
    }

    @GetMapping("/{id}")
    public Gimnasio findById(@PathVariable Long id) {
        return gimnasioService.findById(id);
    }

    @PostMapping
    public Gimnasio save(@RequestBody Gimnasio gimnasio) {
        return gimnasioService.save(gimnasio);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        gimnasioService.deleteById(id);
    }
}
