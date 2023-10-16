package com.smartcoach.smartcoachBackend.Persistence.user;

import com.smartcoach.smartcoachBackend.Business.user.entities.ProgresoxEjercicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgresoxEjercicioRepository extends JpaRepository<ProgresoxEjercicio, Long> {

    void deleteByUsuarioClienteId(Integer usuarioClienteId);
    List<ProgresoxEjercicio> findByUsuarioClienteId(Integer usuarioClienteId);
}
