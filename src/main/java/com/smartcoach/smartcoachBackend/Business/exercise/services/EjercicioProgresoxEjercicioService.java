package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.EjercicioProgresoxEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.EjercicioProgresoxEjercicioId;
import com.smartcoach.smartcoachBackend.Persistence.exercise.EjercicioProgresoxEjercicioRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioProgresoxEjercicioService {

    @Autowired
    private EjercicioProgresoxEjercicioRepository repository;

    public EjercicioProgresoxEjercicio findById(EjercicioProgresoxEjercicioId id) {
        return repository.findById(id).orElse(null);
    }

    public List<EjercicioProgresoxEjercicio> findAll() {
        return repository.findAll();
    }

    public EjercicioProgresoxEjercicio save(EjercicioProgresoxEjercicio ejercicioProgresoxEjercicio) {
        return repository.save(ejercicioProgresoxEjercicio);
    }

    public void deleteById(EjercicioProgresoxEjercicioId id) {
        repository.deleteById(id);
    }
}
