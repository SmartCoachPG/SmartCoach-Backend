package com.smartcoach.smartcoachBackend.Business.user.services;

import com.smartcoach.smartcoachBackend.Business.user.entities.UnidadMetrica;
import com.smartcoach.smartcoachBackend.Persistence.user.UnidadMetricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UnidadMetricaService {

    @Autowired
    private UnidadMetricaRepository unidadMetricaRepository;

    public List<UnidadMetrica> findAll() {
        return unidadMetricaRepository.findAll();
    }

    public Optional<UnidadMetrica> findById(int id) {
        return unidadMetricaRepository.findById(id);
    }

    public UnidadMetrica save(UnidadMetrica unidadMetrica) {
        return unidadMetricaRepository.save(unidadMetrica);
    }

    public void deleteById(int id) {
        unidadMetricaRepository.deleteById(id);
    }
}
