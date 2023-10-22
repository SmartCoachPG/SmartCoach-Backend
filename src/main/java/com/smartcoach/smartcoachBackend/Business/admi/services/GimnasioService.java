package com.smartcoach.smartcoachBackend.Business.admi.services;

import com.smartcoach.smartcoachBackend.Business.admi.entities.*;
import com.smartcoach.smartcoachBackend.Business.user.entities.Usuario;
import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;
import com.smartcoach.smartcoachBackend.Business.user.services.UsuarioClienteService;
import com.smartcoach.smartcoachBackend.Persistence.admi.GimnasioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GimnasioService {

    @Autowired
    private GimnasioRepository gimnasioRepository;
    @Autowired
    private UbicacionxItemService ubicacionxItemService;
    @Autowired
    private UsuarioAdministradorService usuarioAdministradorService;
    @Autowired
    private GimnasioItemService gimnasioItemService;
    @Autowired
    private MapaService mapaService;
    @Autowired
    private UsuarioClienteService usuarioClienteService;

    public List<Gimnasio> findAll() {
        return gimnasioRepository.findAll();
    }

    public Gimnasio findById(Long id) {
        return gimnasioRepository.findById(id).orElse(null);
    }

    public Gimnasio save(Gimnasio gimnasio) {
        return gimnasioRepository.save(gimnasio);
    }

    public void deleteById(Long id) {
        // 1.null id a usuario admi
        List<UsuarioAdministrador> listaAdmi = usuarioAdministradorService.findAll();
        for(UsuarioAdministrador admi : listaAdmi)
        {
            if(admi.getGimnasioId()!=null)
            {
                if(admi.getGimnasioId()==id.intValue())
                {
                    admi.setGimnasioId(null);
                    usuarioAdministradorService.update(admi);
                }
            }

        }

        // 2.eliminar ubicacionxitem
        List<UbicacionxItem> listaUI = ubicacionxItemService.getUbicacionxItemByGimnasioId(id.intValue());
        for(UbicacionxItem uxi : listaUI)
        {
            ubicacionxItemService.deleteById(uxi.getId().intValue());
        }

        // 3.eliminar gimnasioItem
        List<GimnasioItem> listaGI = gimnasioItemService.findGimnasioItemByGimnasioid(id.intValue());
        for(GimnasioItem gi : listaGI)
        {
            gimnasioItemService.deleteGimnasioItem(gi.getGimnasioid(),gi.getItemid());
        }

        // 4.eliminar mapa
        List<Mapa> listaMapas = mapaService.findMapasByGimnasioId(id.intValue());
        for(Mapa mapa: listaMapas)
        {
            mapaService.deleteById(mapa.getId());
        }

        // 5.definir nuevo id gim para clientes
        List<UsuarioCliente> listaClientes = usuarioClienteService.getUsuarioClientesByGimnasioid(id.intValue());
        for(UsuarioCliente cliente : listaClientes)
        {
            cliente.setGimnasioid(null);
            usuarioClienteService.update(cliente);
        }

        // 6.Borrar gym
        gimnasioRepository.deleteById(id);

    }
}
