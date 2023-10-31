package com.smartcoach.smartcoachBackend.Persistence.exercise;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {

    @Query(value = "SELECT * FROM Ejercicio e WHERE e.id IN (SELECT ee.ejercicioid FROM Equipo_Ejercicio ee WHERE ee.equipoitemid = ?1)", nativeQuery = true)
    List<Ejercicio> findEjerciciosByEquipoItemId(int equipoitemid);
}
