package Entidades;
// Generated 09-09-2013 12:06:13 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Expediente generated by hbm2java
 */
@Entity
@Table(name="expediente"
    ,catalog="despachoabogados"
)
public class Expediente  implements java.io.Serializable {


     private Integer idExpediente;
     private String descripcion;
     private Date fechaAlta;
     private Date fechaBaja;
     private int anio;
     private int idAsuntoJudicial;
     private int idJuzgados;
     private int idUsuarios;
     private Set estadoexpedientes = new HashSet(0);

    public Expediente() {
    }

	
    public Expediente(String descripcion, Date fechaAlta, Date fechaBaja, int anio, int idAsuntoJudicial, int idJuzgados, int idUsuarios) {
        this.descripcion = descripcion;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.anio = anio;
        this.idAsuntoJudicial = idAsuntoJudicial;
        this.idJuzgados = idJuzgados;
        this.idUsuarios = idUsuarios;
    }
    public Expediente(String descripcion, Date fechaAlta, Date fechaBaja, int anio, int idAsuntoJudicial, int idJuzgados, int idUsuarios, Set estadoexpedientes) {
       this.descripcion = descripcion;
       this.fechaAlta = fechaAlta;
       this.fechaBaja = fechaBaja;
       this.anio = anio;
       this.idAsuntoJudicial = idAsuntoJudicial;
       this.idJuzgados = idJuzgados;
       this.idUsuarios = idUsuarios;
       this.estadoexpedientes = estadoexpedientes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="idExpediente", unique=true, nullable=false)
    public Integer getIdExpediente() {
        return this.idExpediente;
    }
    
    public void setIdExpediente(Integer idExpediente) {
        this.idExpediente = idExpediente;
    }
    
    @Column(name="Descripcion", nullable=false, length=500)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="fechaAlta", nullable=false, length=10)
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="fechaBaja", nullable=false, length=10)
    public Date getFechaBaja() {
        return this.fechaBaja;
    }
    
    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    
    @Column(name="Anio", nullable=false)
    public int getAnio() {
        return this.anio;
    }
    
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    @Column(name="idAsuntoJudicial", nullable=false)
    public int getIdAsuntoJudicial() {
        return this.idAsuntoJudicial;
    }
    
    public void setIdAsuntoJudicial(int idAsuntoJudicial) {
        this.idAsuntoJudicial = idAsuntoJudicial;
    }
    
    @Column(name="idJuzgados", nullable=false)
    public int getIdJuzgados() {
        return this.idJuzgados;
    }
    
    public void setIdJuzgados(int idJuzgados) {
        this.idJuzgados = idJuzgados;
    }
    
    @Column(name="idUsuarios", nullable=false)
    public int getIdUsuarios() {
        return this.idUsuarios;
    }
    
    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="expediente")
    public Set getEstadoexpedientes() {
        return this.estadoexpedientes;
    }
    
    public void setEstadoexpedientes(Set estadoexpedientes) {
        this.estadoexpedientes = estadoexpedientes;
    }




}


