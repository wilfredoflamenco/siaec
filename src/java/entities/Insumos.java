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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "insumos")
@NamedQueries({
    @NamedQuery(name = "Insumos.findAll", query = "SELECT i FROM Insumos i"),
    @NamedQuery(name = "Insumos.findByInsumoId", query = "SELECT i FROM Insumos i WHERE i.insumoId = :insumoId"),
    @NamedQuery(name = "Insumos.findByInsumoNombre", query = "SELECT i FROM Insumos i WHERE i.insumoNombre = :insumoNombre"),
    @NamedQuery(name = "Insumos.findByInsumoDescripcion", query = "SELECT i FROM Insumos i WHERE i.insumoDescripcion = :insumoDescripcion"),
    @NamedQuery(name = "Insumos.findByInsumoMinimo", query = "SELECT i FROM Insumos i WHERE i.insumoMinimo = :insumoMinimo"),
    @NamedQuery(name = "Insumos.findByInsumoEstado", query = "SELECT i FROM Insumos i WHERE i.insumoEstado = :insumoEstado"),
    @NamedQuery(name = "Insumos.findByInsumoFechaCreacion", query = "SELECT i FROM Insumos i WHERE i.insumoFechaCreacion = :insumoFechaCreacion"),
    @NamedQuery(name = "Insumos.findByInsumoUsuarioCreacion", query = "SELECT i FROM Insumos i WHERE i.insumoUsuarioCreacion = :insumoUsuarioCreacion"),
    @NamedQuery(name = "Insumos.findByInsumoFechaModificacion", query = "SELECT i FROM Insumos i WHERE i.insumoFechaModificacion = :insumoFechaModificacion"),
    @NamedQuery(name = "Insumos.findByInsumoUsuarioModificacion", query = "SELECT i FROM Insumos i WHERE i.insumoUsuarioModificacion = :insumoUsuarioModificacion")})
public class Insumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "insumo_id")
    private Integer insumoId;
    @Size(max = 50)
    @Column(name = "insumo_nombre")
    private String insumoNombre;
    @Size(max = 250)
    @Column(name = "insumo_descripcion")
    private String insumoDescripcion;
    @Column(name = "insumo_minimo")
    private Integer insumoMinimo;
    @Column(name = "insumo_estado")
    private Boolean insumoEstado;
    @Column(name = "insumo_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date insumoFechaCreacion;
    @Size(max = 50)
    @Column(name = "insumo_usuario_creacion")
    private String insumoUsuarioCreacion;
    @Column(name = "insumo_fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date insumoFechaModificacion;
    @Size(max = 50)
    @Column(name = "insumo_usuario_modificacion")
    private String insumoUsuarioModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumoId")
    private List<Existencias> existenciasList;
    @JoinColumn(name = "unidadmedida_id", referencedColumnName = "unidadmedida_id")
    @ManyToOne(optional = false)
    private UnidadesMedidas unidadmedidaId;
    @JoinColumn(name = "tipoinsumo_id", referencedColumnName = "tipoinsumo_id")
    @ManyToOne(optional = false)
    private TiposInsumos tipoinsumoId;

    public Insumos() {
    }

    public Insumos(Integer insumoId) {
        this.insumoId = insumoId;
    }

    public Integer getInsumoId() {
        return insumoId;
    }

    public void setInsumoId(Integer insumoId) {
        this.insumoId = insumoId;
    }

    public String getInsumoNombre() {
        return insumoNombre;
    }

    public void setInsumoNombre(String insumoNombre) {
        this.insumoNombre = insumoNombre;
    }

    public String getInsumoDescripcion() {
        return insumoDescripcion;
    }

    public void setInsumoDescripcion(String insumoDescripcion) {
        this.insumoDescripcion = insumoDescripcion;
    }

    public Integer getInsumoMinimo() {
        return insumoMinimo;
    }

    public void setInsumoMinimo(Integer insumoMinimo) {
        this.insumoMinimo = insumoMinimo;
    }

    public Boolean getInsumoEstado() {
        return insumoEstado;
    }

    public void setInsumoEstado(Boolean insumoEstado) {
        this.insumoEstado = insumoEstado;
    }

    public Date getInsumoFechaCreacion() {
        return insumoFechaCreacion;
    }

    public void setInsumoFechaCreacion(Date insumoFechaCreacion) {
        this.insumoFechaCreacion = insumoFechaCreacion;
    }

    public String getInsumoUsuarioCreacion() {
        return insumoUsuarioCreacion;
    }

    public void setInsumoUsuarioCreacion(String insumoUsuarioCreacion) {
        this.insumoUsuarioCreacion = insumoUsuarioCreacion;
    }

    public Date getInsumoFechaModificacion() {
        return insumoFechaModificacion;
    }

    public void setInsumoFechaModificacion(Date insumoFechaModificacion) {
        this.insumoFechaModificacion = insumoFechaModificacion;
    }

    public String getInsumoUsuarioModificacion() {
        return insumoUsuarioModificacion;
    }

    public void setInsumoUsuarioModificacion(String insumoUsuarioModificacion) {
        this.insumoUsuarioModificacion = insumoUsuarioModificacion;
    }

    public List<Existencias> getExistenciasList() {
        return existenciasList;
    }

    public void setExistenciasList(List<Existencias> existenciasList) {
        this.existenciasList = existenciasList;
    }

    public UnidadesMedidas getUnidadmedidaId() {
        return unidadmedidaId;
    }

    public void setUnidadmedidaId(UnidadesMedidas unidadmedidaId) {
        this.unidadmedidaId = unidadmedidaId;
    }

    public TiposInsumos getTipoinsumoId() {
        return tipoinsumoId;
    }

    public void setTipoinsumoId(TiposInsumos tipoinsumoId) {
        this.tipoinsumoId = tipoinsumoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insumoId != null ? insumoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumos)) {
            return false;
        }
        Insumos other = (Insumos) object;
        if ((this.insumoId == null && other.insumoId != null) || (this.insumoId != null && !this.insumoId.equals(other.insumoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Insumos[ insumoId=" + insumoId + " ]";
    }
    
}
