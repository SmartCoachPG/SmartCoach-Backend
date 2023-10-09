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

    
        @Column(name = "usuarioclienteusuarioid", nullable = true)
        private Integer usuarioClienteId;
    

    
        public PerfilMedico(int id, Date fecha, Integer usuarioClienteUsuarioid, Set<Valor> valores) {
            this.id = id;
            this.fecha = fecha;
            this.usuarioClienteId = usuarioClienteUsuarioid;
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

        public Integer getUsuarioClienteId() {
            return usuarioClienteId;
        }

        public void setUsuarioClienteId(Integer usuarioClienteId) {
            this.usuarioClienteId = usuarioClienteId;
        }
    }
