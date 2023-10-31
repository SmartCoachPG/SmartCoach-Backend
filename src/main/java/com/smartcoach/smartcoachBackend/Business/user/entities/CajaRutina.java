package com.smartcoach.smartcoachBackend.Business.user.entities;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.Ejercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.entities.ImagenEjercicio;

public class CajaRutina {

    private Ejercicio ejercicio;
    private ProgresoxEjercicio progresoxEjercicio;
    private ImagenEjercicio imagenEjercicio;

    public CajaRutina(Ejercicio ejercicio, ProgresoxEjercicio progresoxEjercicio, ImagenEjercicio imagenEjercicio) {
        this.ejercicio = ejercicio;
        this.progresoxEjercicio = progresoxEjercicio;
        this.imagenEjercicio = imagenEjercicio;
    }

    public CajaRutina(){};

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public ProgresoxEjercicio getProgresoxEjercicio() {
        return progresoxEjercicio;
    }

    public void setProgresoxEjercicio(ProgresoxEjercicio progresoxEjercicio) {
        this.progresoxEjercicio = progresoxEjercicio;
    }

    public ImagenEjercicio getImagenEjercicio() {
        return imagenEjercicio;
    }

    public void setImagenEjercicio(ImagenEjercicio imagenEjercicio) {
        this.imagenEjercicio = imagenEjercicio;
    }
}
