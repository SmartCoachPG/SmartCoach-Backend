package com.smartcoach.smartcoachBackend.Persistence.exercise;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.ImagenEjercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenEjercicioRepository extends JpaRepository<ImagenEjercicio, Long> {
}
