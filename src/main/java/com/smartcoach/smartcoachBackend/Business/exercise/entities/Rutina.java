package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Time;

@Entity
@Table(name = "rutina")
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "horaI")
    private Time horaI;

    @Column(name = "horaF")
    private Time horaF;

    @Column(nullable = false, length = 255)
    private String dia;

    @Column(nullable = false)
    private Time duracion;

    @Column(nullable = false,name="cantejercicios")
    private int cantEjercicios;

    @Column(name = "UsuarioClienteUsuarioid")
    private Integer usuarioClienteId; // Representa el ID de UsuarioCliente sin establecer una relación directa

    public Rutina(int id, Time horaI, Time horaF, String dia, Time duracion, int cantEjercicios, Integer usuarioClienteId) {
        this.id = id;
        this.horaI = horaI;
        this.horaF = horaF;
        this.dia = dia;
        this.duracion = duracion;
        this.cantEjercicios = cantEjercicios;
        this.usuarioClienteId = usuarioClienteId;
    }

    public Rutina(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getHoraI() {
        return horaI;
    }

    public void setHoraI(Time horaI) {
        this.horaI = horaI;
    }

    public Time getHoraF() {
        return horaF;
    }

    public void setHoraF(Time horaF) {
        this.horaF = horaF;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public int getCantEjercicios() {
        return cantEjercicios;
    }

    public void setCantEjercicios(int cantEjercicios) {
        this.cantEjercicios = cantEjercicios;
    }

    public Integer getUsuarioClienteId() {
        return usuarioClienteId;
    }

    public void setUsuarioClienteId(Integer usuarioClienteId) {
        this.usuarioClienteId = usuarioClienteId;
    }
}

