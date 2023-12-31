package com.smartcoach.smartcoachBackend.Persistence.exercise;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.RutinaEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.RutinaEjercicioId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutinaEjercicioRepository extends JpaRepository<RutinaEjercicio, RutinaEjercicioId> {

    void deleteByRutinaId(Integer rutinaId);
    List<RutinaEjercicio> findByRutinaId(Integer rutinaId);
}
