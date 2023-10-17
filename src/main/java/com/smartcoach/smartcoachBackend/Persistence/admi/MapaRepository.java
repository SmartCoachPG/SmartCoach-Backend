package com.smartcoach.smartcoachBackend.Persistence.admi;

import com.smartcoach.smartcoachBackend.Business.admi.entities.Mapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapaRepository extends JpaRepository<Mapa, Long> {
    List<Mapa> findByGimnasioId(Integer gimnasioId);
}
