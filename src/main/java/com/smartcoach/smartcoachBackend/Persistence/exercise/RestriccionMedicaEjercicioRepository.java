package com.smartcoach.smartcoachBackend.Persistence.exercise;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.RestriccionMedicaEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.RestriccionMedicaEjercicioId;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface RestriccionMedicaEjercicioRepository extends JpaRepository<RestriccionMedicaEjercicio, RestriccionMedicaEjercicioId> {

    List<RestriccionMedicaEjercicio> findByRestriccionMedicaId(Integer restriccionMedicaId);

}

