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
@Table(name = "consultas")
@NamedQueries({
    @NamedQuery(name = "Consultas.findAll", query = "SELECT c FROM Consultas c"),
    @NamedQuery(name = "Consultas.findByConsultaId", query = "SELECT c FROM Consultas c WHERE c.consultaId = :consultaId"),
    @NamedQuery(name = "Consultas.findByConsultaMotivo", query = "SELECT c FROM Consultas c WHERE c.consultaMotivo = :consultaMotivo"),
    @NamedQuery(name = "Consultas.findByConsultaDiagnostico", query = "SELECT c FROM Consultas c WHERE c.consultaDiagnostico = :consultaDiagnostico"),
    @NamedQuery(name = "Consultas.findByConsultaReceta", query = "SELECT c FROM Consultas c WHERE c.consultaReceta = :consultaReceta"),
    @NamedQuery(name = "Consultas.findByConsultaNota", query = "SELECT c FROM Consultas c WHERE c.consultaNota = :consultaNota"),
    @NamedQuery(name = "Consultas.findByConsultaFechaCreacion", query = "SELECT c FROM Consultas c WHERE c.consultaFechaCreacion = :consultaFechaCreacion"),
    @NamedQuery(name = "Consultas.findByConsultaUsuarioCreacion", query = "SELECT c FROM Consultas c WHERE c.consultaUsuarioCreacion = :consultaUsuarioCreacion"),
    @NamedQuery(name = "Consultas.findByConsultaFechaModificacion", query = "SELECT c FROM Consultas c WHERE c.consultaFechaModificacion = :consultaFechaModificacion"),
    @NamedQuery(name = "Consultas.findByConsultaUsuarioModificacion", query = "SELECT c FROM Consultas c WHERE c.consultaUsuarioModificacion = :consultaUsuarioModificacion"),

    @NamedQuery(name = "Consultas.findByConsultasPorPaciente", query = "SELECT c FROM Consultas c WHERE c.pacienteId.pacienteId = :pacienteId")})
public class Consultas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consulta_id")
    private Integer consultaId;
    @Size(max = 200)
    @Column(name = "consulta_motivo")
    private String consultaMotivo;
    @Size(max = 1000)
    @Column(name = "consulta_diagnostico")
    private String consultaDiagnostico;
    @Size(max = 500)
    @Column(name = "consulta_receta")
    private String consultaReceta;
    @Size(max = 1000)
    @Column(name = "consulta_nota")
    private String consultaNota;
    @Column(name = "consulta_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date consultaFechaCreacion;
    @Size(max = 50)
    @Column(name = "consulta_usuario_creacion")
    private String consultaUsuarioCreacion;
    @Column(name = "consulta_fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date consultaFechaModificacion;
    @Size(max = 50)
    @Column(name = "consulta_usuario_modificacion")
    private String consultaUsuarioModificacion;
    @JoinColumn(name = "promocion_id", referencedColumnName = "promocion_id")
    @ManyToOne
    private Promociones promocionId;
    @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
    @ManyToOne(optional = false)
    private Pacientes pacienteId;
    @JoinColumn(name = "medico_id", referencedColumnName = "medico_id")
    @ManyToOne(optional = false)
    private Medicos medicoId;

    public Consultas() {
    }

    public Consultas(Integer consultaId) {
        this.consultaId = consultaId;
    }

    public Integer getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Integer consultaId) {
        this.consultaId = consultaId;
    }

    public String getConsultaMotivo() {
        return consultaMotivo;
    }

    public void setConsultaMotivo(String consultaMotivo) {
        this.consultaMotivo = consultaMotivo;
    }

    public String getConsultaDiagnostico() {
        return consultaDiagnostico;
    }

    public void setConsultaDiagnostico(String consultaDiagnostico) {
        this.consultaDiagnostico = consultaDiagnostico;
    }

    public String getConsultaReceta() {
        return consultaReceta;
    }

    public void setConsultaReceta(String consultaReceta) {
        this.consultaReceta = consultaReceta;
    }

    public String getConsultaNota() {
        return consultaNota;
    }

    public void setConsultaNota(String consultaNota) {
        this.consultaNota = consultaNota;
    }

    public Date getConsultaFechaCreacion() {
        return consultaFechaCreacion;
    }

    public void setConsultaFechaCreacion(Date consultaFechaCreacion) {
        this.consultaFechaCreacion = consultaFechaCreacion;
    }

    public String getConsultaUsuarioCreacion() {
        return consultaUsuarioCreacion;
    }

    public void setConsultaUsuarioCreacion(String consultaUsuarioCreacion) {
        this.consultaUsuarioCreacion = consultaUsuarioCreacion;
    }

    public Date getConsultaFechaModificacion() {
        return consultaFechaModificacion;
    }

    public void setConsultaFechaModificacion(Date consultaFechaModificacion) {
        this.consultaFechaModificacion = consultaFechaModificacion;
    }

    public String getConsultaUsuarioModificacion() {
        return consultaUsuarioModificacion;
    }

    public void setConsultaUsuarioModificacion(String consultaUsuarioModificacion) {
        this.consultaUsuarioModificacion = consultaUsuarioModificacion;
    }

    public Promociones getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(Promociones promocionId) {
        this.promocionId = promocionId;
    }

    public Pacientes getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Pacientes pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Medicos getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Medicos medicoId) {
        this.medicoId = medicoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultaId != null ? consultaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultas)) {
            return false;
        }
        Consultas other = (Consultas) object;
        if ((this.consultaId == null && other.consultaId != null) || (this.consultaId != null && !this.consultaId.equals(other.consultaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Consultas[ consultaId=" + consultaId + " ]";
    }
    
}
