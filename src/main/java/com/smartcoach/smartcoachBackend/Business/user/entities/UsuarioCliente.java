package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="usuariocliente")
@PrimaryKeyJoinColumn(name = "usuarioid", referencedColumnName = "id")
public class UsuarioCliente extends Usuario{

    @Column(nullable = false)
    private String genero;

    @Column(name = "fechadenacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;

    @Column(name = "gimnasioid")
    private Integer gimnasioid;

    @Column(name = "nivelactividadfisicaid")
    private Integer nivelActividadFisicaid;

    @Column(name = "objetivorutinaid", nullable = false)
    private Integer objetivoRutinaid;

    @Column(name = "grupo_muscularid", nullable = false)
    private Integer grupoMuscularid;

    @Column(name="token")
    private String token;

    public UsuarioCliente() {}

    public UsuarioCliente(String token, String genero, Date fechaDeNacimiento, Integer gimnasioid, Integer nivelActividadFisicaid, Integer objetivoRutinaid, Integer grupoMuscularid) {
        this.genero = genero;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.gimnasioid = gimnasioid;
        this.nivelActividadFisicaid = nivelActividadFisicaid;
        this.objetivoRutinaid = objetivoRutinaid;
        this.grupoMuscularid = grupoMuscularid;
        this.token = token;
    }

    public UsuarioCliente(String nombre, String email, String contrasenna, String fotoPerfil, Integer admi, String genero, Date fechaDeNacimiento, Integer gimnasioid, Integer nivelActividadFisicaid, Integer objetivoRutinaid, Integer grupoMuscularid) {
        super(nombre, email, contrasenna, fotoPerfil, admi);
        this.genero = genero;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.gimnasioid = gimnasioid;
        this.nivelActividadFisicaid = nivelActividadFisicaid;
        this.objetivoRutinaid = objetivoRutinaid;
        this.grupoMuscularid = grupoMuscularid;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getGimnasioid() {
        return gimnasioid;
    }

    public void setGimnasioid(Integer gimnasioid) {
        this.gimnasioid = gimnasioid;
    }

    public Integer getNivelActividadFisicaid() {
        return nivelActividadFisicaid;
    }

    public void setNivelActividadFisicaid(Integer nivelActividadFisicaid) {
        this.nivelActividadFisicaid = nivelActividadFisicaid;
    }

    public Integer getObjetivoRutinaid() {
        return objetivoRutinaid;
    }

    public void setObjetivoRutinaid(Integer objetivoRutinaid) {
        this.objetivoRutinaid = objetivoRutinaid;
    }

    public Integer getGrupoMuscularid() {
        return grupoMuscularid;
    }

    public void setGrupoMuscularid(Integer grupoMuscularid) {
        this.grupoMuscularid = grupoMuscularid;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }
}
