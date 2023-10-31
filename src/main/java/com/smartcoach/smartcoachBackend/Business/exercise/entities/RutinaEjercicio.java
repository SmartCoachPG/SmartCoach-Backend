package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "rutina_ejercicio")
@IdClass(RutinaEjercicioId.class)
public class RutinaEjercicio {

    @Id
    @Column(name = "rutinaid")
    private Integer rutinaId;

    @Id
    @Column(name = "ejercicioid")
    private Integer ejercicioid;

    public RutinaEjercicio(Integer rutinaId, Integer ejercicioid) {
        this.rutinaId = rutinaId;
        this.ejercicioid = ejercicioid;
    }

    public RutinaEjercicio() {}

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