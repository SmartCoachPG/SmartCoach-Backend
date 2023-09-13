package com.smartcoach.smartcoachBackend.Business.user.controllers;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartcoach.smartcoachBackend.Business.admi.entities.UsuarioAdministrador;
import com.smartcoach.smartcoachBackend.Business.user.entities.Usuario;
import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;
import com.smartcoach.smartcoachBackend.Business.user.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.findById(id).orElse(null);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        // Aquí puedes agregar lógica para actualizar el usuario.
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }

    @PostMapping("/iniciarsesion")
    public ResponseEntity<Usuario> iniciarSesion(@RequestBody Map<String, String> credenciales) {
        String email = credenciales.get("email");
        String contrasenna = credenciales.get("contrasenna");

        Optional<Usuario> usuarioOpt = usuarioService.validarSesion(email, contrasenna);
        if (usuarioOpt.isPresent()) {
            Usuario usuarioSubclase = usuarioOpt.get();
            Usuario usuario = new Usuario();
            usuario.setId(usuarioSubclase.getId());
            usuario.setNombre(usuarioSubclase.getNombre());
            usuario.setFotoPerfil(usuarioSubclase.getFotoPerfil());
            usuario.setAdmi(usuarioSubclase.getAdmi());
            usuario.setToken(usuarioSubclase.getToken());

            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/hashContraseñas")
    public String migratePasswords() {
        try {
            usuarioService.hashAllExistingPasswords();
            return "Migración de contraseñas completada exitosamente.";
        } catch (Exception e) {
            return "Ocurrió un error durante la migración de contraseñas: " + e.getMessage();
        }
    }

}
