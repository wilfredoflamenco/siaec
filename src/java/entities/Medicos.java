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
@Table(name = "medicos")
@NamedQueries({
    @NamedQuery(name = "Medicos.findAll", query = "SELECT m FROM Medicos m"),
    @NamedQuery(name = "Medicos.findByMedicoId", query = "SELECT m FROM Medicos m WHERE m.medicoId = :medicoId"),
    @NamedQuery(name = "Medicos.findByMedicoPrimerNombre", query = "SELECT m FROM Medicos m WHERE m.medicoPrimerNombre = :medicoPrimerNombre"),
    @NamedQuery(name = "Medicos.findByMedicoSegundoNombre", query = "SELECT m FROM Medicos m WHERE m.medicoSegundoNombre = :medicoSegundoNombre"),
    @NamedQuery(name = "Medicos.findByMedicoPrimerApellido", query = "SELECT m FROM Medicos m WHERE m.medicoPrimerApellido = :medicoPrimerApellido"),
    @NamedQuery(name = "Medicos.findByMedicoSegundoApellido", query = "SELECT m FROM Medicos m WHERE m.medicoSegundoApellido = :medicoSegundoApellido"),
    @NamedQuery(name = "Medicos.findByMedicoFechaNacimiento", query = "SELECT m FROM Medicos m WHERE m.medicoFechaNacimiento = :medicoFechaNacimiento"),
    @NamedQuery(name = "Medicos.findByMedicoSexo", query = "SELECT m FROM Medicos m WHERE m.medicoSexo = :medicoSexo"),
    @NamedQuery(name = "Medicos.findByMedicoCorreo", query = "SELECT m FROM Medicos m WHERE m.medicoCorreo = :medicoCorreo"),
    @NamedQuery(name = "Medicos.findByMedicoEspecialidad", query = "SELECT m FROM Medicos m WHERE m.medicoEspecialidad = :medicoEspecialidad"),
    @NamedQuery(name = "Medicos.findByMedicoTelefonoCasa", query = "SELECT m FROM Medicos m WHERE m.medicoTelefonoCasa = :medicoTelefonoCasa"),
    @NamedQuery(name = "Medicos.findByMedicoTelefonoMovil", query = "SELECT m FROM Medicos m WHERE m.medicoTelefonoMovil = :medicoTelefonoMovil"),
    @NamedQuery(name = "Medicos.findByMedicoNumeroAcreditacion", query = "SELECT m FROM Medicos m WHERE m.medicoNumeroAcreditacion = :medicoNumeroAcreditacion"),
    @NamedQuery(name = "Medicos.findByMedicoEstado", query = "SELECT m FROM Medicos m WHERE m.medicoEstado = :medicoEstado"),
    @NamedQuery(name = "Medicos.findByMedicoUsuario", query = "SELECT m FROM Medicos m WHERE m.medicoUsuario = :medicoUsuario"),
    @NamedQuery(name = "Medicos.findByMedicoFechaCreacion", query = "SELECT m FROM Medicos m WHERE m.medicoFechaCreacion = :medicoFechaCreacion"),
    @NamedQuery(name = "Medicos.findByMedicoUsuarioCreacion", query = "SELECT m FROM Medicos m WHERE m.medicoUsuarioCreacion = :medicoUsuarioCreacion"),
    @NamedQuery(name = "Medicos.findByMedicoFechaModificacion", query = "SELECT m FROM Medicos m WHERE m.medicoFechaModificacion = :medicoFechaModificacion"),
    @NamedQuery(name = "Medicos.findByMedicoUsuarioModificacion", query = "SELECT m FROM Medicos m WHERE m.medicoUsuarioModificacion = :medicoUsuarioModificacion")})
public class Medicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medico_id")
    private Integer medicoId;
    @Size(max = 25)
    @Column(name = "medico_primer_nombre")
    private String medicoPrimerNombre;
    @Size(max = 50)
    @Column(name = "medico_segundo_nombre")
    private String medicoSegundoNombre;
    @Size(max = 25)
    @Column(name = "medico_primer_apellido")
    private String medicoPrimerApellido;
    @Size(max = 25)
    @Column(name = "medico_segundo_apellido")
    private String medicoSegundoApellido;
    @Column(name = "medico_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date medicoFechaNacimiento;
    @Column(name = "medico_sexo")
    private Boolean medicoSexo;
    @Size(max = 50)
    @Column(name = "medico_correo")
    private String medicoCorreo;
    @Size(max = 100)
    @Column(name = "medico_especialidad")
    private String medicoEspecialidad;
    @Size(max = 10)
    @Column(name = "medico_telefono_casa")
    private String medicoTelefonoCasa;
    @Size(max = 10)
    @Column(name = "medico_telefono_movil")
    private String medicoTelefonoMovil;
    @Size(max = 10)
    @Column(name = "medico_numero_acreditacion")
    private String medicoNumeroAcreditacion;
    @Column(name = "medico_estado")
    private Boolean medicoEstado;
    @Size(max = 50)
    @Column(name = "medico_usuario")
    private String medicoUsuario;
    @Column(name = "medico_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date medicoFechaCreacion;
    @Size(max = 50)
    @Column(name = "medico_usuario_creacion")
    private String medicoUsuarioCreacion;
    @Column(name = "medico_fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date medicoFechaModificacion;
    @Size(max = 50)
    @Column(name = "medico_usuario_modificacion")
    private String medicoUsuarioModificacion;
    @OneToMany(mappedBy = "medicoId")
    private List<Direcciones> direccionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoId")
    private List<Consultas> consultasList;
    @OneToMany(mappedBy = "medicoId")
    private List<Citas> citasList;

    public Medicos() {
    }

    public Medicos(Integer medicoId) {
        this.medicoId = medicoId;
    }

    public Integer getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Integer medicoId) {
        this.medicoId = medicoId;
    }

    public String getMedicoPrimerNombre() {
        return medicoPrimerNombre;
    }

    public void setMedicoPrimerNombre(String medicoPrimerNombre) {
        this.medicoPrimerNombre = medicoPrimerNombre;
    }

    public String getMedicoSegundoNombre() {
        return medicoSegundoNombre;
    }

    public void setMedicoSegundoNombre(String medicoSegundoNombre) {
        this.medicoSegundoNombre = medicoSegundoNombre;
    }

    public String getMedicoPrimerApellido() {
        return medicoPrimerApellido;
    }

    public void setMedicoPrimerApellido(String medicoPrimerApellido) {
        this.medicoPrimerApellido = medicoPrimerApellido;
    }

    public String getMedicoSegundoApellido() {
        return medicoSegundoApellido;
    }

    public void setMedicoSegundoApellido(String medicoSegundoApellido) {
        this.medicoSegundoApellido = medicoSegundoApellido;
    }

    public Date getMedicoFechaNacimiento() {
        return medicoFechaNacimiento;
    }

    public void setMedicoFechaNacimiento(Date medicoFechaNacimiento) {
        this.medicoFechaNacimiento = medicoFechaNacimiento;
    }

    public Boolean getMedicoSexo() {
        return medicoSexo;
    }

    public void setMedicoSexo(Boolean medicoSexo) {
        this.medicoSexo = medicoSexo;
    }

    public String getMedicoCorreo() {
        return medicoCorreo;
    }

    public void setMedicoCorreo(String medicoCorreo) {
        this.medicoCorreo = medicoCorreo;
    }

    public String getMedicoEspecialidad() {
        return medicoEspecialidad;
    }

    public void setMedicoEspecialidad(String medicoEspecialidad) {
        this.medicoEspecialidad = medicoEspecialidad;
    }

    public String getMedicoTelefonoCasa() {
        return medicoTelefonoCasa;
    }

    public void setMedicoTelefonoCasa(String medicoTelefonoCasa) {
        this.medicoTelefonoCasa = medicoTelefonoCasa;
    }

    public String getMedicoTelefonoMovil() {
        return medicoTelefonoMovil;
    }

    public void setMedicoTelefonoMovil(String medicoTelefonoMovil) {
        this.medicoTelefonoMovil = medicoTelefonoMovil;
    }

    public String getMedicoNumeroAcreditacion() {
        return medicoNumeroAcreditacion;
    }

    public void setMedicoNumeroAcreditacion(String medicoNumeroAcreditacion) {
        this.medicoNumeroAcreditacion = medicoNumeroAcreditacion;
    }

    public Boolean getMedicoEstado() {
        return medicoEstado;
    }

    public void setMedicoEstado(Boolean medicoEstado) {
        this.medicoEstado = medicoEstado;
    }

    public String getMedicoUsuario() {
        return medicoUsuario;
    }

    public void setMedicoUsuario(String medicoUsuario) {
        this.medicoUsuario = medicoUsuario;
    }

    public Date getMedicoFechaCreacion() {
        return medicoFechaCreacion;
    }

    public void setMedicoFechaCreacion(Date medicoFechaCreacion) {
        this.medicoFechaCreacion = medicoFechaCreacion;
    }

    public String getMedicoUsuarioCreacion() {
        return medicoUsuarioCreacion;
    }

    public void setMedicoUsuarioCreacion(String medicoUsuarioCreacion) {
        this.medicoUsuarioCreacion = medicoUsuarioCreacion;
    }

    public Date getMedicoFechaModificacion() {
        return medicoFechaModificacion;
    }

    public void setMedicoFechaModificacion(Date medicoFechaModificacion) {
        this.medicoFechaModificacion = medicoFechaModificacion;
    }

    public String getMedicoUsuarioModificacion() {
        return medicoUsuarioModificacion;
    }

    public void setMedicoUsuarioModificacion(String medicoUsuarioModificacion) {
        this.medicoUsuarioModificacion = medicoUsuarioModificacion;
    }

    public List<Direcciones> getDireccionesList() {
        return direccionesList;
    }

    public void setDireccionesList(List<Direcciones> direccionesList) {
        this.direccionesList = direccionesList;
    }

    public List<Consultas> getConsultasList() {
        return consultasList;
    }

    public void setConsultasList(List<Consultas> consultasList) {
        this.consultasList = consultasList;
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
        hash += (medicoId != null ? medicoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicos)) {
            return false;
        }
        Medicos other = (Medicos) object;
        if ((this.medicoId == null && other.medicoId != null) || (this.medicoId != null && !this.medicoId.equals(other.medicoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Medicos[ medicoId=" + medicoId + " ]";
    }
    
}
