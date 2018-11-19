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
@Table(name = "unidades_medidas")
@NamedQueries({
    @NamedQuery(name = "UnidadesMedidas.findAll", query = "SELECT u FROM UnidadesMedidas u"),
    @NamedQuery(name = "UnidadesMedidas.findByUnidadmedidaId", query = "SELECT u FROM UnidadesMedidas u WHERE u.unidadmedidaId = :unidadmedidaId"),
    @NamedQuery(name = "UnidadesMedidas.findByUnidadmedidaNombre", query = "SELECT u FROM UnidadesMedidas u WHERE u.unidadmedidaNombre = :unidadmedidaNombre"),
    @NamedQuery(name = "UnidadesMedidas.findByUnidadmedidaAbreviatura", query = "SELECT u FROM UnidadesMedidas u WHERE u.unidadmedidaAbreviatura = :unidadmedidaAbreviatura"),
    @NamedQuery(name = "UnidadesMedidas.findByUnidadmedidaEstado", query = "SELECT u FROM UnidadesMedidas u WHERE u.unidadmedidaEstado = :unidadmedidaEstado")})
public class UnidadesMedidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unidadmedida_id")
    private Integer unidadmedidaId;
    @Size(max = 50)
    @Column(name = "unidadmedida_nombre")
    private String unidadmedidaNombre;
    @Size(max = 10)
    @Column(name = "unidadmedida_abreviatura")
    private String unidadmedidaAbreviatura;
    @Column(name = "unidadmedida_estado")
    private Boolean unidadmedidaEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadmedidaId")
    private List<Insumos> insumosList;

    public UnidadesMedidas() {
    }

    public UnidadesMedidas(Integer unidadmedidaId) {
        this.unidadmedidaId = unidadmedidaId;
    }

    public Integer getUnidadmedidaId() {
        return unidadmedidaId;
    }

    public void setUnidadmedidaId(Integer unidadmedidaId) {
        this.unidadmedidaId = unidadmedidaId;
    }

    public String getUnidadmedidaNombre() {
        return unidadmedidaNombre;
    }

    public void setUnidadmedidaNombre(String unidadmedidaNombre) {
        this.unidadmedidaNombre = unidadmedidaNombre;
    }

    public String getUnidadmedidaAbreviatura() {
        return unidadmedidaAbreviatura;
    }

    public void setUnidadmedidaAbreviatura(String unidadmedidaAbreviatura) {
        this.unidadmedidaAbreviatura = unidadmedidaAbreviatura;
    }

    public Boolean getUnidadmedidaEstado() {
        return unidadmedidaEstado;
    }

    public void setUnidadmedidaEstado(Boolean unidadmedidaEstado) {
        this.unidadmedidaEstado = unidadmedidaEstado;
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
        hash += (unidadmedidaId != null ? unidadmedidaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadesMedidas)) {
            return false;
        }
        UnidadesMedidas other = (UnidadesMedidas) object;
        if ((this.unidadmedidaId == null && other.unidadmedidaId != null) || (this.unidadmedidaId != null && !this.unidadmedidaId.equals(other.unidadmedidaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UnidadesMedidas[ unidadmedidaId=" + unidadmedidaId + " ]";
    }
    
}
