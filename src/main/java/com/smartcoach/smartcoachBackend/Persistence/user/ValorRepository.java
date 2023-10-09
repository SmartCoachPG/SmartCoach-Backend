package com.smartcoach.smartcoachBackend.Persistence.user;

import com.smartcoach.smartcoachBackend.Business.user.entities.Valor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValorRepository extends JpaRepository<Valor, Integer> {
    void deleteByPerfilMedicoid(int perfilMedicoid);
}
