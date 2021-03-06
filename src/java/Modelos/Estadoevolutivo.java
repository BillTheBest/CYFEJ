package Modelos;
// Generated 09-06-2013 07:53:46 PM by Hibernate Tools 3.2.1.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Estadoevolutivo generated by hbm2java
 */
@Entity
@Table(name = "estadoevolutivo")
public class Estadoevolutivo implements java.io.Serializable {

    private Long idEstado;
    private Usuarios usuarios;
    private Expediente expediente;
    private Tipoaviso tipoaviso;
    private Date fechaCreacion;
    private Date fechaCita;
    private String descripcion;
    private Date fechaAviso;
    private Date horaCita;
    private Date horaAviso;
    private String documento;

    public Estadoevolutivo() {
    }

    public Estadoevolutivo(Usuarios usuarios, Tipoaviso tipoaviso, Date fechaCreacion, Date fechaCita, String descripcion, Date fechaAviso, Date horaCita, Date horaAviso) {
        this.usuarios = usuarios;
        this.tipoaviso = tipoaviso;
        this.fechaCreacion = fechaCreacion;
        this.fechaCita = fechaCita;
        this.descripcion = descripcion;
        this.fechaAviso = fechaAviso;
        this.horaCita = horaCita;
        this.horaAviso = horaAviso;
    }

    public Estadoevolutivo(Usuarios usuarios, Expediente expediente, Tipoaviso tipoaviso, Date fechaCreacion, Date fechaCita, String descripcion, Date fechaAviso, Date horaCita, Date horaAviso, String documento) {
        this.usuarios = usuarios;
        this.expediente = expediente;
        this.tipoaviso = tipoaviso;
        this.fechaCreacion = fechaCreacion;
        this.fechaCita = fechaCita;
        this.descripcion = descripcion;
        this.fechaAviso = fechaAviso;
        this.horaCita = horaCita;
        this.horaAviso = horaAviso;
        this.documento = documento;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idEstado", unique = true, nullable = false)
    public Long getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuarios", nullable = false)
    public Usuarios getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idExpediente", nullable = true)
    public Expediente getExpediente() {
        return this.expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoAviso", nullable = false)
    public Tipoaviso getTipoaviso() {
        return this.tipoaviso;
    }

    public void setTipoaviso(Tipoaviso tipoaviso) {
        this.tipoaviso = tipoaviso;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaCreacion", nullable = false, length = 10)
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaCita", nullable = false, length = 10)
    public Date getFechaCita() {
        return this.fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    @Column(name = "Descripcion", nullable = false, length = 500)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaAviso", nullable = false, length = 10)
    public Date getFechaAviso() {
        return this.fechaAviso;
    }

    public void setFechaAviso(Date fechaAviso) {
        this.fechaAviso = fechaAviso;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "horaCita", nullable = false, length = 19)
    public Date getHoraCita() {
        return this.horaCita;
    }

    public void setHoraCita(Date horaCita) {
        this.horaCita = horaCita;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "horaAviso", nullable = false, length = 19)
    public Date getHoraAviso() {
        return this.horaAviso;
    }

    public void setHoraAviso(Date horaAviso) {
        this.horaAviso = horaAviso;
    }

    @Column(name = "Documento", length = 100)
    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}