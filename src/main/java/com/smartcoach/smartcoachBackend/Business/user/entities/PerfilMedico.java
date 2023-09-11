package com.smartcoach.smartcoachBackend.Business.user.entities;

import com.smartcoach.smartcoachBackend.Persistence.user.PerfilMedicoRepository;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "perfilmedico")
public class PerfilMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    /*
    @ManyToOne
    @JoinColumn(name = "usuarioclienteusuarioid", nullable = true)
    private UsuarioCliente usuarioCliente;*/

    @Column(name = "usuarioclienteusuarioid", nullable = true)
    private Integer usuarioClienteUsuarioid;


    @OneToMany(mappedBy = "perfilMedico")
    private Set<Valor> valores;

    public PerfilMedico(int id, Date fecha, Integer usuarioClienteUsuarioid, Set<Valor> valores) {
        this.id = id;
        this.fecha = fecha;
        this.usuarioClienteUsuarioid = usuarioClienteUsuarioid;
        this.valores = valores;
    }

    public PerfilMedico()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Set<Valor> getValores() {
        return valores;
    }

    public void setValores(Set<Valor> valores) {
        this.valores = valores;
    }

    public Integer getUsuarioClienteUsuarioid() {
        return usuarioClienteUsuarioid;
    }

    public void setUsuarioClienteUsuarioid(Integer usuarioClienteUsuarioid) {
        this.usuarioClienteUsuarioid = usuarioClienteUsuarioid;
    }
}
