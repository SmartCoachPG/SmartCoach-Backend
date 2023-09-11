package com.smartcoach.smartcoachBackend.Persistence.exercise;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.EjercicioProgresoxEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.EjercicioProgresoxEjercicioId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioProgresoxEjercicioRepository extends JpaRepository<EjercicioProgresoxEjercicio, EjercicioProgresoxEjercicioId> {
}
