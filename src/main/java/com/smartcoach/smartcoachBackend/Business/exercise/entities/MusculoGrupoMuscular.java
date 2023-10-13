package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "musculo_grupomuscular")
@IdClass(MusculoGrupoMuscularId.class) // Clase que representa la clave compuesta
public class MusculoGrupoMuscular {

    @Id
    @Column(name = "musculoid")
    private Integer musculoId;

    @Id
    @Column(name = "grupo_muscularid")
    private Integer grupoMuscularId;


    public MusculoGrupoMuscular(Integer musculoId, Integer grupoMuscularId) {
        this.musculoId = musculoId;
        this.grupoMuscularId = grupoMuscularId;
    }

    public MusculoGrupoMuscular(){

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


