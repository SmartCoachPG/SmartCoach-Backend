package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.RutinaMusculo;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.RutinaMusculoId;
import com.smartcoach.smartcoachBackend.Persistence.exercise.RutinaMusculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RutinaMusculoService {

    @Autowired
    private RutinaMusculoRepository repository;

    public List<RutinaMusculo> findAll() {
        return repository.findAll();
    }

    public Optional<RutinaMusculo> findById(RutinaMusculoId id) {
        return repository.findById(id);
    }

    public RutinaMusculo save(RutinaMusculo rutinaMusculo) {
        return repository.save(rutinaMusculo);
    }

    public void deleteById(RutinaMusculoId id) {
        repository.deleteById(id);
    }
}
