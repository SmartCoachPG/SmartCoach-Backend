package com.smartcoach.smartcoachBackend.Business.exercise.controllers;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.RestriccionMedicaEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.RestriccionMedicaEjercicioId;
import com.smartcoach.smartcoachBackend.Business.exercise.services.RestriccionMedicaEjercicioService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restriccionmedica-ejercicio")
public class RestriccionMedicaEjercicioController {

    @Autowired
    private RestriccionMedicaEjercicioService service;

    @GetMapping("/{restriccionMedicaId}/{ejercicioId}")
    public ResponseEntity<RestriccionMedicaEjercicio> findById(@PathVariable Integer restriccionMedicaId, @PathVariable Integer ejercicioId) {
        RestriccionMedicaEjercicioId id = new RestriccionMedicaEjercicioId(restriccionMedicaId, ejercicioId);
        RestriccionMedicaEjercicio entity = service.findById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<RestriccionMedicaEjercicio> findAll() {
        return service.findAll();
    }

    @PostMapping
    public RestriccionMedicaEjercicio save(@RequestBody RestriccionMedicaEjercicio restriccionMedicaEjercicio) {
        return service.save(restriccionMedicaEjercicio);
    }

    @DeleteMapping("/{restriccionMedicaId}/{ejercicioId}")
    public void deleteById(@PathVariable Integer restriccionMedicaId, @PathVariable Integer ejercicioId) {
        RestriccionMedicaEjercicioId id = new RestriccionMedicaEjercicioId(restriccionMedicaId, ejercicioId);
        service.deleteById(id);
    }
}
