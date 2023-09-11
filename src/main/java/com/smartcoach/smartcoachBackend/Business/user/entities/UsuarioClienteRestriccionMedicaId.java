package com.smartcoach.smartcoachBackend.Business.user.entities;

import java.io.Serializable;

public class UsuarioClienteRestriccionMedicaId implements Serializable {

    private Integer usuarioClienteUsuarioid;
    private Integer restriccionMedicaid;

    public UsuarioClienteRestriccionMedicaId() {
    }

    public UsuarioClienteRestriccionMedicaId(Integer usuarioClienteUsuarioid, Integer restriccionMedicaid) {
        this.usuarioClienteUsuarioid = usuarioClienteUsuarioid;
        this.restriccionMedicaid = restriccionMedicaid;
    }


}
