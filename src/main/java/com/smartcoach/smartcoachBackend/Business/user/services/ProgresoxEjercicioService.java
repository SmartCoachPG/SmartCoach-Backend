package com.smartcoach.smartcoachBackend.Business.user.services;

import com.smartcoach.smartcoachBackend.Business.exercise.services.EjercicioService;
import com.smartcoach.smartcoachBackend.Business.user.entities.ProgresoxEjercicio;
import com.smartcoach.smartcoachBackend.Persistence.user.ProgresoxEjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProgresoxEjercicioService {

    @Autowired
    private ProgresoxEjercicioRepository progresoxEjercicioRepository;

    @Autowired
    private EjercicioService ejercicioService;

    public List<ProgresoxEjercicio> findAll() {
        return progresoxEjercicioRepository.findAll();
    }

    public ProgresoxEjercicio findById(Long id) {
        return progresoxEjercicioRepository.findById(id).orElse(null);
    }

    public ProgresoxEjercicio save(ProgresoxEjercicio progresoxEjercicio) {
        return progresoxEjercicioRepository.save(progresoxEjercicio);
    }

    public void deleteByUsuarioClienteId(Integer usuarioClienteId)
    {
        progresoxEjercicioRepository.deleteByUsuarioClienteId(usuarioClienteId);
    }
    public void deleteById(Long id) {
        progresoxEjercicioRepository.deleteById(id);
    }

    public List<ProgresoxEjercicio> findByUsuarioClienteId(Integer usuarioClienteId) {
        return progresoxEjercicioRepository.findByUsuarioClienteId(usuarioClienteId);
    }
}
