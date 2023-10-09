package com.smartcoach.smartcoachBackend.Business.exercise.controllers;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.GrupoMuscular;
import com.smartcoach.smartcoachBackend.Business.exercise.services.GrupoMuscularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupomuscular")
public class GrupoMuscularController {

    @Autowired
    private GrupoMuscularService grupoMuscularService;

    @GetMapping("/crear")
    public List<GrupoMuscular> getAll() {
        return grupoMuscularService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoMuscular> getById(@PathVariable Long id) {
        return grupoMuscularService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GrupoMuscular create(@RequestBody GrupoMuscular grupoMuscular) {
        return grupoMuscularService.save(grupoMuscular);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoMuscular> update(@PathVariable Long id, @RequestBody GrupoMuscular grupoMuscular) {
        if (!grupoMuscularService.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        grupoMuscular.setId(id);
        return ResponseEntity.ok(grupoMuscularService.save(grupoMuscular));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!grupoMuscularService.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        grupoMuscularService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
