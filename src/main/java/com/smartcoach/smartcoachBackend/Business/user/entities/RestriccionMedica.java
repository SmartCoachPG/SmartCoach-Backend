package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;

@Entity
@Table(name = "restriccionmedica")
public class RestriccionMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombrelimitacion", unique = true, nullable = false)
    private String nombreLimitacion;

    public RestriccionMedica(int id, String nombreLimitacion) {
        this.id = id;
        this.nombreLimitacion = nombreLimitacion;
    }

    public RestriccionMedica()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreLimitacion() {
        return nombreLimitacion;
    }

    public void setNombreLimitacion(String nombreLimitacion) {
        this.nombreLimitacion = nombreLimitacion;
    }
}
