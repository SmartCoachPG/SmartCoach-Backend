package com.smartcoach.smartcoachBackend.Business.exercise.entities;import javax.persistence.*;

@Entity
@Table(name = "rutina_musculo")
@IdClass(RutinaMusculoId.class)
public class RutinaMusculo {

    @Id
    @ManyToOne
    @JoinColumn(name = "rutinaid", nullable = false)
    private Rutina rutina;

    @Id
    @ManyToOne
    @JoinColumn(name = "musculoid", nullable = false)
    private Musculo musculo;

    public RutinaMusculo( Rutina rutina, Musculo musculo) {
        this.rutina = rutina;
        this.musculo = musculo;
    }

    public RutinaMusculo()
    {

    }



    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public Musculo getMusculo() {
        return musculo;
    }

    public void setMusculo(Musculo musculo) {
        this.musculo = musculo;
    }
}
