package com.smartcoach.smartcoachBackend.Business.user.entities;

import jakarta.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "Usuario")
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

    public Usuario() {
    }

    public Usuario(String nombre, String email, String contrasenna, byte[] fotoPerfil) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenna = contrasenna;
        this.fotoPerfil = fotoPerfil;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasenna='" + contrasenna + '\'' +
                ", fotoPerfil=" + Arrays.toString(fotoPerfil) +
                '}';
    }
}
