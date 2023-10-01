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

    @PostMapping
    public ResponseEntity<UsuarioCliente> crearUsuarioCliente(@RequestBody UsuarioCliente usuarioCliente) {
        UsuarioCliente nuevoUsuarioCliente = usuarioClienteService.crearUsuarioCliente(usuarioCliente);
        return ResponseEntity.ok(nuevoUsuarioCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioCliente> obtenerUsuarioClientePorId(@PathVariable Long id) {
        return usuarioClienteService.obtenerUsuarioClientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UsuarioCliente>> obtenerTodosLosUsuariosClientes() {
        List<UsuarioCliente> usuariosClientes = usuarioClienteService.obtenerTodosLosUsuariosClientes();
        return ResponseEntity.ok(usuariosClientes);
    }

    @PutMapping
    public ResponseEntity<UsuarioCliente> actualizarUsuarioCliente(@RequestBody UsuarioCliente usuarioCliente) {
        UsuarioCliente usuarioClienteActualizado = usuarioClienteService.actualizarUsuarioCliente(usuarioCliente);
        return ResponseEntity.ok(usuarioClienteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarioClientePorId(@PathVariable Long id) {
        usuarioClienteService.eliminarUsuarioClientePorId(id);
        return ResponseEntity.noContent().build();
    }
}
