package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "contrasenna", nullable = false)
    private String contrasenna;

    @Lob
    private byte[] fotoPerfil;

    @Column(nullable = false)
    private Integer admi;

    public Usuario() {
    }

    public Usuario(String nombre, String email, String contrasenna, byte[] fotoPerfil,Integer admi) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenna = contrasenna;
        this.fotoPerfil = fotoPerfil;
        this.admi = admi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Integer getAdmi() {
        return admi;
    }

    public void setAdmi(Integer admi) {
        this.admi = admi;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasenna='" + contrasenna + '\'' +
                ", fotoPerfil=" + Arrays.toString(fotoPerfil) +
                ", admi=" + admi +
                '}';
    }
}
