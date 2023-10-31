package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MusculoEjercicioId implements Serializable {

    private int musculoId;
    private int ejercicioId;

    public MusculoEjercicioId() {}

    public MusculoEjercicioId(int musculoId, int ejercicioId) {
        this.musculoId = musculoId;
        this.ejercicioId = ejercicioId;
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
