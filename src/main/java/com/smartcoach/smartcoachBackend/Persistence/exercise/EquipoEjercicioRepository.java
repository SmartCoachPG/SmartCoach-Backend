package com.smartcoach.smartcoachBackend.Persistence.exercise;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.EquipoEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.EquipoEjercicioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoEjercicioRepository extends JpaRepository<EquipoEjercicio, EquipoEjercicioId> {
}
