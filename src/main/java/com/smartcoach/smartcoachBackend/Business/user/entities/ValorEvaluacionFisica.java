package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;

@Entity
@Table(name = "valorevaluacionfisica")
public class ValorEvaluacionFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "unidadmetricaid", nullable = true)
    private Integer unidadMetricaId;

    public ValorEvaluacionFisica(int id, String nombre, String descripcion, Integer unidadMetricaId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMetricaId = unidadMetricaId;
    }

    public ValorEvaluacionFisica(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getUnidadMetricaId() {
        return unidadMetricaId;
    }

    public void setUnidadMetricaId(Integer unidadMetricaId) {
        this.unidadMetricaId = unidadMetricaId;
    }
}
