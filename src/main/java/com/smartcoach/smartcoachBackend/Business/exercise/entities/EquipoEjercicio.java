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


    public EquipoEjercicio(int equipoItemid, int ejercicioid, Equipo equipo, Ejercicio ejercicio) {
        this.equipoItemid = equipoItemid;
        this.ejercicioid = ejercicioid;
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


}
