package com.smartcoach.smartcoachBackend.Business.user.services;

import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioClienteRestriccionMedica;
import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioClienteRestriccionMedicaId;
import com.smartcoach.smartcoachBackend.Persistence.user.UsuarioClienteRestriccionMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioClienteRestriccionMedicaService {

    @Autowired
    private UsuarioClienteRestriccionMedicaRepository repository;

    public List<UsuarioClienteRestriccionMedica> findAll() {
        return repository.findAll();
    }

    public UsuarioClienteRestriccionMedica findById(UsuarioClienteRestriccionMedicaId id) {
        return repository.findById(id).orElse(null);
    }

    public UsuarioClienteRestriccionMedica save(UsuarioClienteRestriccionMedica usuarioClienteRestriccionMedica) {
        return repository.save(usuarioClienteRestriccionMedica);
    }

    public void deleteById(UsuarioClienteRestriccionMedicaId id) {
        repository.deleteById(id);
    }

    public void deleteByUsuarioClienteUsuarioid(Integer usuarioClienteUsuarioid) {
        repository.deleteByUsuarioClienteUsuarioid(usuarioClienteUsuarioid);
    }
}
