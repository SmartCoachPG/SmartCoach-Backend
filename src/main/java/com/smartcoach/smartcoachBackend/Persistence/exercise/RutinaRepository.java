package com.smartcoach.smartcoachBackend.Persistence.exercise;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Rutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutinaRepository extends JpaRepository<Rutina, Integer> {
}
