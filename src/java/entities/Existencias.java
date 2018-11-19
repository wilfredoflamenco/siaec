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

/**
 *
 * @author Fam. Gomez Aldana
 */
@Entity
@Table(name = "existencias")
@NamedQueries({
    @NamedQuery(name = "Existencias.findAll", query = "SELECT e FROM Existencias e"),
    @NamedQuery(name = "Existencias.findByExistenciaId", query = "SELECT e FROM Existencias e WHERE e.existenciaId = :existenciaId"),
    @NamedQuery(name = "Existencias.findByExistenciaCantidad", query = "SELECT e FROM Existencias e WHERE e.existenciaCantidad = :existenciaCantidad"),
        
    @NamedQuery(name = "Existencias.findByExistenciaPorInsumo", query = "SELECT e FROM Existencias e WHERE e.clinicaId.clinicaId = :sucursalId AND e.insumoId.insumoId = :insumoId"),
    @NamedQuery(name = "Existencias.findByExistenciaPorMinimo", query = "SELECT e FROM Existencias e WHERE e.existenciaCantidad <= e.insumoId.insumoMinimo"),
    @NamedQuery(name = "Existencias.findByExistenciaAgotada", query = "SELECT e FROM Existencias e WHERE e.existenciaCantidad = :agotado"),
    @NamedQuery(name = "Existencias.findByExistenciaPorAgotarse", query = "SELECT e FROM Existencias e WHERE e.existenciaCantidad <= e.insumoId.insumoMinimo AND e.existenciaCantidad > :agotado")})
public class Existencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "existencia_id")
    private Integer existenciaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "existencia_cantidad")
    private Double existenciaCantidad;
    @JoinColumn(name = "insumo_id", referencedColumnName = "insumo_id")
    @ManyToOne(optional = false)
    private Insumos insumoId;
    @JoinColumn(name = "clinica_id", referencedColumnName = "clinica_id")
    @ManyToOne(optional = false)
    private Clinicas clinicaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "existenciaId")
    private List<Movimientos> movimientosList;

    public Existencias() {
    }

    public Existencias(Integer existenciaId) {
        this.existenciaId = existenciaId;
    }

    public Integer getExistenciaId() {
        return existenciaId;
    }

    public void setExistenciaId(Integer existenciaId) {
        this.existenciaId = existenciaId;
    }

    public Double getExistenciaCantidad() {
        return existenciaCantidad;
    }

    public void setExistenciaCantidad(Double existenciaCantidad) {
        this.existenciaCantidad = existenciaCantidad;
    }

    public Insumos getInsumoId() {
        return insumoId;
    }

    public void setInsumoId(Insumos insumoId) {
        this.insumoId = insumoId;
    }

    public Clinicas getClinicaId() {
        return clinicaId;
    }

    public void setClinicaId(Clinicas clinicaId) {
        this.clinicaId = clinicaId;
    }

    public List<Movimientos> getMovimientosList() {
        return movimientosList;
    }

    public void setMovimientosList(List<Movimientos> movimientosList) {
        this.movimientosList = movimientosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (existenciaId != null ? existenciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Existencias)) {
            return false;
        }
        Existencias other = (Existencias) object;
        if ((this.existenciaId == null && other.existenciaId != null) || (this.existenciaId != null && !this.existenciaId.equals(other.existenciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Existencias[ existenciaId=" + existenciaId + " ]";
    }
    
}
