package com.smartcoach.smartcoachBackend.Business.user.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "usuariocliente_restriccionmedica")
@IdClass(UsuarioClienteRestriccionMedicaId.class)
public class UsuarioClienteRestriccionMedica {

    @Id
    @Column(name = "usuarioclienteid")
    @JsonProperty("usuarioClienteid")
    private Integer usuarioClienteid;

    @Id
    @Column(name = "restriccionmedicaid")
    @JsonProperty("restriccionMedicaid")
    private Integer restriccionMedicaid;

    public UsuarioClienteRestriccionMedica(Integer usuarioClienteid, Integer restriccionMedicaid) {
        this.usuarioClienteid = usuarioClienteid;
        this.restriccionMedicaid = restriccionMedicaid;
    }

    public UsuarioClienteRestriccionMedica()
    {

    }

    public Integer getUsuarioClienteid() {
        return usuarioClienteid;
    }

    public void setUsuarioClienteId(Integer usuarioClienteid) {
        this.usuarioClienteid = usuarioClienteid;
    }

    public Integer getRestriccionMedicaid() {
        return restriccionMedicaid;
    }

    public void setRestriccionMedicaid(Integer restriccionMedicaid) {
        this.restriccionMedicaid = restriccionMedicaid;
    }

    @Override
    public String toString() {
        return "UsuarioClienteRestriccionMedica{" +
                "usuarioClienteid=" + usuarioClienteid +
                ", restriccionMedicaid=" + restriccionMedicaid +
                '}';
    }
}
