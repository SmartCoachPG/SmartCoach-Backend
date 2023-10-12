package com.smartcoach.smartcoachBackend.Business.user.controllers;
import com.smartcoach.smartcoachBackend.Business.admi.services.EquipoService;
import com.smartcoach.smartcoachBackend.Business.exercise.services.RutinaService;
import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;
import com.smartcoach.smartcoachBackend.Business.user.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuariocliente")
public class UsuarioClienteController {

    @Autowired
    private UsuarioClienteService usuarioClienteService;
    @Autowired
    private RutinaService rutinaService;
    @Autowired
    private ProgresoxEjercicioService progresoxEjercicioService;
    @Autowired
    private ObjetivoService objetivoService;
    @Autowired
    private UsuarioClienteRestriccionMedicaService USRMService;
    @Autowired
    private PerfilMedicoService perfilMedicoService;
    @Autowired
    private EquipoService equipoService;


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
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rutinaService.deleteByUsuarioClienteId(id.intValue());
        progresoxEjercicioService.deleteByUsuarioClienteId(id.intValue());
        objetivoService.deleteByUsuarioClienteId(id.intValue());
        USRMService.deleteByUsuarioClienteUsuarioid(id.intValue());
        perfilMedicoService.deleteByUsuarioClienteId(id.intValue());
        equipoService.deleteByUsuarioClienteId(id.intValue());
        usuarioClienteService.deteleById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/crearRutina/{id}")
    public ResponseEntity<Void> crearRutina(@PathVariable Long id)
    {
        // 0. Get usuario
        Optional<UsuarioCliente> cliente = usuarioClienteService.findById(id);
        // 1.Asignar grupoMuscular a Rutina
        rutinaService.asignarGM(id.intValue(),cliente.get().getGrupoMuscularid());

        // 2.Opciones ejercicios

        // 3.Aplicar objetivo Rutina y Nivel actividad fisica


        return ResponseEntity.noContent().build();
    }

}
