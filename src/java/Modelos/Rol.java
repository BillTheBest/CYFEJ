package Modelos;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
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
    private Set<Usuarios> usuario = new HashSet<Usuarios>(0);

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
    public Set<Usuarios> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Usuarios> usuario) {
        this.usuario = usuario;
    }
    
}