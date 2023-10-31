package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.controllers.EjercicioProgresoxEjercicioController;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.Ejercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.EjercicioProgresoxEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.EjercicioProgresoxEjercicioId;
import com.smartcoach.smartcoachBackend.Business.user.entities.ProgresoxEjercicio;
import com.smartcoach.smartcoachBackend.Business.user.services.ProgresoxEjercicioService;
import com.smartcoach.smartcoachBackend.Persistence.exercise.EjercicioProgresoxEjercicioRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EjercicioProgresoxEjercicioService {

    @Autowired
    private EjercicioProgresoxEjercicioRepository repository;

    @Autowired
    private ProgresoxEjercicioService progresoxEjercicioService;

    public EjercicioProgresoxEjercicio findById(EjercicioProgresoxEjercicioId id) {
        return repository.findById(id).orElse(null);
    }

    public List<EjercicioProgresoxEjercicio> findAll() {
        return repository.findAll();
    }

    public EjercicioProgresoxEjercicio save(EjercicioProgresoxEjercicio ejercicioProgresoxEjercicio) {
        return repository.save(ejercicioProgresoxEjercicio);
    }

    public void deleteById(EjercicioProgresoxEjercicioId id) {
        repository.deleteById(id);
    }

    public void deleteByProgresoxEjercicioId(Integer progresoxEjercicioId) {
        repository.deleteByProgresoxEjercicioId(progresoxEjercicioId);
    }

    public ProgresoxEjercicio findProgresoxEjercicioByEjercicioId(Integer ejercicioId,Integer usuarioId) {

        List<EjercicioProgresoxEjercicio> epeList = repository.findByEjercicioId(ejercicioId);
        // Filtrar la lista por usuarioId y ordenarla por fecha de manera descendente
        List<ProgresoxEjercicio> filteredAndSortedPxeList = epeList.stream()
                .map(epe -> progresoxEjercicioService.findById(Long.valueOf(epe.getProgresoxEjercicioId())))
                .filter(pxe -> pxe.getUsuarioClienteId().equals(usuarioId))
                .sorted(Comparator.comparing(ProgresoxEjercicio::getFecha).reversed())
                .collect(Collectors.toList());

        if (!filteredAndSortedPxeList.isEmpty()) {
            return filteredAndSortedPxeList.get(0);
        }

        return  null;
    }


}
