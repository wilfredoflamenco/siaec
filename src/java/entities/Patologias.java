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
import javax.persistence.ManyToMany;
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
@Table(name = "patologias")
@NamedQueries({
    @NamedQuery(name = "Patologias.findAll", query = "SELECT p FROM Patologias p"),
    @NamedQuery(name = "Patologias.findByPatologiaId", query = "SELECT p FROM Patologias p WHERE p.patologiaId = :patologiaId"),
    @NamedQuery(name = "Patologias.findByPatologiaNombre", query = "SELECT p FROM Patologias p WHERE p.patologiaNombre = :patologiaNombre"),
    @NamedQuery(name = "Patologias.findByPatologiaEstado", query = "SELECT p FROM Patologias p WHERE p.patologiaEstado = :patologiaEstado"),
    @NamedQuery(name = "Patologias.findByPatologiaFechaCreacion", query = "SELECT p FROM Patologias p WHERE p.patologiaFechaCreacion = :patologiaFechaCreacion"),
    @NamedQuery(name = "Patologias.findByPatologiaUsuarioCreacion", query = "SELECT p FROM Patologias p WHERE p.patologiaUsuarioCreacion = :patologiaUsuarioCreacion"),
    @NamedQuery(name = "Patologias.findByPatologiaFechaModificacion", query = "SELECT p FROM Patologias p WHERE p.patologiaFechaModificacion = :patologiaFechaModificacion"),
    @NamedQuery(name = "Patologias.findByPatologiaUsuarioModificacio", query = "SELECT p FROM Patologias p WHERE p.patologiaUsuarioModificacio = :patologiaUsuarioModificacio")})
public class Patologias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patologia_id")
    private Integer patologiaId;
    @Size(max = 50)
    @Column(name = "patologia_nombre")
    private String patologiaNombre;
    @Column(name = "patologia_estado")
    private Boolean patologiaEstado;
    @Column(name = "patologia_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date patologiaFechaCreacion;
    @Size(max = 50)
    @Column(name = "patologia_usuario_creacion")
    private String patologiaUsuarioCreacion;
    @Column(name = "patologia_fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date patologiaFechaModificacion;
    @Size(max = 50)
    @Column(name = "patologia_usuario_modificacio")
    private String patologiaUsuarioModificacio;
    @ManyToMany(mappedBy = "patologiasList")
    private List<Pacientes> pacientesList;

    public Patologias() {
    }

    public Patologias(Integer patologiaId) {
        this.patologiaId = patologiaId;
    }

    public Integer getPatologiaId() {
        return patologiaId;
    }

    public void setPatologiaId(Integer patologiaId) {
        this.patologiaId = patologiaId;
    }

    public String getPatologiaNombre() {
        return patologiaNombre;
    }

    public void setPatologiaNombre(String patologiaNombre) {
        this.patologiaNombre = patologiaNombre;
    }

    public Boolean getPatologiaEstado() {
        return patologiaEstado;
    }

    public void setPatologiaEstado(Boolean patologiaEstado) {
        this.patologiaEstado = patologiaEstado;
    }

    public Date getPatologiaFechaCreacion() {
        return patologiaFechaCreacion;
    }

    public void setPatologiaFechaCreacion(Date patologiaFechaCreacion) {
        this.patologiaFechaCreacion = patologiaFechaCreacion;
    }

    public String getPatologiaUsuarioCreacion() {
        return patologiaUsuarioCreacion;
    }

    public void setPatologiaUsuarioCreacion(String patologiaUsuarioCreacion) {
        this.patologiaUsuarioCreacion = patologiaUsuarioCreacion;
    }

    public Date getPatologiaFechaModificacion() {
        return patologiaFechaModificacion;
    }

    public void setPatologiaFechaModificacion(Date patologiaFechaModificacion) {
        this.patologiaFechaModificacion = patologiaFechaModificacion;
    }

    public String getPatologiaUsuarioModificacio() {
        return patologiaUsuarioModificacio;
    }

    public void setPatologiaUsuarioModificacio(String patologiaUsuarioModificacio) {
        this.patologiaUsuarioModificacio = patologiaUsuarioModificacio;
    }

    public List<Pacientes> getPacientesList() {
        return pacientesList;
    }

    public void setPacientesList(List<Pacientes> pacientesList) {
        this.pacientesList = pacientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patologiaId != null ? patologiaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patologias)) {
            return false;
        }
        Patologias other = (Patologias) object;
        if ((this.patologiaId == null && other.patologiaId != null) || (this.patologiaId != null && !this.patologiaId.equals(other.patologiaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Patologias[ patologiaId=" + patologiaId + " ]";
    }
    
}
