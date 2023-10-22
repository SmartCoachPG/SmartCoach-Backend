package com.smartcoach.smartcoachBackend.Business.user.services;

import java.util.List;
import java.util.Optional;

import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;
import com.smartcoach.smartcoachBackend.Persistence.user.UsuarioClienteRepository;
import com.smartcoach.smartcoachBackend.Security.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioClienteService {

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    public UsuarioCliente create(UsuarioCliente usuarioCliente) {
        String password = usuarioCliente.getContrasenna();
        usuarioCliente.setContrasenna(passwordService.encryptPassword(password));
        return usuarioClienteRepository.save(usuarioCliente);
    }

    public UsuarioCliente update(UsuarioCliente usuarioCliente)
    {
        return usuarioClienteRepository.save(usuarioCliente);
    }

    public Optional<UsuarioCliente> findById(Long id) {
        return usuarioClienteRepository.findById(id);
    }

    public List<UsuarioCliente> findAll() {
        return usuarioClienteRepository.findAll();
    }

    public void deteleById(Long  id) {
        usuarioClienteRepository.deleteById(id);
    }

    public List<UsuarioCliente> getUsuarioClientesByGimnasioid(Integer gimnasioid) {
        return usuarioClienteRepository.findByGimnasioid(gimnasioid);
    }

}
