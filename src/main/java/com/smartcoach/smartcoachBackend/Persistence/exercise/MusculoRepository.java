package com.smartcoach.smartcoachBackend.Persistence.exercise;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Musculo;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.RestriccionMedicaEjercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusculoRepository extends JpaRepository<Musculo, Long> {

}
