package com.smartcoach.smartcoachBackend.Business.exercise.controllers;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.EjercicioProgresoxEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.EjercicioProgresoxEjercicioId;
import com.smartcoach.smartcoachBackend.Business.exercise.services.EjercicioProgresoxEjercicioService;
import com.smartcoach.smartcoachBackend.Business.user.entities.ProgresoxEjercicio;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ejercicio-progresoxejercicio")
public class EjercicioProgresoxEjercicioController {

    @Autowired
    private EjercicioProgresoxEjercicioService service;

    @GetMapping("/{ejercicioId}/{progresoxEjercicioId}")
    public ResponseEntity<EjercicioProgresoxEjercicio> findById(@PathVariable Integer ejercicioId, @PathVariable Integer progresoxEjercicioId) {
        EjercicioProgresoxEjercicioId id = new EjercicioProgresoxEjercicioId(ejercicioId, progresoxEjercicioId);
        EjercicioProgresoxEjercicio entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<EjercicioProgresoxEjercicio> findAll() {
        return service.findAll();
    }

    @PostMapping
    public EjercicioProgresoxEjercicio save(@RequestBody EjercicioProgresoxEjercicio ejercicioProgresoxEjercicio) {
        return service.save(ejercicioProgresoxEjercicio);
    }

    @DeleteMapping("/{ejercicioId}/{progresoxEjercicioId}")
    public void deleteById(@PathVariable Integer ejercicioId, @PathVariable Integer progresoxEjercicioId) {
        EjercicioProgresoxEjercicioId id = new EjercicioProgresoxEjercicioId(ejercicioId, progresoxEjercicioId);
        service.deleteById(id);
    }

    @GetMapping("/findByEjeIdLatest/{ejercicioId}/{usuarioId}")
    public ProgresoxEjercicio getLatestProgresoxEjercicio(@PathVariable Integer ejercicioId, @PathVariable Integer usuarioId) {
        return service.findProgresoxEjercicioByEjercicioId(ejercicioId,usuarioId);
    }
}
