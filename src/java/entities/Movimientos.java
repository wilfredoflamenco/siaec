/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Entity
@Table(name = "movimientos")
@NamedQueries({
    @NamedQuery(name = "Movimientos.findAll", query = "SELECT m FROM Movimientos m"),
    @NamedQuery(name = "Movimientos.findByMovimientoId", query = "SELECT m FROM Movimientos m WHERE m.movimientoId = :movimientoId"),
    @NamedQuery(name = "Movimientos.findByMovimientoCantidad", query = "SELECT m FROM Movimientos m WHERE m.movimientoCantidad = :movimientoCantidad"),
    @NamedQuery(name = "Movimientos.findByMovimientoTipo", query = "SELECT m FROM Movimientos m WHERE m.movimientoTipo = :movimientoTipo"),
    @NamedQuery(name = "Movimientos.findByMovimientoFechaCreacion", query = "SELECT m FROM Movimientos m WHERE m.movimientoFechaCreacion = :movimientoFechaCreacion"),
    @NamedQuery(name = "Movimientos.findByMovimientoUsuarioCreacion", query = "SELECT m FROM Movimientos m WHERE m.movimientoUsuarioCreacion = :movimientoUsuarioCreacion")})
public class Movimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movimiento_id")
    private Integer movimientoId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "movimiento_cantidad")
    private Double movimientoCantidad;
    @Column(name = "movimiento_tipo")
    private Boolean movimientoTipo;
    @Column(name = "movimiento_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date movimientoFechaCreacion;
    @Size(max = 50)
    @Column(name = "movimiento_usuario_creacion")
    private String movimientoUsuarioCreacion;
    @JoinColumn(name = "existencia_id", referencedColumnName = "existencia_id")
    @ManyToOne(optional = false)
    private Existencias existenciaId;

    public Movimientos() {
    }

    public Movimientos(Integer movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Integer getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(Integer movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Double getMovimientoCantidad() {
        return movimientoCantidad;
    }

    public void setMovimientoCantidad(Double movimientoCantidad) {
        this.movimientoCantidad = movimientoCantidad;
    }

    public Boolean getMovimientoTipo() {
        return movimientoTipo;
    }

    public void setMovimientoTipo(Boolean movimientoTipo) {
        this.movimientoTipo = movimientoTipo;
    }

    public Date getMovimientoFechaCreacion() {
        return movimientoFechaCreacion;
    }

    public void setMovimientoFechaCreacion(Date movimientoFechaCreacion) {
        this.movimientoFechaCreacion = movimientoFechaCreacion;
    }

    public String getMovimientoUsuarioCreacion() {
        return movimientoUsuarioCreacion;
    }

    public void setMovimientoUsuarioCreacion(String movimientoUsuarioCreacion) {
        this.movimientoUsuarioCreacion = movimientoUsuarioCreacion;
    }

    public Existencias getExistenciaId() {
        return existenciaId;
    }

    public void setExistenciaId(Existencias existenciaId) {
        this.existenciaId = existenciaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movimientoId != null ? movimientoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientos)) {
            return false;
        }
        Movimientos other = (Movimientos) object;
        if ((this.movimientoId == null && other.movimientoId != null) || (this.movimientoId != null && !this.movimientoId.equals(other.movimientoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Movimientos[ movimientoId=" + movimientoId + " ]";
    }
    
}
