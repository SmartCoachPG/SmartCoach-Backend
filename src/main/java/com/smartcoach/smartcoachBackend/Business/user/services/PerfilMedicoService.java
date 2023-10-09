package com.smartcoach.smartcoachBackend.Business.user.services;

import com.smartcoach.smartcoachBackend.Business.user.entities.PerfilMedico;
import com.smartcoach.smartcoachBackend.Persistence.user.PerfilMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilMedicoService {

    @Autowired
    private PerfilMedicoRepository perfilMedicoRepository;

    @Autowired
    private ValorService valorService;

    public List<PerfilMedico> findAll() {
        return perfilMedicoRepository.findAll();
    }

    public Optional<PerfilMedico> findById(int id) {
        return perfilMedicoRepository.findById(id);
    }

    public PerfilMedico save(PerfilMedico perfilMedico) {
        return perfilMedicoRepository.save(perfilMedico);
    }

    public void deleteById(int id) {
        valorService.deleteByPerfilMedicoid(id);
        perfilMedicoRepository.deleteById(id);
    }

    public void deleteByUsuarioClienteId(Integer usuarioClienteId)
    {
        List<PerfilMedico> perfilesMedicos = perfilMedicoRepository.findByUsuarioClienteId(usuarioClienteId);
        for (PerfilMedico perfilMedico : perfilesMedicos) {
            valorService.deleteByPerfilMedicoid(perfilMedico.getId());
        }
        perfilMedicoRepository.deleteByUsuarioClienteId(usuarioClienteId);
    }
}
