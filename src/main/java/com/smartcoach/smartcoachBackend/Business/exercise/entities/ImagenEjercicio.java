package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "imagenejercicio")
public class ImagenEjercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "ejercicioid", nullable = false)
    private int ejercicioid;


    public ImagenEjercicio(Long id, String imagen, int ejercicioid) {
        this.id = id;
        this.imagen = imagen;
        this.ejercicioid = ejercicioid;
    }

    public ImagenEjercicio() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getEjercicioid() {
        return ejercicioid;
    }

    public void setEjercicioid(int ejercicioid) {
        this.ejercicioid = ejercicioid;
    }
}
