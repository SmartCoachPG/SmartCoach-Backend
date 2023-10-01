package com.smartcoach.smartcoachBackend.Business.user.controllers;
import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;
import com.smartcoach.smartcoachBackend.Business.user.services.UsuarioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuariocliente")
public class UsuarioClienteController {

    @Autowired
    private UsuarioClienteService usuarioClienteService;

    @PostMapping("/crear")
    public ResponseEntity<UsuarioCliente> create(@RequestBody UsuarioCliente usuarioCliente) {
        UsuarioCliente nuevoUsuarioCliente = usuarioClienteService.create(usuarioCliente);
        return ResponseEntity.ok(nuevoUsuarioCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioCliente> findById(@PathVariable Long id) {
        return usuarioClienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UsuarioCliente>> getAll() {
        List<UsuarioCliente> usuariosClientes = usuarioClienteService.findAll();
        return ResponseEntity.ok(usuariosClientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioCliente> update(@PathVariable Long id,@RequestBody UsuarioCliente usuarioCliente) {
        return usuarioClienteService.findById(id)
                .map(existingUsuarioCliente -> {
                    usuarioCliente.setId(id);
                    UsuarioCliente updatedCliente = usuarioClienteService.update(usuarioCliente);
                    return ResponseEntity.ok(updatedCliente);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioClienteService.deteleById(id);
        return ResponseEntity.noContent().build();
    }
}
