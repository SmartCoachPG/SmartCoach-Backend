package com.smartcoach.smartcoachBackend.Persistence.exercise;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.EjercicioProgresoxEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.EjercicioProgresoxEjercicioId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EjercicioProgresoxEjercicioRepository extends JpaRepository<EjercicioProgresoxEjercicio, EjercicioProgresoxEjercicioId> {

    void deleteByProgresoxEjercicioId(Integer progresoxEjercicioId);
    List<EjercicioProgresoxEjercicio> findByEjercicioId(Integer ejercicioId);
}
