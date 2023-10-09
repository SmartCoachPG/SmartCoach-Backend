package com.smartcoach.smartcoachBackend.Persistence.user;

import com.smartcoach.smartcoachBackend.Business.user.entities.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Long> {

    void deleteByUsuarioClienteId(int usuarioClienteId);

}
