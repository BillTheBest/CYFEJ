package Modelos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class Rol implements java.io.Serializable{

    
    private Long idRol;
    private String nombreRol;
    private List<Usuarios> usuario = new ArrayList<Usuarios>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idRol", unique=true, nullable=false)
    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    
    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @OneToMany(fetch= FetchType.LAZY, mappedBy="roles")
    public List<Usuarios> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuarios> usuario) {
        this.usuario = usuario;
    }
    
}