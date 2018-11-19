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
@Table(name = "citas")
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c"),
    @NamedQuery(name = "Citas.findByCitaId", query = "SELECT c FROM Citas c WHERE c.citaId = :citaId"),
    @NamedQuery(name = "Citas.findByCitaFecha", query = "SELECT c FROM Citas c WHERE c.citaFecha = :citaFecha"),
    @NamedQuery(name = "Citas.findByCitaHora", query = "SELECT c FROM Citas c WHERE c.citaHora = :citaHora"),
    @NamedQuery(name = "Citas.findByCitaNombres", query = "SELECT c FROM Citas c WHERE c.citaNombres = :citaNombres"),
    @NamedQuery(name = "Citas.findByCitaApellidos", query = "SELECT c FROM Citas c WHERE c.citaApellidos = :citaApellidos"),
    @NamedQuery(name = "Citas.findByCitaTelefono", query = "SELECT c FROM Citas c WHERE c.citaTelefono = :citaTelefono"),
    @NamedQuery(name = "Citas.findByCitaCorreo", query = "SELECT c FROM Citas c WHERE c.citaCorreo = :citaCorreo"),
    @NamedQuery(name = "Citas.findByCitaMotivo", query = "SELECT c FROM Citas c WHERE c.citaMotivo = :citaMotivo"),
    @NamedQuery(name = "Citas.findByCitaFechaCreacion", query = "SELECT c FROM Citas c WHERE c.citaFechaCreacion = :citaFechaCreacion"),
    @NamedQuery(name = "Citas.findByCitaHoraCreacion", query = "SELECT c FROM Citas c WHERE c.citaHoraCreacion = :citaHoraCreacion"),
    @NamedQuery(name = "Citas.findByCitaEstado", query = "SELECT c FROM Citas c WHERE c.citaEstado = :citaEstado"),
    @NamedQuery(name = "Citas.findByCitaUsuarioCreacion", query = "SELECT c FROM Citas c WHERE c.citaUsuarioCreacion = :citaUsuarioCreacion"),
    @NamedQuery(name = "Citas.findByCitaFechaModificacion", query = "SELECT c FROM Citas c WHERE c.citaFechaModificacion = :citaFechaModificacion"),
    @NamedQuery(name = "Citas.findByCitaUsuarioModificacion", query = "SELECT c FROM Citas c WHERE c.citaUsuarioModificacion = :citaUsuarioModificacion"),

    @NamedQuery(name = "Citas.findByCitasTotalEstado", query = "SELECT c FROM Citas c WHERE c.citaEstado = :idEstado"),
    @NamedQuery(name = "Citas.findByCitasMesEstado", query = "SELECT c FROM Citas c WHERE c.citaFecha > :fecha_inferior AND c.citaFecha < :fecha_superior "),
    @NamedQuery(name = "Citas.findByCitaAtendidaPorSucursal", query = "SELECT c FROM Citas c WHERE c.clinicaId.clinicaId = :idClinica AND c.citaEstado = :idEstado"),
    @NamedQuery(name = "Citas.programasFechaActual", query = "SELECT c FROM Citas c WHERE c.citaFecha >= :fecha_cita AND ( c.citaEstado = 1 OR c.citaEstado = 2) ORDER BY c.citaFecha ASC"),

    @NamedQuery(name = "Citas.reservadasClinica", query = "SELECT c FROM Citas c WHERE c.clinicaId.clinicaId = :clinica_id AND c.citaFecha = :fecha_cita AND c.citaHora = :citaHora  AND ( c.citaEstado = 1 OR c.citaEstado = 2)")
})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cita_id")
    private Integer citaId;
    @Column(name = "cita_fecha")
    @Temporal(TemporalType.DATE)
    private Date citaFecha;
    @Column(name = "cita_hora")
    @Temporal(TemporalType.TIME)
    private Date citaHora;
    @Size(max = 50)
    @Column(name = "cita_nombres")
    private String citaNombres;
    @Size(max = 50)
    @Column(name = "cita_apellidos")
    private String citaApellidos;
    @Size(max = 10)
    @Column(name = "cita_telefono")
    private String citaTelefono;
    @Size(max = 50)
    @Column(name = "cita_correo")
    private String citaCorreo;
    @Size(max = 250)
    @Column(name = "cita_motivo")
    private String citaMotivo;
    @Column(name = "cita_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date citaFechaCreacion;
    @Column(name = "cita_hora_creacion")
    @Temporal(TemporalType.TIME)
    private Date citaHoraCreacion;
    @Column(name = "cita_estado")
    private Integer citaEstado;
    @Size(max = 50)
    @Column(name = "cita_usuario_creacion")
    private String citaUsuarioCreacion;
    @Column(name = "cita_fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date citaFechaModificacion;
    @Size(max = 50)
    @Column(name = "cita_usuario_modificacion")
    private String citaUsuarioModificacion;
    @JoinColumn(name = "usuario_usuario", referencedColumnName = "usuario_usuario")
    @ManyToOne
    private Usuarios usuarioUsuario;
    @JoinColumn(name = "medico_id", referencedColumnName = "medico_id")
    @ManyToOne
    private Medicos medicoId;
    @JoinColumn(name = "clinica_id", referencedColumnName = "clinica_id")
    @ManyToOne(optional = false)
    private Clinicas clinicaId;

    public Citas() {
    }

    public Citas(Integer citaId) {
        this.citaId = citaId;
    }

    public Integer getCitaId() {
        return citaId;
    }

    public void setCitaId(Integer citaId) {
        this.citaId = citaId;
    }

    public Date getCitaFecha() {
        return citaFecha;
    }

    public void setCitaFecha(Date citaFecha) {
        this.citaFecha = citaFecha;
    }

    public Date getCitaHora() {
        return citaHora;
    }

    public void setCitaHora(Date citaHora) {
        this.citaHora = citaHora;
    }

    public String getCitaNombres() {
        return citaNombres;
    }

    public void setCitaNombres(String citaNombres) {
        this.citaNombres = citaNombres;
    }

    public String getCitaApellidos() {
        return citaApellidos;
    }

    public void setCitaApellidos(String citaApellidos) {
        this.citaApellidos = citaApellidos;
    }

    public String getCitaTelefono() {
        return citaTelefono;
    }

    public void setCitaTelefono(String citaTelefono) {
        this.citaTelefono = citaTelefono;
    }

    public String getCitaCorreo() {
        return citaCorreo;
    }

    public void setCitaCorreo(String citaCorreo) {
        this.citaCorreo = citaCorreo;
    }

    public String getCitaMotivo() {
        return citaMotivo;
    }

    public void setCitaMotivo(String citaMotivo) {
        this.citaMotivo = citaMotivo;
    }

    public Date getCitaFechaCreacion() {
        return citaFechaCreacion;
    }

    public void setCitaFechaCreacion(Date citaFechaCreacion) {
        this.citaFechaCreacion = citaFechaCreacion;
    }

    public Date getCitaHoraCreacion() {
        return citaHoraCreacion;
    }

    public void setCitaHoraCreacion(Date citaHoraCreacion) {
        this.citaHoraCreacion = citaHoraCreacion;
    }

    public Integer getCitaEstado() {
        return citaEstado;
    }

    public void setCitaEstado(Integer citaEstado) {
        this.citaEstado = citaEstado;
    }

    public String getCitaUsuarioCreacion() {
        return citaUsuarioCreacion;
    }

    public void setCitaUsuarioCreacion(String citaUsuarioCreacion) {
        this.citaUsuarioCreacion = citaUsuarioCreacion;
    }

    public Date getCitaFechaModificacion() {
        return citaFechaModificacion;
    }

    public void setCitaFechaModificacion(Date citaFechaModificacion) {
        this.citaFechaModificacion = citaFechaModificacion;
    }

    public String getCitaUsuarioModificacion() {
        return citaUsuarioModificacion;
    }

    public void setCitaUsuarioModificacion(String citaUsuarioModificacion) {
        this.citaUsuarioModificacion = citaUsuarioModificacion;
    }

    public Usuarios getUsuarioUsuario() {
        return usuarioUsuario;
    }

    public void setUsuarioUsuario(Usuarios usuarioUsuario) {
        this.usuarioUsuario = usuarioUsuario;
    }

    public Medicos getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Medicos medicoId) {
        this.medicoId = medicoId;
    }

    public Clinicas getClinicaId() {
        return clinicaId;
    }

    public void setClinicaId(Clinicas clinicaId) {
        this.clinicaId = clinicaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citaId != null ? citaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.citaId == null && other.citaId != null) || (this.citaId != null && !this.citaId.equals(other.citaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Citas[ citaId=" + citaId + " ]";
    }
    
}
