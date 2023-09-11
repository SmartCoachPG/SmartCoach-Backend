package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class RestriccionMedicaEjercicioId implements Serializable {

    @Column(name = "restriccionmedicaid")
    private Integer restriccionMedicaId;

    @Column(name = "ejercicioid")
    private Integer ejercicioId;

    public RestriccionMedicaEjercicioId(Integer restriccionMedicaId, Integer ejercicioId) {
        this.restriccionMedicaId = restriccionMedicaId;
        this.ejercicioId = ejercicioId;
    }

    public RestriccionMedicaEjercicioId()
    {

    }

    public Integer getRestriccionMedicaId() {
        return restriccionMedicaId;
    }

    public void setRestriccionMedicaId(Integer restriccionMedicaId) {
        this.restriccionMedicaId = restriccionMedicaId;
    }

    public Integer getEjercicioId() {
        return ejercicioId;
    }

    public void setEjercicioId(Integer ejercicioId) {
        this.ejercicioId = ejercicioId;
    }
}
