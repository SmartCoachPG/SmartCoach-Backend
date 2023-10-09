package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "progresoxejercicio")
public class ProgresoxEjercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer peso;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Integer valoracion;

    @Column(nullable = false)
    private Integer serie;

    @Column(nullable = false)
    private Integer repeticiones;

    private String comentarios;

    @Column(name = "descansoentreseries", nullable = false)
    private Time descansoEntreSeries;

    @Column(name = "usuarioclienteusuarioid", nullable = false)
    private Integer usuarioClienteUsuarioid;


    public ProgresoxEjercicio(Long id, Integer peso, Date fecha, Integer valoracion, Integer serie, Integer repeticiones, String comentarios, Time descansoEntreSeries, Integer usuarioClienteUsuarioid) {
        this.id = id;
        this.peso = peso;
        this.fecha = fecha;
        this.valoracion = valoracion;
        this.serie = serie;
        this.repeticiones = repeticiones;
        this.comentarios = comentarios;
        this.descansoEntreSeries = descansoEntreSeries;
        this.usuarioClienteUsuarioid = usuarioClienteUsuarioid;
    }

    public ProgresoxEjercicio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Time getDescansoEntreSeries() {
        return descansoEntreSeries;
    }

    public void setDescansoEntreSeries(Time descansoEntreSeries) {
        this.descansoEntreSeries = descansoEntreSeries;
    }

    public Integer getUsuarioClienteUsuarioid() {
        return usuarioClienteUsuarioid;
    }

    public void setUsuarioClienteUsuarioid(Integer usuarioClienteUsuarioid) {
        this.usuarioClienteUsuarioid = usuarioClienteUsuarioid;
    }
}
