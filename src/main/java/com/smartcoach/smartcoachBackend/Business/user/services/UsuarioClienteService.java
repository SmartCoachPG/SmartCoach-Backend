package com.smartcoach.smartcoachBackend.Business.user.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.Ejercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.Rutina;
import com.smartcoach.smartcoachBackend.Business.exercise.services.EjercicioService;
import com.smartcoach.smartcoachBackend.Business.exercise.services.RutinaEjercicioService;
import com.smartcoach.smartcoachBackend.Business.exercise.services.RutinaService;
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
    private RutinaService rutinaService;

    @Autowired
    private RutinaEjercicioService rutinaEjercicioService;

    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    @Autowired
    private EjercicioService ejercicioService;

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

    public Boolean validarRutina(Long idUsuario)
    {
        // Tiene rutinas?
        List<Rutina> listaRutinas = rutinaService.getByUsuarioClienteId(idUsuario.intValue());
        List<Ejercicio> listaEje = new ArrayList<>();
        for(Rutina rut:listaRutinas)
        {
            listaEje.addAll(rutinaEjercicioService.getEjerciciosByRutinaId(rut.getId()));
        }

        if(listaEje.isEmpty())
        {
            return false;
        }
        // La rutina que tiene es para su musculo objetivo?
        int grupoMuscularO = usuarioClienteRepository.getById(idUsuario).getGrupoMuscularid();
        boolean tieneGM = false;
        for(Ejercicio ej: listaEje)
        {
            List<Integer> grupos = ejercicioService.findGrupoMuscular(ej.getId().intValue());

            for(Integer idGm : grupos)
            {
                if(idGm==grupoMuscularO)
                {
                    return true;
                }
            }
        }
        return tieneGM;
    }

}
