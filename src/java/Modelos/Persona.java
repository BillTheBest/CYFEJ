package Modelos;

import DAO.Despachos.Personas.PersonasDAO;
import DAO.Despachos.Personas.PersonasDAOimpl;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "Persona")
public class Persona implements java.io.Serializable {

    private Long idPersona;
    private String nombrePersona;
    private String primerApellido;
    private String segundoApellido;
    private String cedulaPersona;
    private String direccion;
    private int telefono;
    private int celular;
    private String email;
    private String observaciones;
    private List<PersonaTipoPersona> ptp =  new ArrayList<PersonaTipoPersona>();
    private PersonasDAO dao;

    public Persona() {
        dao = new PersonasDAOimpl();
    }

    public Persona(Long idPersona, String nombrePersona, String primerApellido, String segundoApellido, 
            String cedulaPersona, String direccion, int telefono, int celular, String email, String observaciones) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedulaPersona = cedulaPersona;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.observaciones = observaciones;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPersona", unique=true, nullable=false)
    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    @Column(name = "nombrePersona", unique=false, nullable = false, length = 50)
    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    @Column(name = "primerApellido", unique=false, nullable = false, length = 50)
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Column(name = "segundoApellido", unique=false, nullable = true, length = 50)
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Column(name = "cedulaPersona", unique=false, nullable = false, length = 20)
    public String getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    @Column(name = "direccion", unique=false, nullable = false, length = 256)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "telefono", unique=false, nullable = false)
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Column(name = "celular", unique=false, nullable = true)
    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Column(name = "email", unique=false, nullable = true, length = 200)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "observaciones", unique=false, nullable = true, length = 256)
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ids.persona", cascade=CascadeType.ALL)
    public List<PersonaTipoPersona> getPtp() {
        return ptp;
    }

    public void setPtp(List<PersonaTipoPersona> ptp) {
        this.ptp = ptp;
    }
   
//    public Set<PersonaTipoPersona> getPTP() {
//        return ptp;
//    }
//
//    public void setPTP(Set<PersonaTipoPersona> ptp) {
//        this.ptp = ptp;
//    }
    
    public List<Persona> listaPersonas(){
        return dao.findAllPersons();
    }
    
    public boolean GuardarPersona(Persona entidad, Long idTipoPersona, boolean activo){
        return dao.CreatePersons(entidad,idTipoPersona,activo);
    }
    
    public boolean actualizarPersona(Persona entidad, Long idTipoPersona, boolean activo){
        return  dao.UpdatePersons(entidad,idTipoPersona,activo);
    }
    
}