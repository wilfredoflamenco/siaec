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
@Table(name = "clinicas")
@NamedQueries({
    @NamedQuery(name = "Clinicas.findAll", query = "SELECT c FROM Clinicas c"),
    @NamedQuery(name = "Clinicas.findByClinicaId", query = "SELECT c FROM Clinicas c WHERE c.clinicaId = :clinicaId"),
    @NamedQuery(name = "Clinicas.findByClinicaNombre", query = "SELECT c FROM Clinicas c WHERE c.clinicaNombre = :clinicaNombre"),
    @NamedQuery(name = "Clinicas.findByClinicaCorreo", query = "SELECT c FROM Clinicas c WHERE c.clinicaCorreo = :clinicaCorreo"),
    @NamedQuery(name = "Clinicas.findByClinicaTelefonoFijo", query = "SELECT c FROM Clinicas c WHERE c.clinicaTelefonoFijo = :clinicaTelefonoFijo"),
    @NamedQuery(name = "Clinicas.findByClinicaTelefonoMovil", query = "SELECT c FROM Clinicas c WHERE c.clinicaTelefonoMovil = :clinicaTelefonoMovil"),
    @NamedQuery(name = "Clinicas.findByClinicaModulo", query = "SELECT c FROM Clinicas c WHERE c.clinicaModulo = :clinicaModulo"),
    @NamedQuery(name = "Clinicas.findByClinicaHorarioApertura", query = "SELECT c FROM Clinicas c WHERE c.clinicaHorarioApertura = :clinicaHorarioApertura"),
    @NamedQuery(name = "Clinicas.findByClinicaHorarioCierre", query = "SELECT c FROM Clinicas c WHERE c.clinicaHorarioCierre = :clinicaHorarioCierre"),
    @NamedQuery(name = "Clinicas.findByClinicaEstado", query = "SELECT c FROM Clinicas c WHERE c.clinicaEstado = :clinicaEstado"),
    @NamedQuery(name = "Clinicas.findByClinicaFechaCreacion", query = "SELECT c FROM Clinicas c WHERE c.clinicaFechaCreacion = :clinicaFechaCreacion"),
    @NamedQuery(name = "Clinicas.findByClinicaUsuarioCreacion", query = "SELECT c FROM Clinicas c WHERE c.clinicaUsuarioCreacion = :clinicaUsuarioCreacion"),
    @NamedQuery(name = "Clinicas.findByClinicaFechaModificacion", query = "SELECT c FROM Clinicas c WHERE c.clinicaFechaModificacion = :clinicaFechaModificacion"),
    @NamedQuery(name = "Clinicas.findByClinicaUsuarioModificacion", query = "SELECT c FROM Clinicas c WHERE c.clinicaUsuarioModificacion = :clinicaUsuarioModificacion")})
public class Clinicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clinica_id")
    private Integer clinicaId;
    @Size(max = 50)
    @Column(name = "clinica_nombre")
    private String clinicaNombre;
    @Size(max = 50)
    @Column(name = "clinica_correo")
    private String clinicaCorreo;
    @Size(max = 10)
    @Column(name = "clinica_telefono_fijo")
    private String clinicaTelefonoFijo;
    @Size(max = 10)
    @Column(name = "clinica_telefono_movil")
    private String clinicaTelefonoMovil;
    @Column(name = "clinica_modulo")
    private Integer clinicaModulo;
    @Column(name = "clinica_horario_apertura")
    @Temporal(TemporalType.TIME)
    private Date clinicaHorarioApertura;
    @Column(name = "clinica_horario_cierre")
    @Temporal(TemporalType.TIME)
    private Date clinicaHorarioCierre;
    @Column(name = "clinica_estado")
    private Boolean clinicaEstado;
    @Column(name = "clinica_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date clinicaFechaCreacion;
    @Size(max = 50)
    @Column(name = "clinica_usuario_creacion")
    private String clinicaUsuarioCreacion;
    @Column(name = "clinica_fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date clinicaFechaModificacion;
    @Size(max = 50)
    @Column(name = "clinica_usuario_modificacion")
    private String clinicaUsuarioModificacion;
    @OneToMany(mappedBy = "clinicaId")
    private List<Direcciones> direccionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinicaId")
    private List<Existencias> existenciasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinicaId")
    private List<Citas> citasList;

    public Clinicas() {
    }

    public Clinicas(Integer clinicaId) {
        this.clinicaId = clinicaId;
    }

    public Integer getClinicaId() {
        return clinicaId;
    }

    public void setClinicaId(Integer clinicaId) {
        this.clinicaId = clinicaId;
    }

    public String getClinicaNombre() {
        return clinicaNombre;
    }

    public void setClinicaNombre(String clinicaNombre) {
        this.clinicaNombre = clinicaNombre;
    }

    public String getClinicaCorreo() {
        return clinicaCorreo;
    }

    public void setClinicaCorreo(String clinicaCorreo) {
        this.clinicaCorreo = clinicaCorreo;
    }

    public String getClinicaTelefonoFijo() {
        return clinicaTelefonoFijo;
    }

    public void setClinicaTelefonoFijo(String clinicaTelefonoFijo) {
        this.clinicaTelefonoFijo = clinicaTelefonoFijo;
    }

    public String getClinicaTelefonoMovil() {
        return clinicaTelefonoMovil;
    }

    public void setClinicaTelefonoMovil(String clinicaTelefonoMovil) {
        this.clinicaTelefonoMovil = clinicaTelefonoMovil;
    }

    public Integer getClinicaModulo() {
        return clinicaModulo;
    }

    public void setClinicaModulo(Integer clinicaModulo) {
        this.clinicaModulo = clinicaModulo;
    }

    public Date getClinicaHorarioApertura() {
        return clinicaHorarioApertura;
    }

    public void setClinicaHorarioApertura(Date clinicaHorarioApertura) {
        this.clinicaHorarioApertura = clinicaHorarioApertura;
    }

    public Date getClinicaHorarioCierre() {
        return clinicaHorarioCierre;
    }

    public void setClinicaHorarioCierre(Date clinicaHorarioCierre) {
        this.clinicaHorarioCierre = clinicaHorarioCierre;
    }

    public Boolean getClinicaEstado() {
        return clinicaEstado;
    }

    public void setClinicaEstado(Boolean clinicaEstado) {
        this.clinicaEstado = clinicaEstado;
    }

    public Date getClinicaFechaCreacion() {
        return clinicaFechaCreacion;
    }

    public void setClinicaFechaCreacion(Date clinicaFechaCreacion) {
        this.clinicaFechaCreacion = clinicaFechaCreacion;
    }

    public String getClinicaUsuarioCreacion() {
        return clinicaUsuarioCreacion;
    }

    public void setClinicaUsuarioCreacion(String clinicaUsuarioCreacion) {
        this.clinicaUsuarioCreacion = clinicaUsuarioCreacion;
    }

    public Date getClinicaFechaModificacion() {
        return clinicaFechaModificacion;
    }

    public void setClinicaFechaModificacion(Date clinicaFechaModificacion) {
        this.clinicaFechaModificacion = clinicaFechaModificacion;
    }

    public String getClinicaUsuarioModificacion() {
        return clinicaUsuarioModificacion;
    }

    public void setClinicaUsuarioModificacion(String clinicaUsuarioModificacion) {
        this.clinicaUsuarioModificacion = clinicaUsuarioModificacion;
    }

    public List<Direcciones> getDireccionesList() {
        return direccionesList;
    }

    public void setDireccionesList(List<Direcciones> direccionesList) {
        this.direccionesList = direccionesList;
    }

    public List<Existencias> getExistenciasList() {
        return existenciasList;
    }

    public void setExistenciasList(List<Existencias> existenciasList) {
        this.existenciasList = existenciasList;
    }

    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clinicaId != null ? clinicaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clinicas)) {
            return false;
        }
        Clinicas other = (Clinicas) object;
        if ((this.clinicaId == null && other.clinicaId != null) || (this.clinicaId != null && !this.clinicaId.equals(other.clinicaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Clinicas[ clinicaId=" + clinicaId + " ]";
    }
    
}
