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
@Table(name = "bitacora")
@NamedQueries({
    @NamedQuery(name = "Bitacora.findAll", query = "SELECT b FROM Bitacora b"),
    @NamedQuery(name = "Bitacora.findByBitacoraId", query = "SELECT b FROM Bitacora b WHERE b.bitacoraId = :bitacoraId"),
    @NamedQuery(name = "Bitacora.findByBitacoraFechaHora", query = "SELECT b FROM Bitacora b WHERE b.bitacoraFechaHora = :bitacoraFechaHora"),
    @NamedQuery(name = "Bitacora.findByBitacoraUsuario", query = "SELECT b FROM Bitacora b WHERE b.bitacoraUsuario = :bitacoraUsuario"),
    @NamedQuery(name = "Bitacora.findByBitacoraTransaccion", query = "SELECT b FROM Bitacora b WHERE b.bitacoraTransaccion = :bitacoraTransaccion")})
public class Bitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bitacora_id")
    private Integer bitacoraId;
    @Column(name = "bitacora_fecha_hora")
    @Temporal(TemporalType.DATE)
    private Date bitacoraFechaHora;
    @Size(max = 50)
    @Column(name = "bitacora_usuario")
    private String bitacoraUsuario;
    @Size(max = 100)
    @Column(name = "bitacora_transaccion")
    private String bitacoraTransaccion;

    public Bitacora() {
    }

    public Bitacora(Integer bitacoraId) {
        this.bitacoraId = bitacoraId;
    }

    public Integer getBitacoraId() {
        return bitacoraId;
    }

    public void setBitacoraId(Integer bitacoraId) {
        this.bitacoraId = bitacoraId;
    }

    public Date getBitacoraFechaHora() {
        return bitacoraFechaHora;
    }

    public void setBitacoraFechaHora(Date bitacoraFechaHora) {
        this.bitacoraFechaHora = bitacoraFechaHora;
    }

    public String getBitacoraUsuario() {
        return bitacoraUsuario;
    }

    public void setBitacoraUsuario(String bitacoraUsuario) {
        this.bitacoraUsuario = bitacoraUsuario;
    }

    public String getBitacoraTransaccion() {
        return bitacoraTransaccion;
    }

    public void setBitacoraTransaccion(String bitacoraTransaccion) {
        this.bitacoraTransaccion = bitacoraTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bitacoraId != null ? bitacoraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacora)) {
            return false;
        }
        Bitacora other = (Bitacora) object;
        if ((this.bitacoraId == null && other.bitacoraId != null) || (this.bitacoraId != null && !this.bitacoraId.equals(other.bitacoraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bitacora[ bitacoraId=" + bitacoraId + " ]";
    }
    
}
