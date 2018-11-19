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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "municipios")
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m"),
    @NamedQuery(name = "Municipios.findByMunicipioId", query = "SELECT m FROM Municipios m WHERE m.municipioId = :municipioId"),
    @NamedQuery(name = "Municipios.findByMunicipioNombre", query = "SELECT m FROM Municipios m WHERE m.municipioNombre = :municipioNombre"),

    @NamedQuery(name = "Municipios.findByMunicipioByDepartamento", query = "SELECT m FROM Municipios m WHERE m.departamentoId.departamentoId = :departamentoId")})
public class Municipios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "municipio_id")
    private Integer municipioId;
    @Size(max = 50)
    @Column(name = "municipio_nombre")
    private String municipioNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioId")
    private List<Direcciones> direccionesList;
    @JoinColumn(name = "departamento_id", referencedColumnName = "departamento_id")
    @ManyToOne(optional = false)
    private Departamentos departamentoId;

    public Municipios() {
    }

    public Municipios(Integer municipioId) {
        this.municipioId = municipioId;
    }

    public Integer getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Integer municipioId) {
        this.municipioId = municipioId;
    }

    public String getMunicipioNombre() {
        return municipioNombre;
    }

    public void setMunicipioNombre(String municipioNombre) {
        this.municipioNombre = municipioNombre;
    }

    public List<Direcciones> getDireccionesList() {
        return direccionesList;
    }

    public void setDireccionesList(List<Direcciones> direccionesList) {
        this.direccionesList = direccionesList;
    }

    public Departamentos getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Departamentos departamentoId) {
        this.departamentoId = departamentoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipioId != null ? municipioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.municipioId == null && other.municipioId != null) || (this.municipioId != null && !this.municipioId.equals(other.municipioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Municipios[ municipioId=" + municipioId + " ]";
    }
    
}
