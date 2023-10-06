package com.smartcoach.smartcoachBackend.Persistence.user;

import com.smartcoach.smartcoachBackend.Business.user.entities.RestriccionMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestriccionMedicaRepository extends JpaRepository<RestriccionMedica, Integer> {

    List<RestriccionMedica> findByNombreLimitacionContainingIgnoreCase(String nombre);
}
