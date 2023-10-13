package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuariocliente_restriccionmedica")
@IdClass(UsuarioClienteRestriccionMedicaId.class)
public class UsuarioClienteRestriccionMedica {

    @Id
    @Column(name = "usuarioclienteusuarioid")
    private Integer usuarioClienteid;

    @Id
    @Column(name = "restriccionmedicaid")
    private Integer restriccionMedicaid;

    public UsuarioClienteRestriccionMedica(Integer usuarioClienteUsuarioid, Integer restriccionMedicaid) {
        this.usuarioClienteid = usuarioClienteUsuarioid;
        this.restriccionMedicaid = restriccionMedicaid;
    }

    public UsuarioClienteRestriccionMedica()
    {

    }

    public Integer getUsuarioClienteId() {
        return usuarioClienteid;
    }

    public void setUsuarioClienteId(Integer usuarioClienteId) {
        this.usuarioClienteid = usuarioClienteId;
    }

    public Integer getRestriccionMedicaid() {
        return restriccionMedicaid;
    }

    public void setRestriccionMedicaid(Integer restriccionMedicaid) {
        this.restriccionMedicaid = restriccionMedicaid;
    }
}
