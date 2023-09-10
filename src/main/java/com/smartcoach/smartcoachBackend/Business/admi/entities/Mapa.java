package com.smartcoach.smartcoachBackend.Business.admi.entities;

import javax.persistence.*;

@Entity
@Table(name = "mapa")
public class Mapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer nivel;

    @Column(nullable = false)
    private Integer ancho;

    @Column(nullable = false)
    private Integer alto;

    @Column(nullable = false)
    private Integer version;

    @Column(name = "gimnasioid", nullable = false)
    private Integer gimnasioId;

    @ManyToOne
    @JoinColumn(name = "gimnasioid", referencedColumnName = "id", insertable = false, updatable = false)
    private Gimnasio gimnasio;

    public Mapa(Long id, Integer nivel, Integer ancho, Integer alto, Integer version, Integer gimnasioId, Gimnasio gimnasio) {
        this.id = id;
        this.nivel = nivel;
        this.ancho = ancho;
        this.alto = alto;
        this.version = version;
        this.gimnasioId = gimnasioId;
        this.gimnasio = gimnasio;
    }

    public Mapa()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getGimnasioId() {
        return gimnasioId;
    }

    public void setGimnasioId(Integer gimnasioId) {
        this.gimnasioId = gimnasioId;
    }

    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }
}
