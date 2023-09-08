package com.smartcoach.smartcoachBackend.Persistence.admi;

import com.smartcoach.smartcoachBackend.Business.admi.entities.UsuarioAdministrador;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioAdministradorRepository extends JpaRepository<UsuarioAdministrador,Long> {
}
