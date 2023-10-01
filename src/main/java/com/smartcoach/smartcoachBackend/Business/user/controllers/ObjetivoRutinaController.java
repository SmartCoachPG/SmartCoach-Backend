package com.smartcoach.smartcoachBackend.Business.user.controllers;

import com.smartcoach.smartcoachBackend.Business.user.entities.ObjetivoRutina;
import com.smartcoach.smartcoachBackend.Business.user.services.ObjetivoRutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objetivorutina")
public class ObjetivoRutinaController {

    @Autowired
    private ObjetivoRutinaService objetivoRutinaService;

    @PostMapping
    public ObjetivoRutina create(@RequestBody ObjetivoRutina objetivoRutina) {
        return create(objetivoRutina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjetivoRutina> findById(@PathVariable Long id) {
        ObjetivoRutina objetivoRutina = objetivoRutinaService.findById(id);
        if (objetivoRutina != null) {
            return ResponseEntity.ok(objetivoRutina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ObjetivoRutina>> findAll() {
        List<ObjetivoRutina> objetivoRutinas = objetivoRutinaService.findAll();
        return ResponseEntity.ok(objetivoRutinas);
    }

    @GetMapping("/crear")
    public ResponseEntity<List<ObjetivoRutina>> findAllCreate() {
        List<ObjetivoRutina> objetivoRutinas = objetivoRutinaService.findAll();
        return ResponseEntity.ok(objetivoRutinas);
    }




    @PutMapping
    public ObjetivoRutina update(@RequestBody ObjetivoRutina objetivoRutina) {
        return update(objetivoRutina);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        delete(id);
    }
}

