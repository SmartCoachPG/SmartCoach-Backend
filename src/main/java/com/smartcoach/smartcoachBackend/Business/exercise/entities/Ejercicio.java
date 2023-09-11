package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "ejercicio")
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "seriereferencia", nullable = false)
    private Integer serieReferencia;

    @Column(name = "repeticionreferencia", nullable = false)
    private Integer repeticionReferencia;

    @Column(name = "instruccionejecucion")
    private String instruccionEjecucion;

    @Column(name = "instruccionrespiracion")
    private String instruccionRespiracion;

    @Column(name = "descansoentreseries", nullable = false)
    private Time descansoEntreSeries;

    public Ejercicio(Long id, String nombre, Integer serieReferencia, Integer repeticionReferencia, String instruccionEjecucion, String instruccionRespiracion, Time descansoEntreSeries) {
        this.id = id;
        this.nombre = nombre;
        this.serieReferencia = serieReferencia;
        this.repeticionReferencia = repeticionReferencia;
        this.instruccionEjecucion = instruccionEjecucion;
        this.instruccionRespiracion = instruccionRespiracion;
        this.descansoEntreSeries = descansoEntreSeries;
    }

    public Ejercicio()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSerieReferencia() {
        return serieReferencia;
    }

    public void setSerieReferencia(Integer serieReferencia) {
        this.serieReferencia = serieReferencia;
    }

    public Integer getRepeticionReferencia() {
        return repeticionReferencia;
    }

    public void setRepeticionReferencia(Integer repeticionReferencia) {
        this.repeticionReferencia = repeticionReferencia;
    }

    public String getInstruccionEjecucion() {
        return instruccionEjecucion;
    }

    public void setInstruccionEjecucion(String instruccionEjecucion) {
        this.instruccionEjecucion = instruccionEjecucion;
    }

    public String getInstruccionRespiracion() {
        return instruccionRespiracion;
    }

    public void setInstruccionRespiracion(String instruccionRespiracion) {
        this.instruccionRespiracion = instruccionRespiracion;
    }

    public Time getDescansoEntreSeries() {
        return descansoEntreSeries;
    }

    public void setDescansoEntreSeries(Time descansoEntreSeries) {
        this.descansoEntreSeries = descansoEntreSeries;
    }
}
