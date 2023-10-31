package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.admi.entities.Equipo;
import com.smartcoach.smartcoachBackend.Business.admi.services.EquipoService;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.*;
import com.smartcoach.smartcoachBackend.Business.user.entities.CajaRutina;
import com.smartcoach.smartcoachBackend.Business.user.entities.ProgresoxEjercicio;
import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;
import com.smartcoach.smartcoachBackend.Business.user.services.UsuarioClienteRestriccionMedicaService;
import com.smartcoach.smartcoachBackend.Business.user.services.UsuarioClienteService;
import com.smartcoach.smartcoachBackend.Persistence.exercise.GrupoMuscularRepository;
import com.smartcoach.smartcoachBackend.Persistence.exercise.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLOutput;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.RecursiveTask;

@Service
public class RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private GrupoMuscularRepository grupoMuscularRepository;

    @Autowired
    private UsuarioClienteService usuarioClienteService;

    @Autowired
    private RutinaService rutinaService;

    @Autowired
    private EquipoService equipoService;

    @Autowired
    private EjercicioService ejercicioService;

    @Autowired
    private UsuarioClienteRestriccionMedicaService usuarioClienteRestriccionMedicaService;

    @Autowired
    private RestriccionMedicaEjercicioService restriccionMedicaEjercicioService;

    @Autowired
    private EjercicioProgresoxEjercicioService ejercicioProgresoxEjercicioService;

    @Autowired
    private EquipoEjercicioService equipoEjercicioService;

    @Autowired
    private ImagenEjercicioService imagenEjercicioService;

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

    public List<CajaRutina> getEjerciciosByRutina(int idUsuario, int idRut)
    {
        List<CajaRutina> opciones = new ArrayList<>();

        // 0. Get usuario
        System.out.println("Tengo usuario:"+idUsuario);
        Optional<UsuarioCliente> cliente = usuarioClienteService.findById(Long.valueOf(idUsuario));

        // 1.Asignar grupoMuscular a Rutina
        Rutina rutina = rutinaService.findById(idRut);

        // 2.Consultar equipo gym
        List<Equipo> equipoD = new ArrayList<>();
        if(cliente.get().getGimnasioid()!=null)
        {
            equipoD = equipoService.findEquiposByGimnasioId(cliente.get().getGimnasioid());
        }
        System.out.println("Equipo"+equipoD);

        // 3.Consultar equipo personal
        equipoD.addAll(equipoService.findEquiposByUsuarioId(cliente.get().getId().intValue()));
        equipoD.add(equipoService.getById((long)15));
        System.out.println("Equipo personal:"+equipoD);

        //4. Filtrar ejercicios por equipo total
        List<Ejercicio> listaEjercicios = new ArrayList<>();
        for(Equipo equipo: equipoD)
        {
            listaEjercicios.addAll(ejercicioService.findEjerciciosByEquipoItemId(equipo.getId().intValue()));
        }
        System.out.println("Ejercicios"+listaEjercicios);

        //5.Filtrar ejercicios por limitacion fisica
        List <Integer> restriccionesM = usuarioClienteRestriccionMedicaService.findRestriccionesByUsuarioClienteId(cliente.get().getId());
        List<Integer> idEjerciciosX = new ArrayList<>();
        for(Integer restriccion : restriccionesM)
        {
            idEjerciciosX.addAll(restriccionMedicaEjercicioService.findEjerciciosByRestriccionMedicaId((long)restriccion));
        }
        listaEjercicios.removeIf(ejercicio -> idEjerciciosX.contains(ejercicio.getId().intValue()));

        // 6.Filtrar ejercicios por grupo muscular
        for(Ejercicio eje:listaEjercicios)
        {
            if(ejercicioService.findGrupoMuscular(eje.getId().intValue()).contains(rutina.getGrupoMuscularId()))
            {
                CajaRutina cajarut = new CajaRutina();
                cajarut.setEjercicio(eje);
                opciones.add(cajarut);
            }
        }

        // 7. Obtener objetivo Rutina = repeticiones
        int objetivoR = cliente.get().getObjetivoRutinaid();
        Map<Integer,Integer> repeticiones = new HashMap<>();
        repeticiones.put(1,15);
        repeticiones.put(2,8);
        repeticiones.put(3,5);

        Map<Integer, Time>  descansos = new HashMap<>();
        descansos.put(1, Time.valueOf("00:01:00"));
        descansos.put(2, Time.valueOf("00:01:30"));
        descansos.put(3, Time.valueOf("00:03:00"));

        // 8. Obtener nivel actividad = peso
        int nivelA = cliente.get().getNivelActividadFisicaid();
        Map<Integer,Integer> pesos = new HashMap<>();
        // medidas en libras
        pesos.put(1,0);
        pesos.put(2,5);
        pesos.put(3,10);

        // 9.tener date
        Calendar calendar = Calendar.getInstance();
        // Establecer la hora, minutos, segundos y milisegundos a cero
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date fechaActual = calendar.getTime();


        // 10. Buscar o crear proresoxEjercicio
        for(CajaRutina cajaRut : opciones)
        {
            ProgresoxEjercicio progresoxEjercicio = ejercicioProgresoxEjercicioService.findProgresoxEjercicioByEjercicioId(cajaRut.getEjercicio().getId().intValue(),cliente.get().getId().intValue());
            if(progresoxEjercicio!=null)
                cajaRut.setProgresoxEjercicio(progresoxEjercicio);
            else{
                progresoxEjercicio = new ProgresoxEjercicio();
                List<Integer> equipoE = equipoEjercicioService.findEquipoItemidsByEjercicioid(cajaRut.getEjercicio().getId().intValue());
                if(!equipoE.contains(15))
                    progresoxEjercicio.setPeso(pesos.get(nivelA));
                else
                    progresoxEjercicio.setPeso(0);
                progresoxEjercicio.setFecha(fechaActual);
                progresoxEjercicio.setValoracion(0);
                progresoxEjercicio.setSerie(4);
                progresoxEjercicio.setRepeticiones(repeticiones.get(objetivoR));
                progresoxEjercicio.setDescansoEntreSeries(descansos.get(objetivoR));
                progresoxEjercicio.setUsuarioClienteId(cliente.get().getId().intValue());
                cajaRut.setProgresoxEjercicio(progresoxEjercicio);
            }
        }


        // 11. Buscar imagenes
        for(CajaRutina cajaRutina : opciones)
        {
            cajaRutina.setImagenEjercicio(imagenEjercicioService.findByEjercicioid(cajaRutina.getEjercicio().getId().intValue()).get(0));
        }

        return  opciones;
    }

}
