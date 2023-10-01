package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "rutina")
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column
    private Time horaI;

    @Column
    private Time horaF;

    @Column(nullable = false, length = 255)
    private String dia;

    @Column(nullable = false)
    private Time duracion;

    @Column(nullable = false,name="cantejercicios")
    private int cantEjercicios;

    @Column(name = "UsuarioClienteUsuarioid")
    private int usuarioClienteId; // Representa el ID de UsuarioCliente sin establecer una relación directa

    public Rutina(int id, String nombre, Time horaI, Time horaF, String dia, Time duracion, int cantEjercicios, int usuarioClienteId) {
        this.id = id;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getUsuarioClienteId() {
        return usuarioClienteId;
    }

    public void setUsuarioClienteId(int usuarioClienteId) {
        this.usuarioClienteId = usuarioClienteId;
    }
}

