package com.smartcoach.smartcoachBackend.Business.user.controllers;

import com.smartcoach.smartcoachBackend.Business.user.entities.Valor;
import com.smartcoach.smartcoachBackend.Business.user.services.ValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/valor")
public class ValorController {

    @Autowired
    private ValorService valorService;

    @GetMapping
    public List<Valor> findAll() {
        return valorService.findAll();
    }

    @GetMapping("/{id}")
    public Valor findById(@PathVariable int id) {
        return valorService.findById(id).orElse(null);
    }

    @PostMapping("/crear")
    public Valor save(@RequestBody Valor valor) {
        return valorService.save(valor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        valorService.deleteById(id);
    }
}
