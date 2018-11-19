/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Entity
@Table(name = "tipos_insumos")
@NamedQueries({
    @NamedQuery(name = "TiposInsumos.findAll", query = "SELECT t FROM TiposInsumos t"),
    @NamedQuery(name = "TiposInsumos.findByTipoinsumoId", query = "SELECT t FROM TiposInsumos t WHERE t.tipoinsumoId = :tipoinsumoId"),
    @NamedQuery(name = "TiposInsumos.findByTipoinsumoNombre", query = "SELECT t FROM TiposInsumos t WHERE t.tipoinsumoNombre = :tipoinsumoNombre"),
    @NamedQuery(name = "TiposInsumos.findByTipoinsumoDescripcion", query = "SELECT t FROM TiposInsumos t WHERE t.tipoinsumoDescripcion = :tipoinsumoDescripcion"),
    @NamedQuery(name = "TiposInsumos.findByTipoinsumoEstado", query = "SELECT t FROM TiposInsumos t WHERE t.tipoinsumoEstado = :tipoinsumoEstado")})
public class TiposInsumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipoinsumo_id")
    private Integer tipoinsumoId;
    @Size(max = 50)
    @Column(name = "tipoinsumo_nombre")
    private String tipoinsumoNombre;
    @Size(max = 250)
    @Column(name = "tipoinsumo_descripcion")
    private String tipoinsumoDescripcion;
    @Column(name = "tipoinsumo_estado")
    private Boolean tipoinsumoEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoinsumoId")
    private List<Insumos> insumosList;

    public TiposInsumos() {
    }

    public TiposInsumos(Integer tipoinsumoId) {
        this.tipoinsumoId = tipoinsumoId;
    }

    public Integer getTipoinsumoId() {
        return tipoinsumoId;
    }

    public void setTipoinsumoId(Integer tipoinsumoId) {
        this.tipoinsumoId = tipoinsumoId;
    }

    public String getTipoinsumoNombre() {
        return tipoinsumoNombre;
    }

    public void setTipoinsumoNombre(String tipoinsumoNombre) {
        this.tipoinsumoNombre = tipoinsumoNombre;
    }

    public String getTipoinsumoDescripcion() {
        return tipoinsumoDescripcion;
    }

    public void setTipoinsumoDescripcion(String tipoinsumoDescripcion) {
        this.tipoinsumoDescripcion = tipoinsumoDescripcion;
    }

    public Boolean getTipoinsumoEstado() {
        return tipoinsumoEstado;
    }

    public void setTipoinsumoEstado(Boolean tipoinsumoEstado) {
        this.tipoinsumoEstado = tipoinsumoEstado;
    }

    public List<Insumos> getInsumosList() {
        return insumosList;
    }

    public void setInsumosList(List<Insumos> insumosList) {
        this.insumosList = insumosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoinsumoId != null ? tipoinsumoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposInsumos)) {
            return false;
        }
        TiposInsumos other = (TiposInsumos) object;
        if ((this.tipoinsumoId == null && other.tipoinsumoId != null) || (this.tipoinsumoId != null && !this.tipoinsumoId.equals(other.tipoinsumoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TiposInsumos[ tipoinsumoId=" + tipoinsumoId + " ]";
    }
    
}
