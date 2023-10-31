package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RutinaEjercicioId implements Serializable {
    private Integer rutinaId;
    private Integer ejercicioid;

    public RutinaEjercicioId(Integer rutinaId, Integer ejercicioid) {
        this.rutinaId = rutinaId;
        this.ejercicioid = ejercicioid;
    }

    public RutinaEjercicioId() {}

    public Integer getRutinaId() {
        return rutinaId;
    }

    public void setRutinaId(Integer rutinaId) {
        this.rutinaId = rutinaId;
    }

    public Integer getEjercicioid() {
        return ejercicioid;
    }

    public void setEjercicioid(Integer ejercicioid) {
        this.ejercicioid = ejercicioid;
    }
}