package com.smartcoach.smartcoachBackend.Business.user.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "objetivorutinaid", nullable = false, insertable = false, updatable = false)
    private ObjetivoRutina objetivoRutina;

    @ManyToOne
    @JoinColumn(name = "nivelactividadfisicaid", referencedColumnName = "id",insertable = false, updatable = false)
    private NivelActividadFisica nivelActividadFisica;

    public UsuarioCliente() {
    }

    public UsuarioCliente(String genero, Date fechaDeNacimiento, Integer gimnasioid, Integer nivelActividadFisicaid, Integer objetivoRutinaid, ObjetivoRutina objetivoRutina, NivelActividadFisica nivelActividadFisica) {
        this.genero = genero;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.gimnasioid = gimnasioid;
        this.nivelActividadFisicaid = nivelActividadFisicaid;
        this.objetivoRutinaid = objetivoRutinaid;
        this.objetivoRutina = objetivoRutina;
        this.nivelActividadFisica = nivelActividadFisica;
    }

    public UsuarioCliente(String nombre, String email, String contrasenna, byte[] fotoPerfil, Integer admi, String genero, Date fechaDeNacimiento, Integer gimnasioid, Integer nivelActividadFisicaid, Integer objetivoRutinaid, ObjetivoRutina objetivoRutina, NivelActividadFisica nivelActividadFisica) {
        super(nombre, email, contrasenna, fotoPerfil, admi);
        this.genero = genero;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.gimnasioid = gimnasioid;
        this.nivelActividadFisicaid = nivelActividadFisicaid;
        this.objetivoRutinaid = objetivoRutinaid;
        this.objetivoRutina = objetivoRutina;
        this.nivelActividadFisica = nivelActividadFisica;
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

    public ObjetivoRutina getObjetivoRutina() {
        return objetivoRutina;
    }

    public void setObjetivoRutina(ObjetivoRutina objetivoRutina) {
        this.objetivoRutina = objetivoRutina;
    }

    public NivelActividadFisica getNivelActividadFisica() {
        return nivelActividadFisica;
    }

    public void setNivelActividadFisica(NivelActividadFisica nivelActividadFisica) {
        this.nivelActividadFisica = nivelActividadFisica;
    }
}
