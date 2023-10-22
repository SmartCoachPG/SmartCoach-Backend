package com.smartcoach.smartcoachBackend.Business.admi.entities;

import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;

import javax.persistence.*;

@Entity
@Table(name = "equipo")
@PrimaryKeyJoinColumn(name = "itemid", referencedColumnName = "id")
public class Equipo extends Item {

    private String referencia;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="usuarioid")
    private Integer usuarioId;

    @Column(name="tipoequipoid")
    private Integer tipoEquipoId;

    public Equipo(Long id, String imagen, String nombre, String referencia, String descripcion, Integer usuarioId, Integer tipoEquipoId) {
        super(id, imagen, nombre);
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.usuarioId = usuarioId;
        this.tipoEquipoId = tipoEquipoId;
    }

    public Equipo(String referencia, String descripcion, Integer usuarioId, Integer tipoEquipoId) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.usuarioId = usuarioId;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "referencia='" + referencia + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", usuarioId=" + usuarioId +
                ", tipoEquipoId=" + tipoEquipoId +
                '}';
    }
}
