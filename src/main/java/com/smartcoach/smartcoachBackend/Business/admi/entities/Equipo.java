package com.smartcoach.smartcoachBackend.Business.admi.entities;

import com.smartcoach.smartcoachBackend.Business.user.entities.UsuarioCliente;

import javax.persistence.*;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @Column(name = "itemid")
    private Long itemId;

    private String referencia;

    @ManyToOne
    @JoinColumn(name = "usuarioclienteusuarioid", referencedColumnName = "usuarioid")
    private UsuarioCliente usuarioCliente;

    @ManyToOne
    @JoinColumn(name = "tipoequipoid", nullable = false)
    private TipoEquipo tipoEquipo;

    public Equipo(Long itemId, String referencia, UsuarioCliente usuarioCliente, TipoEquipo tipoEquipo) {
        this.itemId = itemId;
        this.referencia = referencia;
        this.usuarioCliente = usuarioCliente;
        this.tipoEquipo = tipoEquipo;
    }

    public Equipo()
    {

    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public UsuarioCliente getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }
}
