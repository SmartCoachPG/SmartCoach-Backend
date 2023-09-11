package com.smartcoach.smartcoachBackend.Persistence.user;

import com.smartcoach.smartcoachBackend.Business.user.entities.ValorEvaluacionFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValorEvaluacionFisicaRepository extends JpaRepository<ValorEvaluacionFisica, Integer> {
}
