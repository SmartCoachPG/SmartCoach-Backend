package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Musculo;
import com.smartcoach.smartcoachBackend.Persistence.exercise.MusculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusculoService {

    @Autowired
    private MusculoRepository musculoRepository;

    public List<Musculo> findAll() {
        return musculoRepository.findAll();
    }

    public Musculo findById(Long id) {
        return musculoRepository.findById(id).orElse(null);
    }

    public Musculo save(Musculo musculo) {
        return musculoRepository.save(musculo);
    }

    public void deleteById(Long id) {
        musculoRepository.deleteById(id);
    }
}

