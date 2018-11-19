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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsuarioUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuarioUsuario = :usuarioUsuario"),
    @NamedQuery(name = "Usuarios.findByUsuarioNombre", query = "SELECT u FROM Usuarios u WHERE u.usuarioNombre = :usuarioNombre"),
    @NamedQuery(name = "Usuarios.findByUsuarioApellido", query = "SELECT u FROM Usuarios u WHERE u.usuarioApellido = :usuarioApellido"),
    @NamedQuery(name = "Usuarios.findByUsuarioCorreo", query = "SELECT u FROM Usuarios u WHERE u.usuarioCorreo = :usuarioCorreo"),
    @NamedQuery(name = "Usuarios.findByUsuarioTelefono", query = "SELECT u FROM Usuarios u WHERE u.usuarioTelefono = :usuarioTelefono"),
    @NamedQuery(name = "Usuarios.findByUsuarioContrasenia", query = "SELECT u FROM Usuarios u WHERE u.usuarioContrasenia = :usuarioContrasenia"),
    @NamedQuery(name = "Usuarios.findByUsuarioEstado", query = "SELECT u FROM Usuarios u WHERE u.usuarioEstado = :usuarioEstado"),
    @NamedQuery(name = "Usuarios.findByUsuarioFechaCreacion", query = "SELECT u FROM Usuarios u WHERE u.usuarioFechaCreacion = :usuarioFechaCreacion"),
    @NamedQuery(name = "Usuarios.findByUsuarioFechaModificacion", query = "SELECT u FROM Usuarios u WHERE u.usuarioFechaModificacion = :usuarioFechaModificacion")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario_usuario")
    private String usuarioUsuario;
    @Size(max = 50)
    @Column(name = "usuario_nombre")
    private String usuarioNombre;
    @Size(max = 50)
    @Column(name = "usuario_apellido")
    private String usuarioApellido;
    @Size(max = 50)
    @Column(name = "usuario_correo")
    private String usuarioCorreo;
    @Size(max = 10)
    @Column(name = "usuario_telefono")
    private String usuarioTelefono;
    @Size(max = 50)
    @Column(name = "usuario_contrasenia")
    private String usuarioContrasenia;
    @Column(name = "usuario_estado")
    private Boolean usuarioEstado;
    @Column(name = "usuario_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date usuarioFechaCreacion;
    @Column(name = "usuario_fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date usuarioFechaModificacion;
    @OneToMany(mappedBy = "usuarioUsuario")
    private List<Citas> citasList;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)
    private Roles rolId;

    public Usuarios() {
    }

    public Usuarios(String usuarioUsuario) {
        this.usuarioUsuario = usuarioUsuario;
    }

    public String getUsuarioUsuario() {
        return usuarioUsuario;
    }

    public void setUsuarioUsuario(String usuarioUsuario) {
        this.usuarioUsuario = usuarioUsuario;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioApellido() {
        return usuarioApellido;
    }

    public void setUsuarioApellido(String usuarioApellido) {
        this.usuarioApellido = usuarioApellido;
    }

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public String getUsuarioTelefono() {
        return usuarioTelefono;
    }

    public void setUsuarioTelefono(String usuarioTelefono) {
        this.usuarioTelefono = usuarioTelefono;
    }

    public String getUsuarioContrasenia() {
        return usuarioContrasenia;
    }

    public void setUsuarioContrasenia(String usuarioContrasenia) {
        this.usuarioContrasenia = usuarioContrasenia;
    }

    public Boolean getUsuarioEstado() {
        return usuarioEstado;
    }

    public void setUsuarioEstado(Boolean usuarioEstado) {
        this.usuarioEstado = usuarioEstado;
    }

    public Date getUsuarioFechaCreacion() {
        return usuarioFechaCreacion;
    }

    public void setUsuarioFechaCreacion(Date usuarioFechaCreacion) {
        this.usuarioFechaCreacion = usuarioFechaCreacion;
    }

    public Date getUsuarioFechaModificacion() {
        return usuarioFechaModificacion;
    }

    public void setUsuarioFechaModificacion(Date usuarioFechaModificacion) {
        this.usuarioFechaModificacion = usuarioFechaModificacion;
    }

    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    public Roles getRolId() {
        return rolId;
    }

    public void setRolId(Roles rolId) {
        this.rolId = rolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioUsuario != null ? usuarioUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuarioUsuario == null && other.usuarioUsuario != null) || (this.usuarioUsuario != null && !this.usuarioUsuario.equals(other.usuarioUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuarios[ usuarioUsuario=" + usuarioUsuario + " ]";
    }
    
}
