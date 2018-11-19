package entities;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "roles")
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByRolId", query = "SELECT r FROM Roles r WHERE r.rolId = :rolId"),
    @NamedQuery(name = "Roles.findByRolNombre", query = "SELECT r FROM Roles r WHERE r.rolNombre = :rolNombre"),
    @NamedQuery(name = "Roles.findByRolDescripcion", query = "SELECT r FROM Roles r WHERE r.rolDescripcion = :rolDescripcion"),
    @NamedQuery(name = "Roles.findByRolFechaCreacion", query = "SELECT r FROM Roles r WHERE r.rolFechaCreacion = :rolFechaCreacion"),
    @NamedQuery(name = "Roles.findByRolUsuarioCreacion", query = "SELECT r FROM Roles r WHERE r.rolUsuarioCreacion = :rolUsuarioCreacion"),
    @NamedQuery(name = "Roles.findByRolFechaModificacion", query = "SELECT r FROM Roles r WHERE r.rolFechaModificacion = :rolFechaModificacion"),
    @NamedQuery(name = "Roles.findByRolUsuarioModificacion", query = "SELECT r FROM Roles r WHERE r.rolUsuarioModificacion = :rolUsuarioModificacion")})
public class Roles implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_id")
    private Integer rolId;
    @Size(max = 50)
    @Column(name = "rol_nombre")
    private String rolNombre;
    @Size(max = 250)
    @Column(name = "rol_descripcion")
    private String rolDescripcion;
    @Column(name = "rol_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date rolFechaCreacion;
    @Size(max = 50)
    @Column(name = "rol_usuario_creacion")
    private String rolUsuarioCreacion;
    @Column(name = "rol_fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date rolFechaModificacion;
    @Size(max = 50)
    @Column(name = "rol_usuario_modificacion")
    private String rolUsuarioModificacion;
    @JoinTable(name = "menus_por_roles", joinColumns = {
        @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")}, inverseJoinColumns = {
        @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")})
    @ManyToMany//(mappedBy = "rolesList")
    private List<Menus> menusList;
    @JoinTable(name = "sub_menus_por_roles", joinColumns = {
        @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")}, inverseJoinColumns = {
        @JoinColumn(name = "submenu_id", referencedColumnName = "submenu_id")})
    @ManyToMany
    private List<Submenus> submenusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolId")
    private List<Usuarios> usuariosList;

    public Roles() {
    }

    public Roles(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public Date getRolFechaCreacion() {
        return rolFechaCreacion;
    }

    public void setRolFechaCreacion(Date rolFechaCreacion) {
        this.rolFechaCreacion = rolFechaCreacion;
    }

    public String getRolUsuarioCreacion() {
        return rolUsuarioCreacion;
    }

    public void setRolUsuarioCreacion(String rolUsuarioCreacion) {
        this.rolUsuarioCreacion = rolUsuarioCreacion;
    }

    public Date getRolFechaModificacion() {
        return rolFechaModificacion;
    }

    public void setRolFechaModificacion(Date rolFechaModificacion) {
        this.rolFechaModificacion = rolFechaModificacion;
    }

    public String getRolUsuarioModificacion() {
        return rolUsuarioModificacion;
    }

    public void setRolUsuarioModificacion(String rolUsuarioModificacion) {
        this.rolUsuarioModificacion = rolUsuarioModificacion;
    }

    public List<Menus> getMenusList() {
        return menusList;
    }

    public void setMenusList(List<Menus> menusList) {
        this.menusList = menusList;
    }

    public List<Submenus> getSubmenusList() {
        return submenusList;
    }

    public void setSubmenusList(List<Submenus> submenusList) {
        this.submenusList = submenusList;
    }

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Roles[ rolId=" + rolId + " ]";
    }
    
    public List<Submenus> SubMenuPorMenu(Integer menu_id) {
        List<Submenus> temp = new ArrayList<>();
        for (Submenus submenus : submenusList) {
            if(submenus.getMenuId().getMenuId() == menu_id){
                temp.add(submenus);
            }
        }
        return temp;
    }

       
}
