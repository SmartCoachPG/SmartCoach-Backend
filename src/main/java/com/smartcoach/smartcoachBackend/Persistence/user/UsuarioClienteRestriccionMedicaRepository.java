package com.smartcoach.smartcoachBackend.Persistence.user;

import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioClienteRestriccionMedica;
import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioClienteRestriccionMedicaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioClienteRestriccionMedicaRepository extends JpaRepository<UsuarioClienteRestriccionMedica, UsuarioClienteRestriccionMedicaId> {
    void deleteByUsuarioClienteUsuarioid(Integer usuarioClienteUsuarioid);

}
