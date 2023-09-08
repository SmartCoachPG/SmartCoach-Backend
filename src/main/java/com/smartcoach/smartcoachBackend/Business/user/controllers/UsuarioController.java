package com.smartcoach.smartcoachBackend.Business.user.controllers;
import com.smartcoach.smartcoachBackend.Business.user.entities.Usuario;
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
    public ResponseEntity<Map<String, Object>> iniciarSesion(@RequestBody Map<String, String> credenciales) {
        String email = credenciales.get("email");
        String contrasenna = credenciales.get("contrasenna");

        Optional<Usuario> usuarioOpt = usuarioService.validarSesion(email, contrasenna);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("usuario", usuario);
            if (usuario.getAdmi() == 1) {
                responseBody.put("tipo usuario", "admi");
            } else {
                responseBody.put("tipo usuario", "usuario");
            }
            return ResponseEntity.ok(responseBody);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


}
