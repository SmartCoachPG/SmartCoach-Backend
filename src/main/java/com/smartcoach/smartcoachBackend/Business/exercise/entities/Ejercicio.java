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

    @Column(name = "instruccionejecucion")
    private String instruccionEjecucion;

    @Column(name = "instruccionrespiracion")
    private String instruccionRespiracion;


    public Ejercicio()
    {

    }

    public Ejercicio(Long id, String nombre, String instruccionEjecucion, String instruccionRespiracion) {
        this.id = id;
        this.nombre = nombre;
        this.instruccionEjecucion = instruccionEjecucion;
        this.instruccionRespiracion = instruccionRespiracion;
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

    @Override
    public String toString() {
        return "Ejercicio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", instruccionEjecucion='" + instruccionEjecucion + '\'' +
                ", instruccionRespiracion='" + instruccionRespiracion + '\'' +
                '}';
    }
}
