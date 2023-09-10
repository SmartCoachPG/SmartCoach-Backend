package com.smartcoach.smartcoachBackend.Business.admi.services;

import com.smartcoach.smartcoachBackend.Business.admi.entities.Equipo;
import com.smartcoach.smartcoachBackend.Persistence.admi.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository repository;

    public Equipo create(Equipo equipo) {
        return repository.save(equipo);
    }

    public Equipo getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Equipo> getAll() {
        return repository.findAll();
    }

    public Equipo update(Equipo equipo) {
        return repository.save(equipo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
