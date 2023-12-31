package com.smartcoach.smartcoachBackend.Persistence.exercise;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.MusculoEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.MusculoEjercicioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusculoEjercicioRepository extends JpaRepository<MusculoEjercicio, MusculoEjercicioId> {

    List<MusculoEjercicio> findByEjercicioId(Integer ejercicioId);
}
