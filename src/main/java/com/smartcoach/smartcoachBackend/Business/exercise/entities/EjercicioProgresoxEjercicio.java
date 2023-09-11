package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "ejercicio_progresoxejercicio")
@IdClass(EjercicioProgresoxEjercicioId.class)
public class EjercicioProgresoxEjercicio {

    @Id
    @Column(name = "ejercicioid")
    private Integer ejercicioId;

    @Id
    @Column(name = "progresoxejercicioid")
    private Integer progresoxEjercicioId;

    public EjercicioProgresoxEjercicio(Integer ejercicioId, Integer progresoxEjercicioId) {
        this.ejercicioId = ejercicioId;
        this.progresoxEjercicioId = progresoxEjercicioId;
    }

    public EjercicioProgresoxEjercicio()
    {

    }

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
