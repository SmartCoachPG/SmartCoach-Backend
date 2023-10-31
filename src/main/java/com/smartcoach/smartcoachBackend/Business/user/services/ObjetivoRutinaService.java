package com.smartcoach.smartcoachBackend.Business.user.services;

import com.smartcoach.smartcoachBackend.Business.user.entities.ObjetivoRutina;
import com.smartcoach.smartcoachBackend.Persistence.user.ObjetivoRutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ObjetivoRutinaService {

    @Autowired
    private ObjetivoRutinaRepository repository;

    public ObjetivoRutina create(ObjetivoRutina objetivoRutina) {
        return repository.save(objetivoRutina);
    }

    public ObjetivoRutina findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<ObjetivoRutina> findAll() {
        return repository.findAll();
    }

    public ObjetivoRutina update(ObjetivoRutina objetivoRutina) {
        return repository.save(objetivoRutina);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
