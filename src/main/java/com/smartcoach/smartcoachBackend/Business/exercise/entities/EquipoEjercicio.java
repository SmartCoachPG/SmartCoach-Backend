package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import com.smartcoach.smartcoachBackend.Business.admi.entities.Equipo;

import javax.persistence.*;

@Entity
@Table(name = "equipo_ejercicio")
@IdClass(EquipoEjercicioId.class)
public class EquipoEjercicio {

    @Id
    @Column(name = "equipoitemid")
    private int equipoItemid;

    @Id
    @Column(name = "ejercicioid")
    private int ejercicioid;

    @ManyToOne
    @JoinColumn(name = "equipoitemid", insertable = false, updatable = false)
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "ejercicioid", insertable = false, updatable = false)
    private Ejercicio ejercicio;

    public EquipoEjercicio(int equipoItemid, int ejercicioid, Equipo equipo, Ejercicio ejercicio) {
        this.equipoItemid = equipoItemid;
        this.ejercicioid = ejercicioid;
        this.equipo = equipo;
        this.ejercicio = ejercicio;
    }

    public EquipoEjercicio()
    {

    }

    public int getEquipoItemid() {
        return equipoItemid;
    }

    public void setEquipoItemid(int equipoItemid) {
        this.equipoItemid = equipoItemid;
    }

    public int getEjercicioid() {
        return ejercicioid;
    }

    public void setEjercicioid(int ejercicioid) {
        this.ejercicioid = ejercicioid;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
}
