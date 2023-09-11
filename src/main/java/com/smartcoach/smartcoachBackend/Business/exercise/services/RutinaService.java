package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Rutina;
import com.smartcoach.smartcoachBackend.Persistence.exercise.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    public List<Rutina> findAll() {
        return rutinaRepository.findAll();
    }

    public Rutina findById(int id) {
        return rutinaRepository.findById(id).orElse(null);
    }

    public Rutina save(Rutina rutina) {
        return rutinaRepository.save(rutina);
    }

    public void deleteById(int id) {
        rutinaRepository.deleteById(id);
    }
}
