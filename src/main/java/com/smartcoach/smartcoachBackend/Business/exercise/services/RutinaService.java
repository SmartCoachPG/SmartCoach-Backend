package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.GrupoMuscular;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.Rutina;
import com.smartcoach.smartcoachBackend.Persistence.exercise.GrupoMuscularRepository;
import com.smartcoach.smartcoachBackend.Persistence.exercise.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.RecursiveTask;

@Service
public class RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private GrupoMuscularRepository grupoMuscularRepository;

    Map<Integer, Long> contadorGM = new HashMap<>();

    public List<Rutina> findAll() {
        return rutinaRepository.findAll();
    }

    public Rutina findById(int id) {
        return rutinaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteByUsuarioClienteId(int usuarioClienteId)
    {
        rutinaRepository.deleteByUsuarioClienteId(usuarioClienteId);
    }

    public Rutina save(Rutina rutina) {
        return rutinaRepository.save(rutina);
    }

    public void deleteById(int id) {
        rutinaRepository.deleteById(id);
    }

    public List<Rutina> getByUsuarioClienteId(Integer usuarioClienteId) {
        return rutinaRepository.findByUsuarioClienteId(usuarioClienteId);
    }

    public List<Rutina> asignarGM (int id,int idGrupoM) {
        System.out.println("DENTRO DE ASIGNA GM : RUTINA SERVICE");
        List<Rutina> rutinas = rutinaRepository.findByUsuarioClienteId(id);
        System.out.println(rutinas.toString());

        rutinas = ordernar(rutinas);
        List<GrupoMuscular> grupoMusculares = grupoMuscularRepository.findAll();
        Optional<GrupoMuscular> grupoMuscularO = grupoMuscularRepository.findById((long) idGrupoM);

        for (GrupoMuscular grupoMuscular : grupoMusculares) {
            contadorGM.put(grupoMuscular.getId().intValue(), (long) 0);
        }

        int band = 0;
        int UgrupoMuscular = grupoMuscularO.get().getUbicacion();

        System.out.println("VAMOS A VER SI ENTRO");
        for (Rutina rutina : rutinas) {
            System.out.println("ENTRO");
            if (band == UgrupoMuscular) {
                if (contadorGM.get(grupoMuscularO.get().getId().intValue()).intValue() < 3) {
                    rutina.setGrupoMuscularId(grupoMuscularO.get().getId().intValue());
                    Long cont = contadorGM.get(grupoMuscularO.get().getId().intValue());
                    contadorGM.put(grupoMuscularO.get().getId().intValue(), ++cont);
                    if (band == 0) band++;
                    else band--;
                } else {
                    rutina.setGrupoMuscularId(buscarMin(band, grupoMusculares).getId().intValue());
                    if (band == 0) band++;
                    else band--;
                }
            } else {
                rutina.setGrupoMuscularId(buscarMin(band, grupoMusculares).getId().intValue());
                if (band == 0) band++;
                else band--;
            }
            rutinaRepository.save(rutina);
        }

        return rutinas;

    }

    public int diaANumero(String dia) {
        switch (dia.toLowerCase()) {
            case "lunes":
                return 0;
            case "martes":
                return 1;
            case "miércoles":
                return 2;
            case "jueves":
                return 3;
            case "viernes":
                return 4;
            case "sábado":
                return 5;
            case "domingo":
                return 6;
            default:
                return -1; // Valor para días no válidos
        }
    }

    public GrupoMuscular buscarMin(int ubicacion, List<GrupoMuscular> listaGM)
    {
        GrupoMuscular retorno = null;
        Long minCount = Long.MAX_VALUE;
        int idMin=0;
        for (GrupoMuscular gm : listaGM) {
            if (gm.getUbicacion() == ubicacion) {
                Long count = contadorGM.get(gm.getId().intValue());
                if (count != null && count < minCount) {
                    minCount = count;
                    retorno = gm;
                    idMin = gm.getId().intValue();
                }
            }
        }
        contadorGM.put(idMin,++minCount);
        return retorno;
    }

    public List<Rutina> ordernar(List<Rutina> listaR)
    {
        List<Rutina> retorno = new ArrayList<>();
        List<Rutina> temp = new ArrayList<>(Collections.nCopies(7, null));

        int posi=0;
        for(Rutina rutina : listaR)
        {
            posi = diaANumero(rutina.getDia());
            temp.set(posi,rutina);
        }

        for(Rutina rutina2 : temp)
        {
            if(rutina2!=null)
            {
                retorno.add(rutina2);
            }
        }
        return retorno;
    }



}
