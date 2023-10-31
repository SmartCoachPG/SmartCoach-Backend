package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class EjercicioProgresoxEjercicioId implements Serializable {

    @Column(name = "ejercicioid")
    private Integer ejercicioId;

    @Column(name = "progresoxejercicioid")
    private Integer progresoxEjercicioId;

    public EjercicioProgresoxEjercicioId(Integer ejercicioId, Integer progresoxEjercicioId) {
        this.ejercicioId = ejercicioId;
        this.progresoxEjercicioId = progresoxEjercicioId;
    }

    public EjercicioProgresoxEjercicioId() {}

    public Integer getEjercicioId() {
        return ejercicioId;
    }

    public void setEjercicioId(Integer ejercicioId) {
        this.ejercicioId = ejercicioId;
    }

    public Integer getProgresoxEjercicioId() {
        return progresoxEjercicioId;
    }

    public void setProgresoxEjercicioId(Integer progresoxEjercicioId) {
        this.progresoxEjercicioId = progresoxEjercicioId;
    }
}
