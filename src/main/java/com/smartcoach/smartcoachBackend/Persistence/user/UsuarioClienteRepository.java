package com.smartcoach.smartcoachBackend.Persistence.user;


import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Long> {
}



