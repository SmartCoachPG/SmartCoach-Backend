package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import java.io.Serializable;
import java.util.Objects;

public class EquipoEjercicioId implements Serializable {

    private int equipoItemid;
    private int ejercicioid;

    public EquipoEjercicioId() {
    }

    public EquipoEjercicioId(int equipoItemid, int ejercicioid) {
        this.equipoItemid = equipoItemid;
        this.ejercicioid = ejercicioid;
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
