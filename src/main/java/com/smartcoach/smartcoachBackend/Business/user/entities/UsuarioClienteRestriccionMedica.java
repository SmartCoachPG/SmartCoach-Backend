package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuariocliente_restriccionmedica")
@IdClass(UsuarioClienteRestriccionMedicaId.class)
public class UsuarioClienteRestriccionMedica {

    @Id
    @Column(name = "usuarioclienteusuarioid")
    private Integer usuarioClienteUsuarioid;

    @Id
    @Column(name = "restriccionmedicaid")
    private Integer restriccionMedicaid;

    public UsuarioClienteRestriccionMedica(Integer usuarioClienteUsuarioid, Integer restriccionMedicaid) {
        this.usuarioClienteUsuarioid = usuarioClienteUsuarioid;
        this.restriccionMedicaid = restriccionMedicaid;
    }

    public UsuarioClienteRestriccionMedica()
    {

    }

    public Integer getUsuarioClienteUsuarioid() {
        return usuarioClienteUsuarioid;
    }

    public void setUsuarioClienteUsuarioid(Integer usuarioClienteUsuarioid) {
        this.usuarioClienteUsuarioid = usuarioClienteUsuarioid;
    }

    public Integer getRestriccionMedicaid() {
        return restriccionMedicaid;
    }

    public void setRestriccionMedicaid(Integer restriccionMedicaid) {
        this.restriccionMedicaid = restriccionMedicaid;
    }
}
