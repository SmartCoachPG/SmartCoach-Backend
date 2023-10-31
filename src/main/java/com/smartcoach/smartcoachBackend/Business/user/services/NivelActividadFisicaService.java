package com.smartcoach.smartcoachBackend.Business.user.services;

import com.smartcoach.smartcoachBackend.Business.user.entities.NivelActividadFisica;
import com.smartcoach.smartcoachBackend.Persistence.user.NivelActividadFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NivelActividadFisicaService {

    @Autowired
    private NivelActividadFisicaRepository repository;

    public List<NivelActividadFisica> findAll() {
        return repository.findAll();
    }

    public Optional<NivelActividadFisica> findById(Integer id) {
        return repository.findById(id);
    }

    public NivelActividadFisica save(NivelActividadFisica nivelActividadFisica) {
        return repository.save(nivelActividadFisica);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}

