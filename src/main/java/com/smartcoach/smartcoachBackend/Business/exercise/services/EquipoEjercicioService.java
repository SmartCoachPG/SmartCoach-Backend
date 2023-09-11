package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.EquipoEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.EquipoEjercicioId;
import com.smartcoach.smartcoachBackend.Persistence.exercise.EquipoEjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoEjercicioService {

    @Autowired
    private EquipoEjercicioRepository repository;

    public List<EquipoEjercicio> findAll() {
        return repository.findAll();
    }

    public Optional<EquipoEjercicio> findById(EquipoEjercicioId id) {
        return repository.findById(id);
    }

    public EquipoEjercicio save(EquipoEjercicio equipoEjercicio) {
        return repository.save(equipoEjercicio);
    }

    public void deleteById(EquipoEjercicioId id) {
        repository.deleteById(id);
    }
}

