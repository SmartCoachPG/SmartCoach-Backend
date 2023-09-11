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

    @ManyToOne
    @JoinColumn(name = "unidadmetricaid", nullable = true)
    private UnidadMetrica unidadMetrica;

    public ValorEvaluacionFisica(int id, String nombre, String descripcion, UnidadMetrica unidadMetrica) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMetrica = unidadMetrica;
    }

    public ValorEvaluacionFisica()
    {

    }

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

    public UnidadMetrica getUnidadMetrica() {
        return unidadMetrica;
    }

    public void setUnidadMetrica(UnidadMetrica unidadMetrica) {
        this.unidadMetrica = unidadMetrica;
    }
}
