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
@Table(name = "detalles_consultas")
@NamedQueries({
    @NamedQuery(name = "DetallesConsultas.findAll", query = "SELECT d FROM DetallesConsultas d"),
    @NamedQuery(name = "DetallesConsultas.findByDetalleconsultaId", query = "SELECT d FROM DetallesConsultas d WHERE d.detalleconsultaId = :detalleconsultaId"),
    @NamedQuery(name = "DetallesConsultas.findByDetalleconsultaPieza", query = "SELECT d FROM DetallesConsultas d WHERE d.detalleconsultaPieza = :detalleconsultaPieza"),
    @NamedQuery(name = "DetallesConsultas.findByDetalleconsultaTratamiento", query = "SELECT d FROM DetallesConsultas d WHERE d.detalleconsultaTratamiento = :detalleconsultaTratamiento"),
    @NamedQuery(name = "DetallesConsultas.findByDetalleconsultaCargo", query = "SELECT d FROM DetallesConsultas d WHERE d.detalleconsultaCargo = :detalleconsultaCargo"),
    @NamedQuery(name = "DetallesConsultas.findByDetalleconsultaAbono", query = "SELECT d FROM DetallesConsultas d WHERE d.detalleconsultaAbono = :detalleconsultaAbono"),
    @NamedQuery(name = "DetallesConsultas.findByDetalleconsultaFechaCreacion", query = "SELECT d FROM DetallesConsultas d WHERE d.detalleconsultaFechaCreacion = :detalleconsultaFechaCreacion"),
    @NamedQuery(name = "DetallesConsultas.findByDetalleconsultaUsuarioCreacio", query = "SELECT d FROM DetallesConsultas d WHERE d.detalleconsultaUsuarioCreacio = :detalleconsultaUsuarioCreacio"),
    
    @NamedQuery(name = "DetallesConsultas.findByDetalleconsultaPorPaciente", query = "SELECT d FROM DetallesConsultas d WHERE d.pacienteId.pacienteId = :pacienteId"),
    
    /*@NamedQuery(name = "DetallesConsultas.findByDetalleconsultaPorPiezaOclusal", query = "SELECT d FROM DetallesConsultas d WHERE d.consultaId.pacienteId.pacienteId = :pacienteId and d.piezaId.piezaCodigo = :pieza and d.detalleconsultaOclusal != 0 ORDER BY d.detalleconsultaId ASC"),
    @NamedQuery(name = "DetallesConsultas.findByDetalleconsultaPorPiezaVestibular", query = "SELECT d FROM DetallesConsultas d WHERE d.consultaId.pacienteId.pacienteId = :pacienteId and d.piezaId.piezaCodigo = :pieza and d.detalleconsultaVestibular != 0 ORDER BY d.detalleconsultaId ASC"),
    @NamedQuery(name = "DetallesConsultas.findByDetalleconsultaPorPiezaPalatina", query = "SELECT d FROM DetallesConsultas d WHERE d.consultaId.pacienteId.pacienteId = :pacienteId and d.piezaId.piezaCodigo = :pieza and d.detalleconsultaPalatina != 0 ORDER BY d.detalleconsultaId ASC"),
    @NamedQuery(name = "DetallesConsultas.findByDetalleconsultaPorPiezaMesial", query = "SELECT d FROM DetallesConsultas d WHERE d.consultaId.pacienteId.pacienteId = :pacienteId and d.piezaId.piezaCodigo = :pieza and d.detalleconsultaMesial != 0 ORDER BY d.detalleconsultaId ASC"),
    @NamedQuery(name = "DetallesConsultas.findByDetalleconsultaPorPiezaDistal", query = "SELECT d FROM DetallesConsultas d WHERE d.consultaId.pacienteId.pacienteId = :pacienteId and d.piezaId.piezaCodigo = :pieza and d.detalleconsultaDistal != 0 ORDER BY d.detalleconsultaId ASC")*/})
public class DetallesConsultas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "detalleconsulta_id")
    private Integer detalleconsultaId;
    @Size(max = 200)
    @Column(name = "detalleconsulta_pieza")
    private String detalleconsultaPieza;
    @Size(max = 1000)
    @Column(name = "detalleconsulta_tratamiento")
    private String detalleconsultaTratamiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "detalleconsulta_cargo")
    private Double detalleconsultaCargo;
    @Column(name = "detalleconsulta_abono")
    private Double detalleconsultaAbono;
    @Column(name = "detalleconsulta_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date detalleconsultaFechaCreacion;
    @Size(max = 50)
    @Column(name = "detalleconsulta_usuario_creacio")
    private String detalleconsultaUsuarioCreacio;
    @JoinColumn(name = "tratamiento_id", referencedColumnName = "tratamiento_id")
    @ManyToOne
    private Tratamientos tratamientoId;
    @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
    @ManyToOne
    private Pacientes pacienteId;

    public DetallesConsultas() {
    }

    public DetallesConsultas(Integer detalleconsultaId) {
        this.detalleconsultaId = detalleconsultaId;
    }

    public Integer getDetalleconsultaId() {
        return detalleconsultaId;
    }

    public void setDetalleconsultaId(Integer detalleconsultaId) {
        this.detalleconsultaId = detalleconsultaId;
    }

    public String getDetalleconsultaPieza() {
        return detalleconsultaPieza;
    }

    public void setDetalleconsultaPieza(String detalleconsultaPieza) {
        this.detalleconsultaPieza = detalleconsultaPieza;
    }

    public String getDetalleconsultaTratamiento() {
        return detalleconsultaTratamiento;
    }

    public void setDetalleconsultaTratamiento(String detalleconsultaTratamiento) {
        this.detalleconsultaTratamiento = detalleconsultaTratamiento;
    }

    public Double getDetalleconsultaCargo() {
        return detalleconsultaCargo;
    }

    public void setDetalleconsultaCargo(Double detalleconsultaCargo) {
        this.detalleconsultaCargo = detalleconsultaCargo;
    }

    public Double getDetalleconsultaAbono() {
        return detalleconsultaAbono;
    }

    public void setDetalleconsultaAbono(Double detalleconsultaAbono) {
        this.detalleconsultaAbono = detalleconsultaAbono;
    }

    public Date getDetalleconsultaFechaCreacion() {
        return detalleconsultaFechaCreacion;
    }

    public void setDetalleconsultaFechaCreacion(Date detalleconsultaFechaCreacion) {
        this.detalleconsultaFechaCreacion = detalleconsultaFechaCreacion;
    }

    public String getDetalleconsultaUsuarioCreacio() {
        return detalleconsultaUsuarioCreacio;
    }

    public void setDetalleconsultaUsuarioCreacio(String detalleconsultaUsuarioCreacio) {
        this.detalleconsultaUsuarioCreacio = detalleconsultaUsuarioCreacio;
    }

    public Tratamientos getTratamientoId() {
        return tratamientoId;
    }

    public void setTratamientoId(Tratamientos tratamientoId) {
        this.tratamientoId = tratamientoId;
    }

    public Pacientes getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Pacientes pacienteId) {
        this.pacienteId = pacienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleconsultaId != null ? detalleconsultaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesConsultas)) {
            return false;
        }
        DetallesConsultas other = (DetallesConsultas) object;
        if ((this.detalleconsultaId == null && other.detalleconsultaId != null) || (this.detalleconsultaId != null && !this.detalleconsultaId.equals(other.detalleconsultaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetallesConsultas[ detalleconsultaId=" + detalleconsultaId + " ]";
    }
    
}
