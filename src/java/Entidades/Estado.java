package Entidades;
// Generated 09-09-2013 12:06:13 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Estado generated by hbm2java
 */
@Entity
@Table(name="estado"
    ,catalog="despachoabogados"
)
public class Estado  implements java.io.Serializable {


     private Integer idEstado;
     private String descripcion;
     private Set estadoexpedientes = new HashSet(0);

    public Estado() {
    }

	
    public Estado(String descripcion) {
        this.descripcion = descripcion;
    }
    public Estado(String descripcion, Set estadoexpedientes) {
       this.descripcion = descripcion;
       this.estadoexpedientes = estadoexpedientes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="idEstado", unique=true, nullable=false)
    public Integer getIdEstado() {
        return this.idEstado;
    }
    
    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }
    
    @Column(name="Descripcion", nullable=false, length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="estado")
    public Set getEstadoexpedientes() {
        return this.estadoexpedientes;
    }
    
    public void setEstadoexpedientes(Set estadoexpedientes) {
        this.estadoexpedientes = estadoexpedientes;
    }




}


