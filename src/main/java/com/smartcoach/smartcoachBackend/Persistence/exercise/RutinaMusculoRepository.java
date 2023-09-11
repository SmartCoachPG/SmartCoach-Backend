package com.smartcoach.smartcoachBackend.Persistence.exercise;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.RutinaMusculo;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.RutinaMusculoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RutinaMusculoRepository extends JpaRepository<RutinaMusculo, RutinaMusculoId> {
}
