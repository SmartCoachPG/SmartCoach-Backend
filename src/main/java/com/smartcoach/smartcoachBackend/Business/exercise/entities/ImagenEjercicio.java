package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "imagenejercicio")
public class ImagenEjercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imagen")
    private byte[] imagen;

    @ManyToOne
    @JoinColumn(name = "ejercicioid", nullable = false)
    private Ejercicio ejercicio;

    public ImagenEjercicio(Long id, byte[] imagen, Ejercicio ejercicio) {
        this.id = id;
        this.imagen = imagen;
        this.ejercicio = ejercicio;
    }

    public ImagenEjercicio()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
}
