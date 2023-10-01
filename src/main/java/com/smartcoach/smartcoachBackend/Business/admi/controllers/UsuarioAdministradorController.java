package com.smartcoach.smartcoachBackend.Business.admi.controllers;
import com.smartcoach.smartcoachBackend.Business.admi.entities.UsuarioAdministrador;
import com.smartcoach.smartcoachBackend.Business.admi.services.UsuarioAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarioadministrador")
public class UsuarioAdministradorController {
    @Autowired
    private UsuarioAdministradorService usuarioAdministradorService;

    @PostMapping("/crear")
    public ResponseEntity<UsuarioAdministrador> create(@RequestBody UsuarioAdministrador usuarioAdministrador) {
        UsuarioAdministrador createdUsuarioAdministrador = usuarioAdministradorService.save(usuarioAdministrador);
        return ResponseEntity.ok(createdUsuarioAdministrador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioAdministrador> getById(@PathVariable Long id) {
        return usuarioAdministradorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UsuarioAdministrador>> getAll() {
        List<UsuarioAdministrador> usuarioAdministradores = usuarioAdministradorService.findAll();
        return ResponseEntity.ok(usuarioAdministradores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioAdministrador> update(@PathVariable Long id, @RequestBody UsuarioAdministrador usuarioAdministrador) {
        return usuarioAdministradorService.findById(id)
                .map(existingUsuarioAdministrador -> {
                    usuarioAdministrador.setId(id);
                    UsuarioAdministrador updatedUsuarioAdministrador = usuarioAdministradorService.save(usuarioAdministrador);
                    return ResponseEntity.ok(updatedUsuarioAdministrador);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return usuarioAdministradorService.findById(id)
                .map(existingUsuarioAdministrador -> {
                    usuarioAdministradorService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
