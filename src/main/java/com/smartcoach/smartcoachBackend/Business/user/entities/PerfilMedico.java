package com.smartcoach.smartcoachBackend.Business.user.entities;

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

    @ManyToOne
    @JoinColumn(name = "usuarioclienteusuarioid", nullable = true)
    private UsuarioCliente usuarioCliente;

    @OneToMany(mappedBy = "perfilMedico")
    private Set<Valor> valores;

    // ... (getters y setters)
}
