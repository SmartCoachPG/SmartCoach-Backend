package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.MusculoEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.MusculoEjercicioId;
import com.smartcoach.smartcoachBackend.Persistence.exercise.MusculoEjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusculoEjercicioService {

    @Autowired
    private MusculoEjercicioRepository repository;

    public List<MusculoEjercicio> findAll() {
        return repository.findAll();
    }

    public Optional<MusculoEjercicio> findById(MusculoEjercicioId id) {
        return repository.findById(id);
    }

    public MusculoEjercicio save(MusculoEjercicio musculoEjercicio) {
        return repository.save(musculoEjercicio);
    }

    public void deleteById(MusculoEjercicioId id) {
        repository.deleteById(id);
    }
}
