package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.GrupoMuscular;
import com.smartcoach.smartcoachBackend.Persistence.exercise.GrupoMuscularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoMuscularService {

    @Autowired
    private GrupoMuscularRepository grupoMuscularRepository;

    public List<GrupoMuscular> getAll() {
        return grupoMuscularRepository.findAll();
    }

    public Optional<GrupoMuscular> getById(Long id) {
        return grupoMuscularRepository.findById(id);
    }

    public GrupoMuscular save(GrupoMuscular grupoMuscular) {
        return grupoMuscularRepository.save(grupoMuscular);
    }

    public void delete(Long id) {
        grupoMuscularRepository.deleteById(id);
    }
}
