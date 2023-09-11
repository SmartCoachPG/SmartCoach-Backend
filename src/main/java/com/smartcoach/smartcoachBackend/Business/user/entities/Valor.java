package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;

@Entity
@Table(name = "valor")
public class Valor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "valor", nullable = false)
    private float valor;

    @ManyToOne
    @JoinColumn(name = "perfilmedicoid", nullable = true)
    private PerfilMedico perfilMedico;

    @ManyToOne
    @JoinColumn(name = "Valorevaluacionfisicaid", nullable = false)
    private ValorEvaluacionFisica valorEvaluacionFisica;

    public Valor(int id, float valor, PerfilMedico perfilMedico, ValorEvaluacionFisica valorEvaluacionFisica) {
        this.id = id;
        this.valor = valor;
        this.perfilMedico = perfilMedico;
        this.valorEvaluacionFisica = valorEvaluacionFisica;
    }
    public Valor()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public PerfilMedico getPerfilMedico() {
        return perfilMedico;
    }

    public void setPerfilMedico(PerfilMedico perfilMedico) {
        this.perfilMedico = perfilMedico;
    }

    public ValorEvaluacionFisica getValorEvaluacionFisica() {
        return valorEvaluacionFisica;
    }

    public void setValorEvaluacionFisica(ValorEvaluacionFisica valorEvaluacionFisica) {
        this.valorEvaluacionFisica = valorEvaluacionFisica;
    }
}
