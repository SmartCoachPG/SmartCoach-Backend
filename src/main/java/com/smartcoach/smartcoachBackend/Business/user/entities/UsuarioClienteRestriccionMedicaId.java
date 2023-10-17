package com.smartcoach.smartcoachBackend.Business.user.entities;

import java.io.Serializable;

public class UsuarioClienteRestriccionMedicaId implements Serializable {

    private Integer usuarioClienteid;
    private Integer restriccionMedicaid;

    public UsuarioClienteRestriccionMedicaId() {
    }

    public UsuarioClienteRestriccionMedicaId(Integer usuarioClienteUsuarioid, Integer restriccionMedicaid) {
        this.usuarioClienteid = usuarioClienteUsuarioid;
        this.restriccionMedicaid = restriccionMedicaid;
    }

    @Override
    public String toString() {
        return "UsuarioClienteRestriccionMedicaId{" +
                "usuarioClienteid=" + usuarioClienteid +
                ", restriccionMedicaid=" + restriccionMedicaid +
                '}';
    }
}
