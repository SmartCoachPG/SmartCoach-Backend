package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.RestriccionMedicaEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.RestriccionMedicaEjercicioId;
import com.smartcoach.smartcoachBackend.Persistence.exercise.RestriccionMedicaEjercicioRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class RestriccionMedicaEjercicioService {

    @Autowired
    private RestriccionMedicaEjercicioRepository repository;

    public RestriccionMedicaEjercicio findById(RestriccionMedicaEjercicioId id) {
        return repository.findById(id).orElse(null);
    }

    public List<RestriccionMedicaEjercicio> findAll() {
        return repository.findAll();
    }

    public RestriccionMedicaEjercicio save(RestriccionMedicaEjercicio restriccionMedicaEjercicio) {
        return repository.save(restriccionMedicaEjercicio);
    }

    public void deleteById(RestriccionMedicaEjercicioId id) {
        repository.deleteById(id);
    }
}

