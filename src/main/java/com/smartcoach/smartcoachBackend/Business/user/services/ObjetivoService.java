package com.smartcoach.smartcoachBackend.Business.user.services;

import com.smartcoach.smartcoachBackend.Business.user.entities.Objetivo;
import com.smartcoach.smartcoachBackend.Persistence.user.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetivoService {

    @Autowired
    private ObjetivoRepository objetivoRepository;

    public List<Objetivo> findAll() {
        return objetivoRepository.findAll();
    }

    public Objetivo findById(Long id) {
        return objetivoRepository.findById(id).orElse(null);
    }

    public Objetivo save(Objetivo objetivo) {
        return objetivoRepository.save(objetivo);
    }

    public void deleteById(Long id) {
        objetivoRepository.deleteById(id);
    }
}
