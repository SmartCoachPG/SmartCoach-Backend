package com.smartcoach.smartcoachBackend.Business.exercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "videoejercicio")
public class VideoEjercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "video")
    private byte[] video;

    @ManyToOne
    @JoinColumn(name = "ejercicioid", nullable = false)
    private Ejercicio ejercicio;

    public VideoEjercicio(Long id, byte[] video, Ejercicio ejercicio) {
        this.id = id;
        this.video = video;
        this.ejercicio = ejercicio;
    }

    public VideoEjercicio() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
}
