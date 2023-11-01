package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;

@Entity
@Table(name = "nivelactividadfisica")
public class NivelActividadFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", unique = true, nullable = false)
    private String titulo;


    public NivelActividadFisica(Integer id, String titulo ) {
        this.id = id;
        this.titulo = titulo;
    }

    public NivelActividadFisica() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


}
