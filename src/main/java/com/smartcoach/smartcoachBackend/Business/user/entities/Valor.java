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

    @Column(name = "perfilmedicoid")
    private int perfilMedicoid;

    @Column(name = "valorevaluacionfisicaid")
    private int valorEvaluacionFisicaid;


    public Valor(int id, float valor, int perfilMedicoid, int valorEvaluacionFisicaid) {
        this.id = id;
        this.valor = valor;
        this.perfilMedicoid = perfilMedicoid;
        this.valorEvaluacionFisicaid = valorEvaluacionFisicaid;
    }

    public Valor() {}

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

    public int getPerfilMedicoid() {
        return perfilMedicoid;
    }

    public void setPerfilMedicoid(int perfilMedicoid) {
        this.perfilMedicoid = perfilMedicoid;
    }

    public int getValorEvaluacionFisicaid() {
        return valorEvaluacionFisicaid;
    }

    public void setValorEvaluacionFisicaid(int valorEvaluacionFisicaid) {
        this.valorEvaluacionFisicaid = valorEvaluacionFisicaid;
    }
}
