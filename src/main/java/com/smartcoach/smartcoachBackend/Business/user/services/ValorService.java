package com.smartcoach.smartcoachBackend.Business.user.services;

import com.smartcoach.smartcoachBackend.Business.user.entities.Valor;
import com.smartcoach.smartcoachBackend.Persistence.user.ValorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValorService {

    @Autowired
    private ValorRepository valorRepository;

    public List<Valor> findAll() {
        return valorRepository.findAll();
    }

    public Optional<Valor> findById(int id) {
        return valorRepository.findById(id);
    }

    public Valor save(Valor valor) {
        return valorRepository.save(valor);
    }

    public void deleteById(int id) {
        valorRepository.deleteById(id);
    }
}
