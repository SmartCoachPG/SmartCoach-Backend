package com.smartcoach.smartcoachBackend.Business.admi.entities;

import javax.persistence.*;

@Entity
@Table(name = "tipoequipo")
public class TipoEquipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    public TipoEquipo(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoEquipo()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
