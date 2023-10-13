package com.smartcoach.smartcoachBackend.Persistence.exercise;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.GrupoMuscular;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.MusculoEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.MusculoGrupoMuscular;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.MusculoGrupoMuscularId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusculoGrupoMuscularRepository  extends JpaRepository<MusculoGrupoMuscular, MusculoGrupoMuscularId> {

    List<MusculoGrupoMuscular> findByMusculoId(Integer musculoId);
}
