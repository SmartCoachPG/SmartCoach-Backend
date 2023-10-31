package com.smartcoach.smartcoachBackend.Business.admi.services;

import com.smartcoach.smartcoachBackend.Business.admi.entities.Mapa;
import com.smartcoach.smartcoachBackend.Persistence.admi.MapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MapaService {

    @Autowired
    private MapaRepository mapaRepository;

    public List<Mapa> findAll() {
        return mapaRepository.findAll();
    }

    public Mapa findById(Long id) {
        return mapaRepository.findById(id).orElse(null);
    }

    public Mapa save(Mapa mapa) {
        return mapaRepository.save(mapa);
    }

    public void deleteById(Long id) {
        mapaRepository.deleteById(id);
    }

    public List<Mapa> findMapasByGimnasioId(Integer gimnasioId) {
        return mapaRepository.findByGimnasioId(gimnasioId);
    }
}
