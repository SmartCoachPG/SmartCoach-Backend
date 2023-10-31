package com.smartcoach.smartcoachBackend.Business.user.services;

import com.smartcoach.smartcoachBackend.Business.user.entities.RestriccionMedica;
import com.smartcoach.smartcoachBackend.Persistence.user.RestriccionMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestriccionMedicaService {

    @Autowired
    private RestriccionMedicaRepository restriccionMedicaRepository;

    public List<RestriccionMedica> findByNombreLimitacion(String query) {
        return restriccionMedicaRepository.findByNombreLimitacionContainingIgnoreCase(query);
    }

    public List<RestriccionMedica> findAll() {
        return restriccionMedicaRepository.findAll();
    }

    public Optional<RestriccionMedica> findById(int id) {
        return restriccionMedicaRepository.findById(id);
    }

    public RestriccionMedica save(RestriccionMedica restriccionMedica) {
        return restriccionMedicaRepository.save(restriccionMedica);
    }

    public void deleteById(int id) {
        restriccionMedicaRepository.deleteById(id);
    }
}
