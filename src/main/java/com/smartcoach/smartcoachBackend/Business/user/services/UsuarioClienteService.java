package com.smartcoach.smartcoachBackend.Business.user.services;

import java.util.List;
import java.util.Optional;

import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;
import com.smartcoach.smartcoachBackend.Persistence.user.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioClienteService {

    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    public UsuarioCliente crearUsuarioCliente(UsuarioCliente usuarioCliente) {
        return usuarioClienteRepository.save(usuarioCliente);
    }

    public Optional<UsuarioCliente> obtenerUsuarioClientePorId(Integer id) {
        return usuarioClienteRepository.findById(id);
    }

    public List<UsuarioCliente> obtenerTodosLosUsuariosClientes() {
        return usuarioClienteRepository.findAll();
    }

    public UsuarioCliente actualizarUsuarioCliente(UsuarioCliente usuarioCliente) {
        return usuarioClienteRepository.save(usuarioCliente);
    }

    public void eliminarUsuarioClientePorId(Integer id) {
        usuarioClienteRepository.deleteById(id);
    }
}
