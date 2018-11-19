package controllers;

import dao.UsuariosFacade;
import entities.Usuarios;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@ManagedBean
@ViewScoped
public class UsuarioBean  implements Serializable {
    
    @EJB
    private UsuariosFacade usuariosFacade;
    private Usuarios usuarioLogueado = new Usuarios();
    
//****************************************************************************//
//                                  Variables                                 //
//****************************************************************************//

    private String usuario;
    private String password;
  
    @ManagedProperty(value="#{appSession}")
    private AppSession appSession;

    public UsuarioBean() {
    }

//****************************************************************************//
//                                   Métodos                                  //
//****************************************************************************//

    //Método Get para obtener datos de entidad Usuarios
    public UsuariosFacade getUsuariosFacade() {
        return usuariosFacade;
    }
       
    //Método que define la acción por usuario logueado, direciona a página de inicio según usuario.
    public void logiAction(){
        System.out.println("Usuario: "+usuario);
        usuarioLogueado = getUsuariosFacade().traeUsuarioLogueado(usuario);
        
        if(usuarioLogueado != null){
            appSession.setUsuario(usuarioLogueado);
        
        }
        
        String accion = null;
        try {
            String rol = appSession.getUsuario().getRolId().getRolNombre();
            System.out.println("Paso 2.");
            System.out.println("Rol: "+rol);
            if (rol!=null) {
                refrescaPagina("/dashboard.xhtml");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

    //Método que retorna el rol (perfil) del usuario logueado.
    private String postLogin() {
        System.out.println("Entra a postLogin.");
        String rol=null;
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername(); //obtenemos el usuario logueado    
        //Guardar el nombre de la session del usuario
        try{
            System.out.println("Antes de la consulta.");
            Usuarios usuario = getUsuariosFacade().traeUsuarioLogueado(name);
            System.out.println("Despues de la consulta.");
            System.out.println("Usuario autenticado: "+usuario.getUsuarioNombre()); 
            appSession.setUsuario(usuario);
        }catch(Exception e){
            System.out.println(e.toString());
        }
        if(appSession.getUsuario() !=null){
            rol = appSession.getUsuario().getRolId().getRolNombre();
        }
        return rol;
    }

    //Mpetodo para salir del sistema. (plantilla1)
    public void salirSistema(){
        appSession.setUsuario(null);
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
        String contextPath = origRequest.getContextPath();
        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath+"/login.xhtml");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void verificaAcceso(){
        try{
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
        String contextPath = origRequest.getContextPath();
        
            if(appSession.getUsuario() == null){
                FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath+"/login.xhtml");
            }
            /*else{
                Aquí va la validación si se tiene acceso a la página consultada. 
                Si no hay acceso se envía al login. Caso contrario se muestra la página.
            }*/
            
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
//****************************************************************************//
//                      Métodos GET y SET para variables                      //
//****************************************************************************//
    
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }
   public void setPassword(String password) {
        this.password = password;
    }

    public AppSession getAppSession() {
        return appSession;
    }
    public void setAppSession(AppSession appSession) {
        this.appSession = appSession;
    }

    public Usuarios getUsuarioLogueado() {
        return usuarioLogueado;
    }
    public void setUsuarioLogueado(Usuarios usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    //Método para direccionar a una página (login.xhtml)
    public void refrescaPagina(String url){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
        String contextPath = origRequest.getContextPath();
        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath+url);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    
}
