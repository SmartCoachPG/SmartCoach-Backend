package com.smartcoach.smartcoachBackend.Persistence.admi;

import com.smartcoach.smartcoachBackend.Business.admi.entities.TipoEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEquipoRepository extends JpaRepository<TipoEquipo, Long> {
}
