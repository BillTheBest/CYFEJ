package Modelos;
// Generated 09-09-2013 12:06:13 AM by Hibernate Tools 3.2.1.GA

import DAO.Despachos.Expedientes.ExpedientesDAO;
import DAO.Despachos.Expedientes.ExpedientesDAOimpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Expediente generated by hbm2java
 */
@Entity
@Table(name = "expediente")
public class Expediente implements java.io.Serializable {

    private Long idExpediente;
    private String descripcion;
    private Date fechaAlta;
    private Date fechaBaja;
    private int anio;
    private Asuntojuzgado asuntojuzgados = new Asuntojuzgado();
    private List<Estadoevolutivo> estadoevolutivo = new ArrayList<Estadoevolutivo>();
    private List<Detallesexpediente> detallesExpedientes = new ArrayList<Detallesexpediente>();
    private Usuarios usuarios;
    private ExpedientesDAO dao;

    public Expediente() {
        dao = new ExpedientesDAOimpl();
    }

    public Expediente(String descripcion, Date fechaAlta, Date fechaBaja, int anio) {
        this.descripcion = descripcion;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.anio = anio;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idExpediente", unique = true, nullable = false)
    public Long getIdExpediente() {
        return this.idExpediente;
    }

    public void setIdExpediente(Long idExpediente) {
        this.idExpediente = idExpediente;
    }

    @Column(name = "Descripcion", nullable = false, length = 500)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaAlta", nullable = false, length = 10)
    public Date getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaBaja", nullable = false, length = 10)
    public Date getFechaBaja() {
        return this.fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Column(name = "Anio", nullable = false)
    public int getAnio() {
        return this.anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "expediente")
    public List<Estadoevolutivo> getEstadoevolutivo() {
        return estadoevolutivo;
    }

    public void setEstadoevolutivo(List<Estadoevolutivo> estadoevolutivo) {
        this.estadoevolutivo = estadoevolutivo;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "expediente")
    public List<Detallesexpediente> getDetallesExpedientes() {
        return detallesExpedientes;
    }

    public void setDetallesExpedientes(List<Detallesexpediente> detallesExpedientes) {
        this.detallesExpedientes = detallesExpedientes;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuarios", nullable = false)
    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public List<Expediente> listaExpedientes() {
        return dao.findAllExpedientes();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "idAsuntoJudicial", referencedColumnName = "idAsuntoJudicial", nullable = false),
        @JoinColumn(name = "idJuzgados", referencedColumnName = "idJuzgados", nullable = false)})
    public Asuntojuzgado getAsuntojuzgados() {
        return asuntojuzgados;
    }

    public void setAsuntojuzgados(Asuntojuzgado asuntojuzgados) {
        this.asuntojuzgados = asuntojuzgados;
    }

    public boolean GuardarExpediente(Expediente entidad) {
        return dao.Crearexpediente(entidad);
    }
}
