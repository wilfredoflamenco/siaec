/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Entity
@Table(name = "direcciones")
@NamedQueries({
    @NamedQuery(name = "Direcciones.findAll", query = "SELECT d FROM Direcciones d"),
    @NamedQuery(name = "Direcciones.findByDireccionId", query = "SELECT d FROM Direcciones d WHERE d.direccionId = :direccionId"),
    @NamedQuery(name = "Direcciones.findByDireccionColonia", query = "SELECT d FROM Direcciones d WHERE d.direccionColonia = :direccionColonia"),
    @NamedQuery(name = "Direcciones.findByDireccionCalle", query = "SELECT d FROM Direcciones d WHERE d.direccionCalle = :direccionCalle"),
    @NamedQuery(name = "Direcciones.findByDireccionCasa", query = "SELECT d FROM Direcciones d WHERE d.direccionCasa = :direccionCasa"),
    @NamedQuery(name = "Direcciones.findByDireccionPasaje", query = "SELECT d FROM Direcciones d WHERE d.direccionPasaje = :direccionPasaje"),
    @NamedQuery(name = "Direcciones.findByDireccionPoligono", query = "SELECT d FROM Direcciones d WHERE d.direccionPoligono = :direccionPoligono"),
    @NamedQuery(name = "Direcciones.findByDireccionApartamento", query = "SELECT d FROM Direcciones d WHERE d.direccionApartamento = :direccionApartamento"),

    @NamedQuery(name = "Direcciones.findByDireccionPorSucursal", query = "SELECT d FROM Direcciones d WHERE d.clinicaId.clinicaId = :sucursalId"),
    @NamedQuery(name = "Direcciones.findByDireccionPorMedico", query = "SELECT d FROM Direcciones d WHERE d.medicoId.medicoId = :medicoId"),
    @NamedQuery(name = "Direcciones.findByDireccionPorPaciente", query = "SELECT d FROM Direcciones d WHERE d.pacienteId.pacienteId = :pacienteId"),
    @NamedQuery(name = "Direcciones.findByPacienteDireccion", query = "SELECT d FROM Direcciones d WHERE d.pacienteId.pacienteId = :pacienteId")})
public class Direcciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "direccion_id")
    private Integer direccionId;
    @Size(max = 50)
    @Column(name = "direccion_colonia")
    private String direccionColonia;
    @Size(max = 50)
    @Column(name = "direccion_calle")
    private String direccionCalle;
    @Size(max = 10)
    @Column(name = "direccion_casa")
    private String direccionCasa;
    @Size(max = 50)
    @Column(name = "direccion_pasaje")
    private String direccionPasaje;
    @Size(max = 50)
    @Column(name = "direccion_poligono")
    private String direccionPoligono;
    @Size(max = 50)
    @Column(name = "direccion_apartamento")
    private String direccionApartamento;
    @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
    @ManyToOne
    private Pacientes pacienteId;
    @JoinColumn(name = "municipio_id", referencedColumnName = "municipio_id")
    @ManyToOne(optional = false)
    private Municipios municipioId;
    @JoinColumn(name = "medico_id", referencedColumnName = "medico_id")
    @ManyToOne
    private Medicos medicoId;
    @JoinColumn(name = "clinica_id", referencedColumnName = "clinica_id")
    @ManyToOne
    private Clinicas clinicaId;

    public Direcciones() {
    }

    public Direcciones(Integer direccionId) {
        this.direccionId = direccionId;
    }

    public Integer getDireccionId() {
        return direccionId;
    }

    public void setDireccionId(Integer direccionId) {
        this.direccionId = direccionId;
    }

    public String getDireccionColonia() {
        return direccionColonia;
    }

    public void setDireccionColonia(String direccionColonia) {
        this.direccionColonia = direccionColonia;
    }

    public String getDireccionCalle() {
        return direccionCalle;
    }

    public void setDireccionCalle(String direccionCalle) {
        this.direccionCalle = direccionCalle;
    }

    public String getDireccionCasa() {
        return direccionCasa;
    }

    public void setDireccionCasa(String direccionCasa) {
        this.direccionCasa = direccionCasa;
    }

    public String getDireccionPasaje() {
        return direccionPasaje;
    }

    public void setDireccionPasaje(String direccionPasaje) {
        this.direccionPasaje = direccionPasaje;
    }

    public String getDireccionPoligono() {
        return direccionPoligono;
    }

    public void setDireccionPoligono(String direccionPoligono) {
        this.direccionPoligono = direccionPoligono;
    }

    public String getDireccionApartamento() {
        return direccionApartamento;
    }

    public void setDireccionApartamento(String direccionApartamento) {
        this.direccionApartamento = direccionApartamento;
    }

    public Pacientes getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Pacientes pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Municipios getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipios municipioId) {
        this.municipioId = municipioId;
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
        hash += (direccionId != null ? direccionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcciones)) {
            return false;
        }
        Direcciones other = (Direcciones) object;
        if ((this.direccionId == null && other.direccionId != null) || (this.direccionId != null && !this.direccionId.equals(other.direccionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Direcciones[ direccionId=" + direccionId + " ]";
    }
    
}
