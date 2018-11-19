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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "pacientes")
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findByPacienteId", query = "SELECT p FROM Pacientes p WHERE p.pacienteId = :pacienteId"),
    @NamedQuery(name = "Pacientes.findByPacienteExpediente", query = "SELECT p FROM Pacientes p WHERE p.pacienteExpediente = :pacienteExpediente"),
    @NamedQuery(name = "Pacientes.findByPacientePrimerNombre", query = "SELECT p FROM Pacientes p WHERE p.pacientePrimerNombre = :pacientePrimerNombre"),
    @NamedQuery(name = "Pacientes.findByPacienteSegundoNombre", query = "SELECT p FROM Pacientes p WHERE p.pacienteSegundoNombre = :pacienteSegundoNombre"),
    @NamedQuery(name = "Pacientes.findByPacientePrimerApellido", query = "SELECT p FROM Pacientes p WHERE p.pacientePrimerApellido = :pacientePrimerApellido"),
    @NamedQuery(name = "Pacientes.findByPacienteSegundoApellido", query = "SELECT p FROM Pacientes p WHERE p.pacienteSegundoApellido = :pacienteSegundoApellido"),
    @NamedQuery(name = "Pacientes.findByPacienteFechaNacimiento", query = "SELECT p FROM Pacientes p WHERE p.pacienteFechaNacimiento = :pacienteFechaNacimiento"),
    @NamedQuery(name = "Pacientes.findByPacienteSexo", query = "SELECT p FROM Pacientes p WHERE p.pacienteSexo = :pacienteSexo"),
    @NamedQuery(name = "Pacientes.findByPacienteCorreo", query = "SELECT p FROM Pacientes p WHERE p.pacienteCorreo = :pacienteCorreo"),
    @NamedQuery(name = "Pacientes.findByPacienteTrabajo", query = "SELECT p FROM Pacientes p WHERE p.pacienteTrabajo = :pacienteTrabajo"),
    @NamedQuery(name = "Pacientes.findByPacienteTelefonoCasa", query = "SELECT p FROM Pacientes p WHERE p.pacienteTelefonoCasa = :pacienteTelefonoCasa"),
    @NamedQuery(name = "Pacientes.findByPacienteTelefonoMovil", query = "SELECT p FROM Pacientes p WHERE p.pacienteTelefonoMovil = :pacienteTelefonoMovil"),
    @NamedQuery(name = "Pacientes.findByPacienteTelefonoOficina", query = "SELECT p FROM Pacientes p WHERE p.pacienteTelefonoOficina = :pacienteTelefonoOficina"),
    @NamedQuery(name = "Pacientes.findByPacienteWhatsapp", query = "SELECT p FROM Pacientes p WHERE p.pacienteWhatsapp = :pacienteWhatsapp"),
    @NamedQuery(name = "Pacientes.findByPacienteEstado", query = "SELECT p FROM Pacientes p WHERE p.pacienteEstado = :pacienteEstado"),
    @NamedQuery(name = "Pacientes.findByPacienteAntecedentes", query = "SELECT p FROM Pacientes p WHERE p.pacienteAntecedentes = :pacienteAntecedentes"),
    @NamedQuery(name = "Pacientes.findByPacienteRecordatorio", query = "SELECT p FROM Pacientes p WHERE p.pacienteRecordatorio = :pacienteRecordatorio"),
    @NamedQuery(name = "Pacientes.findByPacienteFechaSeguimiento", query = "SELECT p FROM Pacientes p WHERE p.pacienteFechaSeguimiento = :pacienteFechaSeguimiento"),
    @NamedQuery(name = "Pacientes.findByPacienteResponsable", query = "SELECT p FROM Pacientes p WHERE p.pacienteResponsable = :pacienteResponsable"),
    @NamedQuery(name = "Pacientes.findByPacienteFechaCreacion", query = "SELECT p FROM Pacientes p WHERE p.pacienteFechaCreacion = :pacienteFechaCreacion"),
    @NamedQuery(name = "Pacientes.findByPacienteUsuarioCreacion", query = "SELECT p FROM Pacientes p WHERE p.pacienteUsuarioCreacion = :pacienteUsuarioCreacion"),
    @NamedQuery(name = "Pacientes.findByPacienteFechaModificacion", query = "SELECT p FROM Pacientes p WHERE p.pacienteFechaModificacion = :pacienteFechaModificacion"),
    @NamedQuery(name = "Pacientes.findByPacienteUsuarioModificacion", query = "SELECT p FROM Pacientes p WHERE p.pacienteUsuarioModificacion = :pacienteUsuarioModificacion"),

    @NamedQuery(name = "Pacientes.findByPacientePorExpediente", query = "SELECT p FROM Pacientes p WHERE CAST(p.pacienteId AS TEXT) LIKE CONCAT('%',:expediente,'%')"),
    @NamedQuery(name = "Pacientes.findByPacientePorNombre", query = "SELECT p FROM Pacientes p WHERE UPPER(CONCAT(p.pacientePrimerNombre,' ',p.pacienteSegundoNombre,' ',p.pacientePrimerApellido,' ',p.pacienteSegundoApellido)) LIKE CONCAT('%',UPPER(:nombre),'%')"),
    @NamedQuery(name = "Pacientes.findByUltimoNumeroExpediente", query = "SELECT MAX(p.pacienteExpediente) FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findByFechaCreacionRango", query = "SELECT p FROM Pacientes p WHERE p.pacienteFechaCreacion >= :fecha_inicio AND p.pacienteFechaCreacion <= :fecha_fin"),
    @NamedQuery(name = "Pacientes.enviarCorreoDesde", query = "SELECT p FROM Pacientes p WHERE p.pacienteNotificarCorreo = true AND p.pacienteId > :desde")})
public class Pacientes implements Serializable {

    @Column(name = "paciente_notificar_correo")
    private Boolean pacienteNotificarCorreo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paciente_id")
    private Integer pacienteId;
    @Size(max = 15)
    @Column(name = "paciente_expediente")
    private String pacienteExpediente;
    @Size(max = 25)
    @Column(name = "paciente_primer_nombre")
    private String pacientePrimerNombre;
    @Size(max = 25)
    @Column(name = "paciente_segundo_nombre")
    private String pacienteSegundoNombre;
    @Size(max = 25)
    @Column(name = "paciente_primer_apellido")
    private String pacientePrimerApellido;
    @Size(max = 25)
    @Column(name = "paciente_segundo_apellido")
    private String pacienteSegundoApellido;
    @Column(name = "paciente_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date pacienteFechaNacimiento;
    @Column(name = "paciente_sexo")
    private Boolean pacienteSexo;
    @Size(max = 50)
    @Column(name = "paciente_correo")
    private String pacienteCorreo;
    @Size(max = 50)
    @Column(name = "paciente_trabajo")
    private String pacienteTrabajo;
    @Size(max = 10)
    @Column(name = "paciente_telefono_casa")
    private String pacienteTelefonoCasa;
    @Size(max = 10)
    @Column(name = "paciente_telefono_movil")
    private String pacienteTelefonoMovil;
    @Size(max = 10)
    @Column(name = "paciente_telefono_oficina")
    private String pacienteTelefonoOficina;
    @Column(name = "paciente_whatsapp")
    private Boolean pacienteWhatsapp;
    @Column(name = "paciente_estado")
    private Boolean pacienteEstado;
    @Size(max = 250)
    @Column(name = "paciente_antecedentes")
    private String pacienteAntecedentes;
    @Column(name = "paciente_recordatorio")
    private Boolean pacienteRecordatorio;
    @Column(name = "paciente_fecha_seguimiento")
    @Temporal(TemporalType.DATE)
    private Date pacienteFechaSeguimiento;
    @Size(max = 75)
    @Column(name = "paciente_responsable")
    private String pacienteResponsable;
    @Column(name = "paciente_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date pacienteFechaCreacion;
    @Size(max = 50)
    @Column(name = "paciente_usuario_creacion")
    private String pacienteUsuarioCreacion;
    @Column(name = "paciente_fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date pacienteFechaModificacion;
    @Size(max = 50)
    @Column(name = "paciente_usuario_modificacion")
    private String pacienteUsuarioModificacion;
    @JoinTable(name = "patologias_por_pacientes", joinColumns = {
        @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")}, inverseJoinColumns = {
        @JoinColumn(name = "patologia_id", referencedColumnName = "patologia_id")})
    @ManyToMany
    private List<Patologias> patologiasList;
    @OneToMany(mappedBy = "pacienteId")
    private List<Direcciones> direccionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteId")
    private List<Imagenes> imagenesList;
    @OneToMany(mappedBy = "pacienteId")
    private List<DetallesConsultas> detallesConsultasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteId")
    private List<Consultas> consultasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteId")
    private List<Odontogramas> odontogramasList;

    public Pacientes() {
    }

    public Pacientes(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Integer getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getPacienteExpediente() {
        return pacienteExpediente;
    }

    public void setPacienteExpediente(String pacienteExpediente) {
        this.pacienteExpediente = pacienteExpediente;
    }

    public String getPacientePrimerNombre() {
        return pacientePrimerNombre;
    }

    public void setPacientePrimerNombre(String pacientePrimerNombre) {
        this.pacientePrimerNombre = pacientePrimerNombre;
    }

    public String getPacienteSegundoNombre() {
        return pacienteSegundoNombre;
    }

    public void setPacienteSegundoNombre(String pacienteSegundoNombre) {
        this.pacienteSegundoNombre = pacienteSegundoNombre;
    }

    public String getPacientePrimerApellido() {
        return pacientePrimerApellido;
    }

    public void setPacientePrimerApellido(String pacientePrimerApellido) {
        this.pacientePrimerApellido = pacientePrimerApellido;
    }

    public String getPacienteSegundoApellido() {
        return pacienteSegundoApellido;
    }

    public void setPacienteSegundoApellido(String pacienteSegundoApellido) {
        this.pacienteSegundoApellido = pacienteSegundoApellido;
    }

    public Date getPacienteFechaNacimiento() {
        return pacienteFechaNacimiento;
    }

    public void setPacienteFechaNacimiento(Date pacienteFechaNacimiento) {
        this.pacienteFechaNacimiento = pacienteFechaNacimiento;
    }

    public Boolean getPacienteSexo() {
        return pacienteSexo;
    }

    public void setPacienteSexo(Boolean pacienteSexo) {
        this.pacienteSexo = pacienteSexo;
    }

    public String getPacienteCorreo() {
        return pacienteCorreo;
    }

    public void setPacienteCorreo(String pacienteCorreo) {
        this.pacienteCorreo = pacienteCorreo;
    }

    public String getPacienteTrabajo() {
        return pacienteTrabajo;
    }

    public void setPacienteTrabajo(String pacienteTrabajo) {
        this.pacienteTrabajo = pacienteTrabajo;
    }

    public String getPacienteTelefonoCasa() {
        return pacienteTelefonoCasa;
    }

    public void setPacienteTelefonoCasa(String pacienteTelefonoCasa) {
        this.pacienteTelefonoCasa = pacienteTelefonoCasa;
    }

    public String getPacienteTelefonoMovil() {
        return pacienteTelefonoMovil;
    }

    public void setPacienteTelefonoMovil(String pacienteTelefonoMovil) {
        this.pacienteTelefonoMovil = pacienteTelefonoMovil;
    }

    public String getPacienteTelefonoOficina() {
        return pacienteTelefonoOficina;
    }

    public void setPacienteTelefonoOficina(String pacienteTelefonoOficina) {
        this.pacienteTelefonoOficina = pacienteTelefonoOficina;
    }

    public Boolean getPacienteWhatsapp() {
        return pacienteWhatsapp;
    }

    public void setPacienteWhatsapp(Boolean pacienteWhatsapp) {
        this.pacienteWhatsapp = pacienteWhatsapp;
    }

    public Boolean getPacienteEstado() {
        return pacienteEstado;
    }

    public void setPacienteEstado(Boolean pacienteEstado) {
        this.pacienteEstado = pacienteEstado;
    }

    public String getPacienteAntecedentes() {
        return pacienteAntecedentes;
    }

    public void setPacienteAntecedentes(String pacienteAntecedentes) {
        this.pacienteAntecedentes = pacienteAntecedentes;
    }

    public Boolean getPacienteRecordatorio() {
        return pacienteRecordatorio;
    }

    public void setPacienteRecordatorio(Boolean pacienteRecordatorio) {
        this.pacienteRecordatorio = pacienteRecordatorio;
    }

    public Date getPacienteFechaSeguimiento() {
        return pacienteFechaSeguimiento;
    }

    public void setPacienteFechaSeguimiento(Date pacienteFechaSeguimiento) {
        this.pacienteFechaSeguimiento = pacienteFechaSeguimiento;
    }

    public String getPacienteResponsable() {
        return pacienteResponsable;
    }

    public void setPacienteResponsable(String pacienteResponsable) {
        this.pacienteResponsable = pacienteResponsable;
    }

    public Date getPacienteFechaCreacion() {
        return pacienteFechaCreacion;
    }

    public void setPacienteFechaCreacion(Date pacienteFechaCreacion) {
        this.pacienteFechaCreacion = pacienteFechaCreacion;
    }

    public String getPacienteUsuarioCreacion() {
        return pacienteUsuarioCreacion;
    }

    public void setPacienteUsuarioCreacion(String pacienteUsuarioCreacion) {
        this.pacienteUsuarioCreacion = pacienteUsuarioCreacion;
    }

    public Date getPacienteFechaModificacion() {
        return pacienteFechaModificacion;
    }

    public void setPacienteFechaModificacion(Date pacienteFechaModificacion) {
        this.pacienteFechaModificacion = pacienteFechaModificacion;
    }

    public String getPacienteUsuarioModificacion() {
        return pacienteUsuarioModificacion;
    }

    public void setPacienteUsuarioModificacion(String pacienteUsuarioModificacion) {
        this.pacienteUsuarioModificacion = pacienteUsuarioModificacion;
    }

    public List<Patologias> getPatologiasList() {
        return patologiasList;
    }

    public void setPatologiasList(List<Patologias> patologiasList) {
        this.patologiasList = patologiasList;
    }

    public List<Direcciones> getDireccionesList() {
        return direccionesList;
    }

    public void setDireccionesList(List<Direcciones> direccionesList) {
        this.direccionesList = direccionesList;
    }

    public List<Imagenes> getImagenesList() {
        return imagenesList;
    }

    public void setImagenesList(List<Imagenes> imagenesList) {
        this.imagenesList = imagenesList;
    }

    public List<DetallesConsultas> getDetallesConsultasList() {
        return detallesConsultasList;
    }

    public void setDetallesConsultasList(List<DetallesConsultas> detallesConsultasList) {
        this.detallesConsultasList = detallesConsultasList;
    }

    public List<Consultas> getConsultasList() {
        return consultasList;
    }

    public void setConsultasList(List<Consultas> consultasList) {
        this.consultasList = consultasList;
    }

    public List<Odontogramas> getOdontogramasList() {
        return odontogramasList;
    }

    public void setOdontogramasList(List<Odontogramas> odontogramasList) {
        this.odontogramasList = odontogramasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacienteId != null ? pacienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.pacienteId == null && other.pacienteId != null) || (this.pacienteId != null && !this.pacienteId.equals(other.pacienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pacientes[ pacienteId=" + pacienteId + " ]";
    }

    public Boolean getPacienteNotificarCorreo() {
        return pacienteNotificarCorreo;
    }

    public void setPacienteNotificarCorreo(Boolean pacienteNotificarCorreo) {
        this.pacienteNotificarCorreo = pacienteNotificarCorreo;
    }
    
}
