package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RutinaMusculoId implements Serializable {

    private Long rutina;
    private Long musculo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RutinaMusculoId that = (RutinaMusculoId) o;
        return rutina == that.rutina && musculo == that.musculo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rutina, musculo);
    }

    public RutinaMusculoId(Long rutinaId, Long musculoId) {
        this.rutina = rutinaId;
        this.musculo = musculoId;
    }

    public RutinaMusculoId()
    {

    }
}
