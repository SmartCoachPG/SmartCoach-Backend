package com.smartcoach.smartcoachBackend.Business.admi.services;

import com.smartcoach.smartcoachBackend.Business.admi.entities.TipoEquipo;
import com.smartcoach.smartcoachBackend.Persistence.admi.TipoEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEquipoService {

    @Autowired
    private TipoEquipoRepository repository;

    public TipoEquipo create(TipoEquipo tipoEquipo) {
        return repository.save(tipoEquipo);
    }

    public TipoEquipo getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<TipoEquipo> getAll() {
        return repository.findAll();
    }

    public TipoEquipo update(TipoEquipo tipoEquipo) {
        return repository.save(tipoEquipo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
