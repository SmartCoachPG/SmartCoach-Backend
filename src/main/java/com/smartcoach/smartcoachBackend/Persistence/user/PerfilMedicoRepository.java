package com.smartcoach.smartcoachBackend.Persistence.user;

import com.smartcoach.smartcoachBackend.Business.user.entities.PerfilMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilMedicoRepository extends JpaRepository<PerfilMedico, Integer> {
    List<PerfilMedico> findByUsuarioClienteId(Integer usuarioClienteUsuarioid);
    void deleteByUsuarioClienteId(Integer usuarioClienteId);
}
