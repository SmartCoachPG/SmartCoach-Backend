package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.RutinaEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.RutinaEjercicioId;
import com.smartcoach.smartcoachBackend.Persistence.exercise.RutinaEjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaEjercicioService {

    @Autowired
    private RutinaEjercicioRepository repository;

    public List<RutinaEjercicio> findAll() {
        return repository.findAll();
    }

    public RutinaEjercicio findById(RutinaEjercicioId id) {
        return repository.findById(id).orElse(null);
    }

    public RutinaEjercicio save(RutinaEjercicio rutinaEjercicio) {
        return repository.save(rutinaEjercicio);
    }

    public void deleteById(RutinaEjercicioId id) {
        repository.deleteById(id);
    }

    public RutinaEjercicio saveRutinaEjercicio(Integer rutinaId, Integer ejercicioid) {
        RutinaEjercicio rutinaEjercicio = new RutinaEjercicio();
        rutinaEjercicio.setRutinaId(rutinaId);
        rutinaEjercicio.setEjercicioid(ejercicioid);
        return repository.save(rutinaEjercicio);
    }
}
