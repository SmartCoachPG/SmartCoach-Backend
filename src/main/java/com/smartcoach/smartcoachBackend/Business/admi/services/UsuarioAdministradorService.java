package com.smartcoach.smartcoachBackend.Business.admi.services;

import com.smartcoach.smartcoachBackend.Business.admi.entities.UsuarioAdministrador;
import com.smartcoach.smartcoachBackend.Persistence.admi.UsuarioAdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioAdministradorService {
    @Autowired
    private UsuarioAdministradorRepository usuarioAdministradorRepository;

    public UsuarioAdministrador save(UsuarioAdministrador usuarioAdministrador) {
        return usuarioAdministradorRepository.save(usuarioAdministrador);
    }

    public Optional<UsuarioAdministrador> findById(Long id) {
        return usuarioAdministradorRepository.findById(id);
    }

    public List<UsuarioAdministrador> findAll() {
        return usuarioAdministradorRepository.findAll();
    }

    public void deleteById(Long id) {
        usuarioAdministradorRepository.deleteById(id);
    }


}
