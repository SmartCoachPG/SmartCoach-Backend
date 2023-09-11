package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "musculo_ejercicio")
@IdClass(MusculoEjercicioId.class)
public class MusculoEjercicio {

    @Id
    @Column(name="musculoid")
    private int musculoId;

    @Id
    @Column(name="ejercicioid")
    private int ejercicioId;

    public MusculoEjercicio(int musculoId, int ejercicioId) {
        this.musculoId = musculoId;
        this.ejercicioId = ejercicioId;
    }

    public MusculoEjercicio()
    {

    }

    public int getMusculoId() {
        return musculoId;
    }

    public void setMusculoId(int musculoId) {
        this.musculoId = musculoId;
    }

    public int getEjercicioId() {
        return ejercicioId;
    }

    public void setEjercicioId(int ejercicioId) {
        this.ejercicioId = ejercicioId;
    }
}
