package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.GrupoMuscular;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.Rutina;
import com.smartcoach.smartcoachBackend.Persistence.exercise.GrupoMuscularRepository;
import com.smartcoach.smartcoachBackend.Persistence.exercise.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        List<Rutina> rutinas = rutinaRepository.findByUsuarioClienteId(id);
        rutinas = ordernar(rutinas);
        List<GrupoMuscular> grupoMusculares = grupoMuscularRepository.findAll();
        Optional<GrupoMuscular> grupoMuscularO = grupoMuscularRepository.findById((long) idGrupoM);
        System.out.println("Buscado ID: " + idGrupoM + ", Retornado ID: " + grupoMuscularO.get().getId());


        for (GrupoMuscular grupoMuscular : grupoMusculares) {
            contadorGM.put(grupoMuscular.getId().intValue(), (long) 0);
        }

        int band = 0;
        int UgrupoMuscular = grupoMuscularO.get().getUbicacion();

        for (Rutina rutina : rutinas) {
            if (band == UgrupoMuscular) {
                int test = contadorGM.get(grupoMuscularO.get().getId().intValue()).intValue();
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
        }
        System.out.println(rutinas);
        rutinaRepository.saveAll(rutinas);
        return rutinas;

    }

    public int diaANumero(String dia) {
        switch (dia.toLowerCase()) {
            case "lunes":
                return 1;
            case "martes":
                return 2;
            case "miércoles":
                return 3;
            case "jueves":
                return 4;
            case "viernes":
                return 5;
            case "sábado":
                return 6;
            case "domingo":
                return 7;
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
            temp.set(posi-1,rutina);
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
