package com.smartcoach.smartcoachBackend.Business.user.services;

import com.smartcoach.smartcoachBackend.Business.user.entities.ValorEvaluacionFisica;
import com.smartcoach.smartcoachBackend.Persistence.user.ValorEvaluacionFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ValorEvaluacionFisicaService {

    @Autowired
    private ValorEvaluacionFisicaRepository valorEvaluacionFisicaRepository;

    public List<ValorEvaluacionFisica> findAll() {
        return valorEvaluacionFisicaRepository.findAll();
    }

    public Optional<ValorEvaluacionFisica> findById(int id) {
        return valorEvaluacionFisicaRepository.findById(id);
    }

    public ValorEvaluacionFisica save(ValorEvaluacionFisica valorEvaluacionFisica) {
        return valorEvaluacionFisicaRepository.save(valorEvaluacionFisica);
    }

    public void deleteById(int id) {
        valorEvaluacionFisicaRepository.deleteById(id);
    }
}
