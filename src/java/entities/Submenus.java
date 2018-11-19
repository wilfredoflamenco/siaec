/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "submenus")
@NamedQueries({
    @NamedQuery(name = "Submenus.findAll", query = "SELECT s FROM Submenus s"),
    @NamedQuery(name = "Submenus.findBySubmenuId", query = "SELECT s FROM Submenus s WHERE s.submenuId = :submenuId"),
    @NamedQuery(name = "Submenus.findBySumbenuNombre", query = "SELECT s FROM Submenus s WHERE s.sumbenuNombre = :sumbenuNombre"),

    @NamedQuery(name = "Submenus.findMenu", query = "SELECT s From Submenus s WHERE s.menuId.menuId = :menu_id")})
public class Submenus implements Serializable {

    @Size(max = 250)
    @Column(name = "submenu_descripcion")
    private String submenuDescripcion;
    @Size(max = 100)
    @Column(name = "submenu_url")
    private String submenuUrl;
    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
    @ManyToOne
    private Menus menuId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "submenu_id")
    private Integer submenuId;
    @Size(max = 50)
    @Column(name = "sumbenu_nombre")
    private String sumbenuNombre;
    @ManyToMany(mappedBy = "submenusList")
    private List<Roles> rolesList;
    
    public Submenus() {
    }

    public Submenus(Integer submenuId) {
        this.submenuId = submenuId;
    }

    public Integer getSubmenuId() {
        return submenuId;
    }

    public void setSubmenuId(Integer submenuId) {
        this.submenuId = submenuId;
    }

    public String getSumbenuNombre() {
        return sumbenuNombre;
    }

    public void setSumbenuNombre(String sumbenuNombre) {
        this.sumbenuNombre = sumbenuNombre;
    }

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (submenuId != null ? submenuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submenus)) {
            return false;
        }
        Submenus other = (Submenus) object;
        if ((this.submenuId == null && other.submenuId != null) || (this.submenuId != null && !this.submenuId.equals(other.submenuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Submenus[ submenuId=" + submenuId + " ]";
    }

    public String getSubmenuDescripcion() {
        return submenuDescripcion;
    }

    public void setSubmenuDescripcion(String submenuDescripcion) {
        this.submenuDescripcion = submenuDescripcion;
    }

    public String getSubmenuUrl() {
        return submenuUrl;
    }

    public void setSubmenuUrl(String submenuUrl) {
        this.submenuUrl = submenuUrl;
    }

    public Menus getMenuId() {
        return menuId;
    }

    public void setMenuId(Menus menuId) {
        this.menuId = menuId;
    }
    
}
