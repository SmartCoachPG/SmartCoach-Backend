package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "restriccionmedica_ejercicio")
@IdClass(RestriccionMedicaEjercicioId.class)
public class RestriccionMedicaEjercicio {

    @Id
    @Column(name = "restriccionmedicaid")
    private Integer restriccionMedicaId;

    @Id
    @Column(name = "ejercicioid")
    private Integer ejercicioId;

    public RestriccionMedicaEjercicio(Integer restriccionMedicaId, Integer ejercicioId) {
        this.restriccionMedicaId = restriccionMedicaId;
        this.ejercicioId = ejercicioId;
    }

    public RestriccionMedicaEjercicio()
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
