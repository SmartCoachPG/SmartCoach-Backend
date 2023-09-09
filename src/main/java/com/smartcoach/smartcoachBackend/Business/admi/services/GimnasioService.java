package com.smartcoach.smartcoachBackend.Business.admi.services;

import com.smartcoach.smartcoachBackend.Business.admi.entities.Gimnasio;
import com.smartcoach.smartcoachBackend.Persistence.admi.GimnasioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GimnasioService {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    public List<Gimnasio> findAll() {
        return gimnasioRepository.findAll();
    }

    public Gimnasio findById(Long id) {
        return gimnasioRepository.findById(id).orElse(null);
    }

    public Gimnasio save(Gimnasio gimnasio) {
        return gimnasioRepository.save(gimnasio);
    }

    public void deleteById(Long id) {
        gimnasioRepository.deleteById(id);
    }
}
