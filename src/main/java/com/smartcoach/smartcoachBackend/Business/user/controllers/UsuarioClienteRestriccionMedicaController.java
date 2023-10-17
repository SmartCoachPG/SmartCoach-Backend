package com.smartcoach.smartcoachBackend.Business.user.controllers;

import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioClienteRestriccionMedica;
import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioClienteRestriccionMedicaId;
import com.smartcoach.smartcoachBackend.Business.user.services.UsuarioClienteRestriccionMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarioclienterestriccionmedica")
public class UsuarioClienteRestriccionMedicaController {

    @Autowired
    private UsuarioClienteRestriccionMedicaService service;

    @GetMapping
    public List<UsuarioClienteRestriccionMedica> findAll() {
        return service.findAll();
    }

    @GetMapping("/{usuarioClienteUsuarioid}/{restriccionMedicaid}")
    public UsuarioClienteRestriccionMedica findById(@PathVariable Integer usuarioClienteUsuarioid, @PathVariable Integer restriccionMedicaid) {
        UsuarioClienteRestriccionMedicaId id = new UsuarioClienteRestriccionMedicaId(usuarioClienteUsuarioid, restriccionMedicaid);
        return service.findById(id);
    }

    @PostMapping("/crear")
    public UsuarioClienteRestriccionMedica save(@RequestBody UsuarioClienteRestriccionMedica usuarioClienteRestriccionMedica) {
        System.out.println("Controllador");
        System.out.println(usuarioClienteRestriccionMedica.toString());
        return service.save(usuarioClienteRestriccionMedica);
    }

    @DeleteMapping("/{usuarioClienteUsuarioid}/{restriccionMedicaid}")
    public void deleteById(@PathVariable Integer usuarioClienteUsuarioid, @PathVariable Integer restriccionMedicaid) {
        UsuarioClienteRestriccionMedicaId id = new UsuarioClienteRestriccionMedicaId(usuarioClienteUsuarioid, restriccionMedicaid);
        service.deleteById(id);
    }
}
