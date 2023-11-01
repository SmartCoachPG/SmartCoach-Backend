package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "contraseña", nullable = false)
    private String contrasenna;

    @Column(name = "fotoperfil")
    private String fotoPerfil;

    @Column(nullable = false)
    private Integer admi;

    private String token;

    public Usuario() {}

    public Usuario(String nombre, String email, String contrasenna, String fotoPerfil,Integer admi) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenna = contrasenna;
        this.fotoPerfil = fotoPerfil;
        this.admi = admi;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Integer getAdmi() {
        return admi;
    }

    public void setAdmi(Integer admi) {
        this.admi = admi;
    }

}
