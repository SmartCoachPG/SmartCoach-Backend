package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import java.io.Serializable;

class MusculoGrupoMuscularId implements Serializable {
    private Integer musculoId;
    private Integer grupoMuscularId;

    public MusculoGrupoMuscularId(){

    }

    public MusculoGrupoMuscularId(Integer musculoId, Integer grupoMuscularId) {
        this.musculoId = musculoId;
        this.grupoMuscularId = grupoMuscularId;
    }

    public Integer getMusculoId() {
        return musculoId;
    }

    public void setMusculoId(Integer musculoId) {
        this.musculoId = musculoId;
    }

    public Integer getGrupoMuscularId() {
        return grupoMuscularId;
    }

    public void setGrupoMuscularId(Integer grupoMuscularId) {
        this.grupoMuscularId = grupoMuscularId;
    }

}
