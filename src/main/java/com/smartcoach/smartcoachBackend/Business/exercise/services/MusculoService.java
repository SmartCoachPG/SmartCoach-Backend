package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Musculo;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.MusculoEjercicio;
import com.smartcoach.smartcoachBackend.Persistence.exercise.MusculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MusculoService {

    @Autowired
    private MusculoRepository musculoRepository;

    @Autowired
    private MusculoEjercicioService musculoEjercicioService;

    public List<Musculo> findAll() {
        return musculoRepository.findAll();
    }

    public Musculo findById(Long id) {
        return musculoRepository.findById(id).orElse(null);
    }

    public Musculo save(Musculo musculo) {
        return musculoRepository.save(musculo);
    }

    public void deleteById(Long id) {
        musculoRepository.deleteById(id);
    }
    
    public  List<String> findMusculosByEjercicioId(Long ejercicioId){
        List<String> musculosNombre = new ArrayList<>();
        List<MusculoEjercicio> musculos = musculoEjercicioService.findByEjercicioId(ejercicioId);
        for(MusculoEjercicio musculo :musculos)
        {
            musculosNombre.add(musculoRepository.findById(Long.valueOf((musculo.getMusculoId()))).get().getNombreMusculo());
        }
        return musculosNombre;
    }
}

