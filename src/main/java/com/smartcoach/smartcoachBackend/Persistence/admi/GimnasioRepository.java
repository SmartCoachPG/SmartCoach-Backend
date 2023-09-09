package com.smartcoach.smartcoachBackend.Persistence.admi;

import com.smartcoach.smartcoachBackend.Business.admi.entities.Gimnasio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Long> {
}
