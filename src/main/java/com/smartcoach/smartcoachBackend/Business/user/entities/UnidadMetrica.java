package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;

@Entity
@Table(name = "unidadmetrica")
public class UnidadMetrica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "metrica", unique = true, nullable = false)
    private String metrica;

    public UnidadMetrica(int id, String metrica) {
        this.id = id;
        this.metrica = metrica;
    }

    public UnidadMetrica() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetrica() {
        return metrica;
    }

    public void setMetrica(String metrica) {
        this.metrica = metrica;
    }
}
