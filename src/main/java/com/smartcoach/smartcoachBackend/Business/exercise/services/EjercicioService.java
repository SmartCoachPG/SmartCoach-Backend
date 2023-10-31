package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Ejercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.MusculoEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.MusculoGrupoMuscular;
import com.smartcoach.smartcoachBackend.Persistence.exercise.EjercicioRepository;
import com.smartcoach.smartcoachBackend.Persistence.exercise.MusculoEjercicioRepository;
import com.smartcoach.smartcoachBackend.Persistence.exercise.MusculoGrupoMuscularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Autowired
    private MusculoEjercicioRepository musculoEjercicioRepository;

    @Autowired
    private MusculoGrupoMuscularRepository musculoGrupoMuscularRepository;

    @PersistenceContext
    EntityManager em;

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

    public List<Ejercicio> findEjerciciosByEquipoItemId(int equipoItemId) {
        return ejercicioRepository.findEjerciciosByEquipoItemId(equipoItemId);
    }

    public List<Integer> findGrupoMuscular(int ejercicioId)
    {
        List<MusculoEjercicio> listaM = musculoEjercicioRepository.findByEjercicioId(ejercicioId);
        List<MusculoGrupoMuscular> listaMGM = new ArrayList<>();
        for(MusculoEjercicio me : listaM)
        {
            listaMGM.addAll(musculoGrupoMuscularRepository.findByMusculoId(me.getMusculoId()));
        }
        List<Integer> listaGM = new ArrayList<>();

        for(MusculoGrupoMuscular mgm : listaMGM)
        {
            listaGM.add(mgm.getGrupoMuscularId());
        }

        return listaGM;
    }

}
