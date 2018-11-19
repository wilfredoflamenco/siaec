package controllers;

import dao.ConfiguracionesFacade;
import dao.UsuariosFacade;
import entities.Configuraciones;
import entities.Roles;
import entities.Usuarios;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;
import static org.springframework.util.FileCopyUtils.BUFFER_SIZE;

/**
 *
 * @author WilfredoFlamenco
 */
@Named(value = "homeBean")
@SessionScoped
public class HomeBean implements Serializable {

//****************************************************************************//
//                          Declaración de variables                          //
//****************************************************************************//
    @EJB
    private ConfiguracionesFacade configuracionesFacade;
    private Configuraciones configuracion = new Configuraciones();
    private Configuraciones configuracionEditar = new Configuraciones();

    @EJB
    private UsuariosFacade usuariosFacade;
    private Usuarios usuarioNuevo = new Usuarios();

    private Date fechaSistema = new Date();
    private UploadedFile fileSuperior;
    private UploadedFile fileInferior;
    private UploadedFile fileLogin;

    public HomeBean() {
    }

//****************************************************************************//
//                  Métodos para obtener listas por entidades                 //
//****************************************************************************//
    public List<Usuarios> todosUsuarios() {
        return getUsuariosFacade().findAll();
    }

//****************************************************************************//
//                 Métodos Get para obtener datos de entidades                //
//****************************************************************************//
    public ConfiguracionesFacade getConfiguracionesFacade() {
        return configuracionesFacade;
    }

    public UsuariosFacade getUsuariosFacade() {
        return usuariosFacade;
    }

//****************************************************************************//
//                             Métodos Get y SET                              //
//****************************************************************************//
    public Usuarios getUsuarioNuevo() {
        return usuarioNuevo;
    }

    public void setUsuarioNuevo(Usuarios usuarioNuevo) {
        this.usuarioNuevo = usuarioNuevo;
    }

    public Date getFechaSistema() {
        return fechaSistema;
    }

    public void setFechaSistema(Date fechaSistema) {
        this.fechaSistema = fechaSistema;
    }

    public Configuraciones getConfiguracion() {
        return getConfiguracionesFacade().find(1);
    }

    public void setConfiguracion(Configuraciones configuracion) {
        this.configuracion = configuracion;
    }

    public Configuraciones getConfiguracionEditar() {
        return configuracionEditar;
    }

    public void setConfiguracionEditar(Configuraciones configuracionEditar) {
        this.configuracionEditar = configuracionEditar;
    }

    public UploadedFile getFileSuperior() {
        return fileSuperior;
    }

    public void setFileSuperior(UploadedFile fileSuperior) {
        this.fileSuperior = fileSuperior;
    }

    public UploadedFile getFileInferior() {
        return fileInferior;
    }

    public void setFileInferior(UploadedFile fileInferior) {
        this.fileInferior = fileInferior;
    }

    public UploadedFile getFileLogin() {
        return fileLogin;
    }

    public void setFileLogin(UploadedFile fileLogin) {
        this.fileLogin = fileLogin;
    }

//****************************************************************************//
//                                  Métodos                                   //
//****************************************************************************//   
    public void guardarUsuario() {

        for (Usuarios usuario : todosUsuarios()) {
            if (usuarioNuevo.getUsuarioCorreo().equals(usuario.getUsuarioCorreo())) {
                mensajeError("Ya existe una cuenta con este correo");
                usuarioNuevo = new Usuarios();
                return;
            }
        }

        usuarioNuevo.setUsuarioFechaCreacion(fechaSistema);
        usuarioNuevo.setRolId(new Roles(1));
        usuarioNuevo.setUsuarioEstado(Boolean.TRUE);
        usuarioNuevo.setUsuarioUsuario(getUsuarioNuevo().getUsuarioCorreo());
        getUsuariosFacade().create(usuarioNuevo);
        usuarioNuevo = new Usuarios();

    }

    public void mensajeError(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Error!", mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

    public void editarHome() {

        getConfiguracionesFacade().edit(configuracionEditar);
        mensajeConfirmacion("La pagina de inicio se ha actualizado.");

    }

    //Método para verificar si ya existe el archivo a subir (promocion_editar.xhtml).
    public void existeArchivoEditar() {
        try {
            if ((fileSuperior != null) || (fileInferior != null) || (fileLogin != null)) {

                if (fileSuperior != null) {

                    FacesContext cty = FacesContext.getCurrentInstance();
                    String directorio = cty.getExternalContext().getInitParameter("directory_path_configurations");
                    File archivo1 = new File(directorio + "/" + getFileSuperior().getFileName() + "/");
                    if (archivo1.exists()) {
                        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Mensaje", "El archivo seleccionado ya existe para una promoción.");
                        RequestContext.getCurrentInstance().showMessageInDialog(message);
                    } else {
                        eliminarArchivoSuperior();
                        subeArchivoEditarSuperior(fileSuperior);
                    }
                }
                
                if (fileInferior != null) {

                    FacesContext cty = FacesContext.getCurrentInstance();
                    String directorio = cty.getExternalContext().getInitParameter("directory_path_configurations");
                    File archivo1 = new File(directorio + "/" + getFileInferior().getFileName() + "/");
                    if (archivo1.exists()) {
                        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Mensaje", "El archivo seleccionado ya existe para una promoción.");
                        RequestContext.getCurrentInstance().showMessageInDialog(message);
                    } else {
                        eliminarArchivoInferior();
                        subeArchivoEditarInferior(fileInferior);
                    }
                }
                
                if (fileLogin != null) {

                    FacesContext cty = FacesContext.getCurrentInstance();
                    String directorio = cty.getExternalContext().getInitParameter("directory_path_configurations");
                    File archivo1 = new File(directorio + "/" + getFileLogin().getFileName() + "/");
                    if (archivo1.exists()) {
                        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Mensaje", "El archivo seleccionado ya existe para una promoción.");
                        RequestContext.getCurrentInstance().showMessageInDialog(message);
                    } else {
                        eliminarArchivoLogin();
                        subeArchivoEditarLogin(fileLogin);
                    }
                }
                
                } else {
                    editarHome();
                }
            }catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: existeArchivoEditar.");
        }
        }
        //Método para eliminar un archivo (promocion_editar.xhtml).
    public void eliminarArchivoSuperior() throws FileNotFoundException {
        try {
            FacesContext cty = FacesContext.getCurrentInstance();
            String directorio = cty.getExternalContext().getInitParameter("directory_path_configurations");
            File archivoEliminar = new File(directorio + "/" + configuracionEditar.getConfiguracionImagenSuperior());
            System.out.println("Documento a eliminar: " + archivoEliminar);
            if (archivoEliminar.exists()) {
                System.out.println("El archivo existe.");
                if (archivoEliminar.delete()) {
                    System.out.println("El archivo se eliminó.");
                }
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: eliminarArchivo.");
        }
    }
    //Método para eliminar un archivo (promocion_editar.xhtml).
    public void eliminarArchivoInferior() throws FileNotFoundException {
        try {
            FacesContext cty = FacesContext.getCurrentInstance();
            String directorio = cty.getExternalContext().getInitParameter("directory_path_configurations");
            File archivoEliminar = new File(directorio + "/" + configuracionEditar.getConfiguracionImagenInferior());
            System.out.println("Documento a eliminar: " + archivoEliminar);
            if (archivoEliminar.exists()) {
                System.out.println("El archivo existe.");
                if (archivoEliminar.delete()) {
                    System.out.println("El archivo se eliminó.");
                }
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: eliminarArchivo.");
        }
    }
    
    //Método para eliminar un archivo (promocion_editar.xhtml).
    public void eliminarArchivoLogin() throws FileNotFoundException {
        try {
            FacesContext cty = FacesContext.getCurrentInstance();
            String directorio = cty.getExternalContext().getInitParameter("directory_path_configurations");
            File archivoEliminar = new File(directorio + "/" + configuracionEditar.getConfiguracionImagenLogin());
            System.out.println("Documento a eliminar: " + archivoEliminar);
            if (archivoEliminar.exists()) {
                System.out.println("El archivo existe.");
                if (archivoEliminar.delete()) {
                    System.out.println("El archivo se eliminó.");
                }
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: eliminarArchivo.");
        }
    }

    //Método que guarda el archivo seleccionado (promocion_editar.xhtml).
    public void subeArchivoEditarSuperior(UploadedFile file) throws InterruptedException {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String directorioArchivo = ctx.getExternalContext().getInitParameter("directory_path_configurations");
        String nombreArchivo = getFileSuperior().getFileName();
        int punto = nombreArchivo.lastIndexOf(".");
        String extension = nombreArchivo.substring(punto + 1, nombreArchivo.length());
        File archivoImagen = new File(directorioArchivo + "/" + getFileSuperior().getFileName());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivoImagen);
            byte[] buffer = new byte[BUFFER_SIZE];
            int bulk;
            InputStream inputStream = getFileSuperior().getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            inputStream.close();
            configuracionEditar.setConfiguracionImagenSuperior(getFileSuperior().getFileName());
            getConfiguracionesFacade().edit(configuracionEditar);
            Thread.sleep(6000);
            editarHome();
        } catch (IOException e) {
            mensajeError("Se detuvo el proceso en el método: subeArchivoEditar.");
        }
    }

    public void subeArchivoEditarInferior(UploadedFile file) throws InterruptedException {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String directorioArchivo = ctx.getExternalContext().getInitParameter("directory_path_configurations");
        String nombreArchivo = getFileInferior().getFileName();
        int punto = nombreArchivo.lastIndexOf(".");
        String extension = nombreArchivo.substring(punto + 1, nombreArchivo.length());
        File archivoImagen = new File(directorioArchivo + "/" + getFileInferior().getFileName());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivoImagen);
            byte[] buffer = new byte[BUFFER_SIZE];
            int bulk;
            InputStream inputStream = getFileInferior().getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            inputStream.close();
            configuracionEditar.setConfiguracionImagenInferior(getFileInferior().getFileName());
            getConfiguracionesFacade().edit(configuracionEditar);
            Thread.sleep(6000);
            editarHome();
        } catch (IOException e) {
            mensajeError("Se detuvo el proceso en el método: subeArchivoEditar.");
        }
    }
    public void subeArchivoEditarLogin(UploadedFile file) throws InterruptedException {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String directorioArchivo = ctx.getExternalContext().getInitParameter("directory_path_configurations");
        String nombreArchivo = getFileLogin().getFileName();
        int punto = nombreArchivo.lastIndexOf(".");
        String extension = nombreArchivo.substring(punto + 1, nombreArchivo.length());
        File archivoImagen = new File(directorioArchivo + "/" + getFileLogin().getFileName());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivoImagen);
            byte[] buffer = new byte[BUFFER_SIZE];
            int bulk;
            InputStream inputStream = getFileLogin().getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            inputStream.close();
            configuracionEditar.setConfiguracionImagenLogin(getFileLogin().getFileName());
            getConfiguracionesFacade().edit(configuracionEditar);
            Thread.sleep(6000);
            editarHome();
        } catch (IOException e) {
            mensajeError("Se detuvo el proceso en el método: subeArchivoEditar.");
        }
    }
    
    //Método para mostrar mensaje de guardado/actualizado/eliminado.
    public void mensajeConfirmacion(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

    public void cargaConfiguracion() {
        configuracionEditar = getConfiguracionesFacade().find(1);
    }

}
