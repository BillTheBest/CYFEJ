package Modelos;

import DAO.Despachos.Personas.TipoPersonasDAO;
import DAO.Despachos.Personas.TipoPersonasDAOimpl;
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
@Table(name = "TipoPersona")
public class TipoPersona implements java.io.Serializable{

    private Long idTipoPersona;
    private String descripcion;
    private List<PersonaTipoPersona> ptp = new ArrayList<PersonaTipoPersona>();
    private TipoPersonasDAO dao;

    public TipoPersona() {
        dao = new TipoPersonasDAOimpl();
    }

    public TipoPersona(Long idTipoPersona, String descripcion) {
        this.idTipoPersona = idTipoPersona;
        this.descripcion = descripcion;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTipoPersona", unique=true, nullable=false)
    public Long getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Long idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }
    
    @Column(name = "descripcion", nullable = false, length = 50)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ids.tipoPersona")
    public List<PersonaTipoPersona> getPtp() {
        return ptp;
    }

    public void setPtp(List<PersonaTipoPersona> ptp) {
        this.ptp = ptp;
    }
    
    public List<TipoPersona> listaTipoPersona(){
        return dao.findAllTipoPersonas();
    }

    public TipoPersona findByID(Long id){
        return dao.findbyID(id);
    }
    
}