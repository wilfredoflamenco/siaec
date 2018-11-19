package controllers;

import dao.MenusFacade;
import dao.RolesFacade;
import dao.SubmenusFacade;
import entities.Menus;
import entities.Roles;
import entities.Submenus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named(value = "AdministracionBean")
@SessionScoped
public class AdministracionBean implements Serializable {

//****************************************************************************//
//                          Declaración de variables                          //
//****************************************************************************//
    @EJB
    private RolesFacade rolesFacade;
    private Roles rolNuevo = new Roles();
    private Roles rolConsultar = new Roles();
    private Roles rolEditar = new Roles();
    private List<Submenus> submenu1 = new ArrayList<>();
    private List<Submenus> submenu2 = new ArrayList<>();
    private List<Submenus> submenu3 = new ArrayList<>();
    private List<Submenus> submenu4 = new ArrayList<>();
    private List<Submenus> submenu5 = new ArrayList<>();
    private List<Submenus> submenu6 = new ArrayList<>();
    private List<Submenus> submenu7 = new ArrayList<>();
    private List<Submenus> submenu8 = new ArrayList<>();

    @EJB
    private MenusFacade menusFacades;

    @EJB
    private SubmenusFacade subMenusFacades;

    private List<SelectItem> privilegios = new ArrayList<SelectItem>();
//****************************************************************************//
//                  Métodos para obtener listas por entidades                 //
//****************************************************************************//

    public List<Roles> todosRolesActivos() {
        return getRolesFacade().findAll();
    }

    public List<Menus> todosMenus() {
        return getMenusFacades().findAll();
    }

    public List<Submenus> subMenusPorMenu(Integer menu_id) {
        return getSubMenusFacades().subMenuPorMenu(menu_id);
    }

//****************************************************************************//
//                 Métodos Get para obtener datos de entidades                //
//****************************************************************************//    
    public RolesFacade getRolesFacade() {
        return rolesFacade;
    }

    public MenusFacade getMenusFacades() {
        return menusFacades;
    }

    public SubmenusFacade getSubMenusFacades() {
        return subMenusFacades;
    }

//****************************************************************************//
//                             Métodos Get y SET                              //
//****************************************************************************// 
    public Roles getRolConsultar() {
        return rolConsultar;
    }

    public void setRolConsultar(Roles rolConsultar) {
        this.rolConsultar = rolConsultar;
    }

    public Roles getRolEditar() {
        return rolEditar;
    }

    public void setRolEditar(Roles rolEditar) {
        this.rolEditar = rolEditar;
    }

    public Roles getRolNuevo() {
        return rolNuevo;
    }

    public void setRolNuevo(Roles rolNuevo) {
        this.rolNuevo = rolNuevo;
    }

    public List<Submenus> getSubmenu1() {
        return submenu1;
    }

    public void setSubmenu1(List<Submenus> submenu1) {
        this.submenu1 = submenu1;
    }

    public List<Submenus> getSubmenu2() {
        return submenu2;
    }

    public void setSubmenu2(List<Submenus> submenu2) {
        this.submenu2 = submenu2;
    }

    public List<Submenus> getSubmenu3() {
        return submenu3;
    }

    public void setSubmenu3(List<Submenus> submenu3) {
        this.submenu3 = submenu3;
    }

    public List<Submenus> getSubmenu4() {
        return submenu4;
    }

    public void setSubmenu4(List<Submenus> submenu4) {
        this.submenu4 = submenu4;
    }

    public List<Submenus> getSubmenu5() {
        return submenu5;
    }

    public void setSubmenu5(List<Submenus> submenu5) {
        this.submenu5 = submenu5;
    }

    public List<Submenus> getSubmenu6() {
        return submenu6;
    }

    public void setSubmenu6(List<Submenus> submenu6) {
        this.submenu6 = submenu6;
    }

    public List<Submenus> getSubmenu7() {
        return submenu7;
    }

    public void setSubmenu7(List<Submenus> submenu7) {
        this.submenu7 = submenu7;
    }

    public List<Submenus> getSubmenu8() {
        return submenu8;
    }

    public void setSubmenu8(List<Submenus> submenu8) {
        this.submenu8 = submenu8;
    }

//****************************************************************************//
//                                  Métodos                                   //
//****************************************************************************//    
    //Metodo usado en configuracion_roles_nuevo.xhtml
    public void guardarRol() {
        try {
            List<Submenus> temp = new ArrayList<>();
            List<Menus> tempMenu = new ArrayList<>();

            if (!submenu1.isEmpty()) {
                for (Submenus list : submenu1) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu1.get(0).getMenuId().getMenuId()));
            }

            if (!submenu2.isEmpty()) {
                for (Submenus list : submenu2) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu2.get(0).getMenuId().getMenuId()));
            }

            if (!submenu3.isEmpty()) {
                for (Submenus list : submenu3) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu3.get(0).getMenuId().getMenuId()));
            }

            if (!submenu4.isEmpty()) {
                for (Submenus list : submenu4) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu4.get(0).getMenuId().getMenuId()));
            }

            if (!submenu5.isEmpty()) {
                for (Submenus list : submenu5) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu5.get(0).getMenuId().getMenuId()));
            }

            if (!submenu6.isEmpty()) {
                for (Submenus list : submenu6) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu6.get(0).getMenuId().getMenuId()));
            }

            if (!submenu7.isEmpty()) {
                for (Submenus list : submenu7) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu7.get(0).getMenuId().getMenuId()));
            }
            
            if (!submenu8.isEmpty()) {
                for (Submenus list : submenu8) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu8.get(0).getMenuId().getMenuId()));
            }
            System.out.println("Curisoso");
            
            
            System.out.println("Curisoso");
            rolNuevo.setMenusList(tempMenu);
            rolNuevo.setSubmenusList(temp);
            System.out.println("Curisoso");
            getRolesFacade().create(rolNuevo);
            mensajeGuardado("El rol fue guardado.");
            limpiandoNuevoRol();
        } catch (Exception e) {
            mensajeError("Error al guardar el rol.");
            System.out.println("controllers.AdministracionBean.guardarRol()" + e);        }
    }

    //Metodo usado en la tabla de listas roles, en la opcion de editar.
    public void establecerPrivilegiosRolEditar() {
        if (rolEditar != null) {
            submenu1.clear();
            submenu2.clear();
            submenu3.clear();
            submenu4.clear();
            submenu5.clear();
            submenu6.clear();
            submenu7.clear();
            submenu8.clear();

            if (!rolEditar.getSubmenusList().isEmpty()) {

                for (Submenus item : rolEditar.getSubmenusList()) {
                    switch (item.getMenuId().getMenuId()) {
                        case 1:
                            submenu1.add(item);
                            break;
                        case 2:
                            submenu2.add(item);
                            break;
                        case 3:
                            submenu3.add(item);
                            break;
                        case 4:
                            submenu4.add(item);
                            break;
                        case 5:
                            submenu5.add(item);
                            break;
                        case 6:
                            submenu6.add(item);
                            break;
                        case 7:
                            submenu7.add(item);
                            break;
                        case 8:
                            submenu8.add(item);
                            break;
                    }
                }
            }
        }
    }

    //Metodo usado en la tabla de listas roles, en la opcion de consultar.
    public void establecerPrivilegiosRolConsultar() {
        if (rolConsultar != null) {
            submenu1.clear();
            submenu2.clear();
            submenu3.clear();
            submenu4.clear();
            submenu5.clear();
            submenu6.clear();
            submenu7.clear();
            submenu8.clear();

            if (!rolConsultar.getSubmenusList().isEmpty()) {

                for (Submenus item : rolConsultar.getSubmenusList()) {
                    switch (item.getMenuId().getMenuId()) {
                        case 1:
                            submenu1.add(item);
                            break;
                        case 2:
                            submenu2.add(item);
                            break;
                        case 3:
                            submenu3.add(item);
                            break;
                        case 4:
                            submenu4.add(item);
                            break;
                        case 5:
                            submenu5.add(item);
                            break;
                        case 6:
                            submenu6.add(item);
                            break;
                        case 7:
                            submenu7.add(item);
                            break;
                        case 8:
                            submenu8.add(item);
                            break;
                    }
                }
            }
        }
    }

    //Metodo usado en configuracion_roles_nuevo.xhtml
    public void limpiandoNuevoRol() {
        submenu1.clear();
        submenu2.clear();
        submenu3.clear();
        submenu4.clear();
        submenu5.clear();
        submenu6.clear();
        submenu7.clear();
        submenu8.clear();
        rolNuevo = new Roles();
    }

    //Metodo usado en configuracion_roles_editar.xhtml
    public void editarRol() {
        try {
            List<Submenus> temp = new ArrayList<>();
            List<Menus> tempMenu = new ArrayList<>();

            if (!submenu1.isEmpty()) {
                for (Submenus list : submenu1) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu1.get(0).getMenuId().getMenuId()));
            }

            if (!submenu2.isEmpty()) {
                for (Submenus list : submenu2) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu2.get(0).getMenuId().getMenuId()));
            }

            if (!submenu3.isEmpty()) {
                for (Submenus list : submenu3) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu3.get(0).getMenuId().getMenuId()));
            }

            if (!submenu4.isEmpty()) {
                for (Submenus list : submenu4) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu4.get(0).getMenuId().getMenuId()));
            }

            if (!submenu5.isEmpty()) {
                for (Submenus list : submenu5) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu5.get(0).getMenuId().getMenuId()));
            }

            if (!submenu6.isEmpty()) {
                for (Submenus list : submenu6) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu6.get(0).getMenuId().getMenuId()));
            }

            if (!submenu7.isEmpty()) {
                for (Submenus list : submenu7) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu7.get(0).getMenuId().getMenuId()));
            }

            if (!submenu8.isEmpty()) {
                for (Submenus list : submenu8) {
                    temp.add(list);
                }
                tempMenu.add(getMenusFacades().find(submenu8.get(0).getMenuId().getMenuId()));
            }
            rolEditar.getMenusList().clear();
            rolEditar.getSubmenusList().clear();
            rolEditar.setMenusList(tempMenu);
            rolEditar.setSubmenusList(temp);

            getRolesFacade().edit(rolEditar);
            mensajeGuardado("Rol actualizado adecuadamente.");
        } catch (Exception e) {
            mensajeError("Error al actualizar rol.");
        }
    }

    public List<SelectItem> privilegios() {
        List<Menus> menus = getMenusFacades().findAll();
        privilegios.clear();
        for (Menus menu : menus) {
            List<Submenus> submenus = subMenusPorMenu(menu.getMenuId());
            if (!submenus.isEmpty()) {
                SelectItemGroup grupoNuevo = new SelectItemGroup(menu.getMenuNombre());
                SelectItem[] items = new SelectItem[submenus.size()];
                for (int i = 0; i < submenus.size(); i++) {
                    System.out.println("Entraa" + submenus.get(i).getSubmenuId());
                    items[i] = new SelectItem(submenus.get(i).getSubmenuId(), submenus.get(i).getSumbenuNombre());
                }

                for (int i = 0; i < items.length; i++) {
                    System.out.println("items " + items[i].getLabel());
                }
                grupoNuevo.setSelectItems(items);
                privilegios.add(grupoNuevo);
            }

        }
        return privilegios;
    }

    //Método para mostrar mensaje de guardado/actualizado.
    public void mensajeGuardado(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

    //Método para mostrar mensaje de error en el sistema.
    public void mensajeError(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Error!", mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

}
