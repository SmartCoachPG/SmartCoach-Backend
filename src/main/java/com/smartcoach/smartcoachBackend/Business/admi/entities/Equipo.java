package com.smartcoach.smartcoachBackend.Business.admi.entities;

import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;

import javax.persistence.*;

@Entity
@Table(name = "equipo")
@PrimaryKeyJoinColumn(name = "itemid", referencedColumnName = "id")
public class Equipo extends Item {

    private String referencia; 

    @Column(name="usuarioid")
    private Integer usuarioId;

    @Column(name="tipoequipoid")
    private Integer tipoEquipoId;

    public Equipo(Long id, String imagen, String nombre, Long itemId, String referencia, Integer usuarioClienteId, Integer tipoEquipoId) {
        super(id, imagen, nombre);
        this.referencia = referencia;
        this.usuarioId = usuarioClienteId;
        this.tipoEquipoId = tipoEquipoId;
    }

    public Equipo(Long itemId, String referencia, Integer usuarioClienteId, Integer tipoEquipoId) {
        this.referencia = referencia;
        this.usuarioId = usuarioClienteId;
        this.tipoEquipoId = tipoEquipoId;
    }

    public Equipo()
    {

    }


    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getUsuarioClienteId() {
        return usuarioId;
    }

    public void setUsuarioClienteId(Integer usuarioClienteId) {
        this.usuarioId = usuarioClienteId;
    }

    public Integer getTipoEquipoId() {
        return tipoEquipoId;
    }

    public void setTipoEquipoId(Integer tipoEquipoId) {
        this.tipoEquipoId = tipoEquipoId;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                super.toString()+
                "referencia='" + referencia + '\'' +
                ", usuarioClienteId=" + usuarioId +
                ", tipoEquipoId=" + tipoEquipoId +
                '}';
    }
}
