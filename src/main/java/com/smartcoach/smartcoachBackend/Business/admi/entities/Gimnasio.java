package com.smartcoach.smartcoachBackend.Business.admi.entities;

import javax.persistence.*;

@Entity
@Table(name = "Gimnasio")
public class Gimnasio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer pisos;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String barrio;

    @Column(name = "imagengimnasio")
    private String imagenGimnasio;

    public Gimnasio(Long id, String nombre, Integer pisos, String direccion, String barrio, String imagenGimnasio) {
        this.id = id;
        this.nombre = nombre;
        this.pisos = pisos;
        this.direccion = direccion;
        this.barrio = barrio;
        this.imagenGimnasio = imagenGimnasio;
    }

    public Gimnasio() {}

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

    public Integer getPisos() {
        return pisos;
    }

    public void setPisos(Integer pisos) {
        this.pisos = pisos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getImagenGimnasio() {
        return imagenGimnasio;
    }

    public void setImagenGimnasio(String imagenGimnasio) {
        this.imagenGimnasio = imagenGimnasio;
    }
}
