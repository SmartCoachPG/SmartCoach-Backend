package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "objetivo")
public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(name="fechainicio",nullable = false)
    private LocalDate fechaInicio;

    @Column(name="fechafinal",nullable = false)
    private LocalDate fechaFinal;

    @Column(nullable = false)
    private Integer estado;

    private String descripcionObjetivo;

    @Column(name="usuarioclienteusuarioid",nullable = false)
    private Integer usuarioClienteId;

    public Objetivo(Long id, String titulo, LocalDate fechaInicio, LocalDate fechaFinal, Integer estado, String descripcionObjetivo, Integer usuarioClienteId) {
        this.id = id;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
        this.descripcionObjetivo = descripcionObjetivo;
        this.usuarioClienteId = usuarioClienteId;
    }

    public Objetivo() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getDescripcionObjetivo() {
        return descripcionObjetivo;
    }

    public void setDescripcionObjetivo(String descripcionObjetivo) {
        this.descripcionObjetivo = descripcionObjetivo;
    }

    public Integer getUsuarioClienteId() {
        return usuarioClienteId;
    }

    public void setUsuarioClienteId(Integer usuarioClienteId) {
        this.usuarioClienteId = usuarioClienteId;
    }
}
