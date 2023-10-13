package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Ejercicio;
import com.smartcoach.smartcoachBackend.Persistence.exercise.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    public List<Ejercicio> findAll() {
        return ejercicioRepository.findAll();
    }

    public Ejercicio findById(Long id) {
        return ejercicioRepository.findById(id).orElse(null);
    }

    public Ejercicio save(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    public void deleteById(Long id) {
        ejercicioRepository.deleteById(id);
    }

    @PersistenceContext
    EntityManager em;

    public List<Ejercicio> findEjerciciosByEquipoItemId(int equipoItemId) {
        return ejercicioRepository.findEjerciciosByEquipoItemId(equipoItemId);
    }


}
