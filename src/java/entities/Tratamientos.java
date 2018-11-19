/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Entity
@Table(name = "tratamientos")
@NamedQueries({
    @NamedQuery(name = "Tratamientos.findAll", query = "SELECT t FROM Tratamientos t"),
    @NamedQuery(name = "Tratamientos.findByTratamientoId", query = "SELECT t FROM Tratamientos t WHERE t.tratamientoId = :tratamientoId"),
    @NamedQuery(name = "Tratamientos.findByTratamientoNombre", query = "SELECT t FROM Tratamientos t WHERE t.tratamientoNombre = :tratamientoNombre"),
    @NamedQuery(name = "Tratamientos.findByTratamientoDescripcion", query = "SELECT t FROM Tratamientos t WHERE t.tratamientoDescripcion = :tratamientoDescripcion"),
    @NamedQuery(name = "Tratamientos.findByTratamientoEstado", query = "SELECT t FROM Tratamientos t WHERE t.tratamientoEstado = :tratamientoEstado"),
    @NamedQuery(name = "Tratamientos.findByTratamientoFechaCreacion", query = "SELECT t FROM Tratamientos t WHERE t.tratamientoFechaCreacion = :tratamientoFechaCreacion"),
    @NamedQuery(name = "Tratamientos.findByTratamientoUsuarioCreacion", query = "SELECT t FROM Tratamientos t WHERE t.tratamientoUsuarioCreacion = :tratamientoUsuarioCreacion"),
    @NamedQuery(name = "Tratamientos.findByTratamientoFechaModificacion", query = "SELECT t FROM Tratamientos t WHERE t.tratamientoFechaModificacion = :tratamientoFechaModificacion"),
    @NamedQuery(name = "Tratamientos.findByTratamientoUsuarioModificacio", query = "SELECT t FROM Tratamientos t WHERE t.tratamientoUsuarioModificacio = :tratamientoUsuarioModificacio")})
public class Tratamientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tratamiento_id")
    private Integer tratamientoId;
    @Size(max = 100)
    @Column(name = "tratamiento_nombre")
    private String tratamientoNombre;
    @Size(max = 250)
    @Column(name = "tratamiento_descripcion")
    private String tratamientoDescripcion;
    @Column(name = "tratamiento_estado")
    private Boolean tratamientoEstado;
    @Column(name = "tratamiento_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date tratamientoFechaCreacion;
    @Size(max = 50)
    @Column(name = "tratamiento_usuario_creacion")
    private String tratamientoUsuarioCreacion;
    @Column(name = "tratamiento_fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date tratamientoFechaModificacion;
    @Size(max = 50)
    @Column(name = "tratamiento_usuario_modificacio")
    private String tratamientoUsuarioModificacio;
    @OneToMany(mappedBy = "tratamientoId")
    private List<DetallesConsultas> detallesConsultasList;

    public Tratamientos() {
    }

    public Tratamientos(Integer tratamientoId) {
        this.tratamientoId = tratamientoId;
    }

    public Integer getTratamientoId() {
        return tratamientoId;
    }

    public void setTratamientoId(Integer tratamientoId) {
        this.tratamientoId = tratamientoId;
    }

    public String getTratamientoNombre() {
        return tratamientoNombre;
    }

    public void setTratamientoNombre(String tratamientoNombre) {
        this.tratamientoNombre = tratamientoNombre;
    }

    public String getTratamientoDescripcion() {
        return tratamientoDescripcion;
    }

    public void setTratamientoDescripcion(String tratamientoDescripcion) {
        this.tratamientoDescripcion = tratamientoDescripcion;
    }

    public Boolean getTratamientoEstado() {
        return tratamientoEstado;
    }

    public void setTratamientoEstado(Boolean tratamientoEstado) {
        this.tratamientoEstado = tratamientoEstado;
    }

    public Date getTratamientoFechaCreacion() {
        return tratamientoFechaCreacion;
    }

    public void setTratamientoFechaCreacion(Date tratamientoFechaCreacion) {
        this.tratamientoFechaCreacion = tratamientoFechaCreacion;
    }

    public String getTratamientoUsuarioCreacion() {
        return tratamientoUsuarioCreacion;
    }

    public void setTratamientoUsuarioCreacion(String tratamientoUsuarioCreacion) {
        this.tratamientoUsuarioCreacion = tratamientoUsuarioCreacion;
    }

    public Date getTratamientoFechaModificacion() {
        return tratamientoFechaModificacion;
    }

    public void setTratamientoFechaModificacion(Date tratamientoFechaModificacion) {
        this.tratamientoFechaModificacion = tratamientoFechaModificacion;
    }

    public String getTratamientoUsuarioModificacio() {
        return tratamientoUsuarioModificacio;
    }

    public void setTratamientoUsuarioModificacio(String tratamientoUsuarioModificacio) {
        this.tratamientoUsuarioModificacio = tratamientoUsuarioModificacio;
    }

    public List<DetallesConsultas> getDetallesConsultasList() {
        return detallesConsultasList;
    }

    public void setDetallesConsultasList(List<DetallesConsultas> detallesConsultasList) {
        this.detallesConsultasList = detallesConsultasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tratamientoId != null ? tratamientoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamientos)) {
            return false;
        }
        Tratamientos other = (Tratamientos) object;
        if ((this.tratamientoId == null && other.tratamientoId != null) || (this.tratamientoId != null && !this.tratamientoId.equals(other.tratamientoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tratamientos[ tratamientoId=" + tratamientoId + " ]";
    }
    
}
