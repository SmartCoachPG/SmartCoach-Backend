package com.smartcoach.smartcoachBackend.Business.user.controllers;
import com.smartcoach.smartcoachBackend.Business.admi.entities.Equipo;
import com.smartcoach.smartcoachBackend.Business.admi.entities.Item;
import com.smartcoach.smartcoachBackend.Business.admi.services.EquipoService;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.*;
import com.smartcoach.smartcoachBackend.Business.exercise.services.*;
import com.smartcoach.smartcoachBackend.Business.user.entities.ProgresoxEjercicio;
import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;
import com.smartcoach.smartcoachBackend.Business.user.services.*;
import com.smartcoach.smartcoachBackend.Persistence.exercise.MusculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.sql.Time;
import java.util.*;

@RestController
@RequestMapping("/api/usuariocliente")
public class UsuarioClienteController {

    @Autowired
    private UsuarioClienteService usuarioClienteService;
    @Autowired
    private RutinaService rutinaService;
    @Autowired
    private ProgresoxEjercicioService progresoxEjercicioService;
    @Autowired
    private ObjetivoService objetivoService;
    @Autowired
    private UsuarioClienteRestriccionMedicaService USRMService;
    @Autowired
    private PerfilMedicoService perfilMedicoService;
    @Autowired
    private EquipoService equipoService;
    @Autowired
    private EjercicioService ejercicioService;
    @Autowired
    private UsuarioClienteRestriccionMedicaService usuarioClienteRestriccionMedicaService;
    @Autowired
    private RestriccionMedicaEjercicioService restriccionMedicaEjercicioService;
    @Autowired
    private MusculoRepository musculoRepository;
    @Autowired
    private RutinaEjercicioService rutinaEjercicioService;
    @Autowired
    private EquipoEjercicioService equipoEjercicioService;
    @Autowired
    private EjercicioProgresoxEjercicioService ejercicioProgresoxEjercicioService;


    @PostMapping("/crear")
    public ResponseEntity<UsuarioCliente> create(@RequestBody UsuarioCliente usuarioCliente) {
        UsuarioCliente nuevoUsuarioCliente = usuarioClienteService.create(usuarioCliente);
        return ResponseEntity.ok(nuevoUsuarioCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioCliente> findById(@PathVariable Long id) {
        return usuarioClienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UsuarioCliente>> getAll() {
        List<UsuarioCliente> usuariosClientes = usuarioClienteService.findAll();
        return ResponseEntity.ok(usuariosClientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioCliente> update(@PathVariable Long id,@RequestBody UsuarioCliente usuarioCliente) {
        return usuarioClienteService.findById(id)
                .map(existingUsuarioCliente -> {
                    usuarioCliente.setId(id);
                    UsuarioCliente updatedCliente = usuarioClienteService.update(usuarioCliente);
                    return ResponseEntity.ok(updatedCliente);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        List<Rutina> rutinasUsur = rutinaService.getByUsuarioClienteId(id.intValue());
        for(Rutina rutina : rutinasUsur)
        {
            rutinaEjercicioService.deleteByRutinaId(rutina.getId());
        }
        rutinaService.deleteByUsuarioClienteId(id.intValue());
        List<ProgresoxEjercicio> progresoxEjercicios = progresoxEjercicioService.findByUsuarioClienteId(id.intValue());
        for(ProgresoxEjercicio progreso : progresoxEjercicios)
        {
            ejercicioProgresoxEjercicioService.deleteByProgresoxEjercicioId(progreso.getId().intValue());
        }
        progresoxEjercicioService.deleteByUsuarioClienteId(id.intValue());
        objetivoService.deleteByUsuarioClienteId(id.intValue());
        USRMService.deleteByUsuarioClienteUsuarioid(id.intValue());
        perfilMedicoService.deleteByUsuarioClienteId(id.intValue());
        equipoService.deleteByUsuarioClienteId(id.intValue());
        usuarioClienteService.deteleById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/crearRutina/{id}")
    public ResponseEntity<Void> crearRutina(@PathVariable Long id)
    {
        // 0. Get usuario
        Optional<UsuarioCliente> cliente = usuarioClienteService.findById(id);
        // 1.Asignar grupoMuscular a Rutina
        List<Rutina> listaRutinas = rutinaService.asignarGM(id.intValue(),cliente.get().getGrupoMuscularid());
        // 2.Consultar equipo gym
        List<Equipo> equipoD = new ArrayList<>();
        if(cliente.get().getGimnasioid()!=null)
        {
            equipoD = equipoService.findEquiposByGimnasioId(cliente.get().getGimnasioid());
        }
        // 3.Consultar equipo personal
        equipoD.addAll(equipoService.findEquiposByUsuarioId(cliente.get().getId().intValue()));
        equipoD.add(equipoService.getById((long)15));
        //4. Filtrar ejercicios por equipo total
        List<Ejercicio> listaEjercicios = new ArrayList<>();
        for(Equipo equipo: equipoD)
        {
            listaEjercicios.addAll(ejercicioService.findEjerciciosByEquipoItemId(equipo.getId().intValue()));
        }
        //5.Filtrar ejercicios por limitacion fisica
        List <Integer> restriccionesM = usuarioClienteRestriccionMedicaService.findRestriccionesByUsuarioClienteId(cliente.get().getId());
        List<Integer> idEjerciciosX = new ArrayList<>();
        for(Integer restriccion : restriccionesM)
        {
            idEjerciciosX.addAll(restriccionMedicaEjercicioService.findEjerciciosByRestriccionMedicaId((long)restriccion));
        }
        listaEjercicios.removeIf(ejercicio -> idEjerciciosX.contains(ejercicio.getId().intValue()));

        // 6.Listar ejercicios por grupo muscular
        Map<Integer,List<Integer>> gmE = ejercicioGruposMusculares(listaEjercicios);
        // 7. Asignar ejercicios a rutina
        int cont=0;
        Set<Integer> asignados = new HashSet<>();
        for (Rutina rutina : listaRutinas)
        {
            List<Integer> ejercicios = gmE.get(rutina.getGrupoMuscularId().intValue());
            if (ejercicios != null && !ejercicios.isEmpty()) {
                for (Integer ej : ejercicios) {
                    rutinaEjercicioService.saveRutinaEjercicio(rutina.getId(), ej);
                    asignados.add(ej);
                    cont++;
                    if (cont == 4) break;
                }
                cont = 0;
            }
        }

        System.out.println(asignados);
        // 7. Obtener objetivo Rutina = repeticiones
        int objetivoR = cliente.get().getObjetivoRutinaid();
        Map<Integer,Integer> repeticiones = new HashMap<>();
        repeticiones.put(1,15);
        repeticiones.put(2,8);
        repeticiones.put(1,5);

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


        // 9. Crear proresoxEjercicio
        Calendar calendar = Calendar.getInstance();

        // Establecer la hora, minutos, segundos y milisegundos a cero
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // Obtener un objeto Date con la fecha actual y la hora establecida a cero
        Date fechaActual = calendar.getTime();

        for(Integer asig : asignados)
        {
            ProgresoxEjercicio progreso = new ProgresoxEjercicio();
            List<Integer> equipoE = equipoEjercicioService.findEquipoItemidsByEjercicioid(asig);
            if(!equipoE.contains(15))
                progreso.setPeso(pesos.get(nivelA));
            else
                progreso.setPeso(0);
            progreso.setFecha(fechaActual);
            progreso.setValoracion(0);
            progreso.setSerie(4);
            progreso.setRepeticiones(repeticiones.get(objetivoR));
            progreso.setDescansoEntreSeries(descansos.get(objetivoR));
            progreso.setUsuarioClienteId(cliente.get().getId().intValue());
            ProgresoxEjercicio guardado = progresoxEjercicioService.save(progreso);

            EjercicioProgresoxEjercicio epg = new EjercicioProgresoxEjercicio();
            epg.setEjercicioId(asig);
            epg.setProgresoxEjercicioId(guardado.getId().intValue());
            ejercicioProgresoxEjercicioService.save(epg);
        }

        return ResponseEntity.noContent().build();
    }

    public Map<Integer,List<Integer>> ejercicioGruposMusculares(List<Ejercicio> listaE)
    {
        // idGrupoMuscular - idEjercicios
        Map<Integer, List<Integer>> retorno = new HashMap<>();
        for (Ejercicio ejercicio : listaE) {
            List<Integer> temp = ejercicioService.findGrupoMuscular(ejercicio.getId().intValue());
            for (Integer gm : temp) {
                List<Integer> temp2 = retorno.getOrDefault(gm, new ArrayList<>());
                temp2.add(ejercicio.getId().intValue());
                retorno.put(gm.intValue(), temp2);
            }
        }

        // Eliminar duplicados
        for (Map.Entry<Integer, List<Integer>> entry : retorno.entrySet()) {
            List<Integer> listWithoutDuplicates = new ArrayList<>(new HashSet<>(entry.getValue()));
            Collections.sort(listWithoutDuplicates);
            entry.setValue(listWithoutDuplicates);
        }

        return retorno;
    }



}
