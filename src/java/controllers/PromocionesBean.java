package controllers;

import dao.PromocionesFacade;
import entities.Promociones;
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

/* @author Equipo 19-2018 FIA-UES */
@Named(value = "promocionesBean")
@SessionScoped
public class PromocionesBean implements Serializable {

    @EJB
    private PromocionesFacade promocionesFacade;
    private Promociones promocionNuevo = new Promociones();
    private Promociones promocionConsultar = new Promociones();
    private Promociones promocionEditar = new Promociones();
    
    private UploadedFile file;
    private Date fechaSistema = new Date();
    
    public PromocionesBean() {
    }

    public List<Promociones> todasPromocionesDisponibles(){
        return getPromocionesFacade().promocionesDisponibles(Boolean.TRUE);
    }
    
    public PromocionesFacade getPromocionesFacade() {
        return promocionesFacade;
    }
    
    public Promociones getPromocionNuevo() {
        return promocionNuevo;
    }
    public void setPromocionNuevo(Promociones promocionNuevo) {
        this.promocionNuevo = promocionNuevo;
    }

    public Promociones getPromocionConsultar() {
        return promocionConsultar;
    }
    public void setPromocionConsultar(Promociones promocionConsultar) {
        this.promocionConsultar = promocionConsultar;
    }

    public Promociones getPromocionEditar() {
        return promocionEditar;
    }
    public void setPromocionEditar(Promociones promocionEditar) {
        this.promocionEditar = promocionEditar;
    }

    public UploadedFile getFile() {
        return file;
    }
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Date getFechaSistema() {
        return fechaSistema;
    }
    public void setFechaSistema(Date fechaSistema) {
        this.fechaSistema = fechaSistema;
    }
    
    //Método para inicializar los valores de fechas para promoción de tipo cumpleaños (promocion_nuevo.xhtml).
    public void inicializaFechasNuevo(){
        try{
            if(promocionNuevo.getPromocionTipo() == 2){
                Date fechaInicio = new Date();
                Date fechaFin = new Date();
                fechaInicio.setMonth(0);
                fechaInicio.setDate(1);
                fechaFin.setMonth(11);
                fechaFin.setDate(31);
                promocionNuevo.setPromocionInicio(fechaInicio);
                promocionNuevo.setPromocionFin(fechaFin);
            }
            else{
                promocionNuevo.setPromocionInicio(null);
                promocionNuevo.setPromocionFin(null);
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: inicializaFechasNuevo.");
        }
    }
    
    //Método para verificar si ya existe el archivo a subir (promocion_nuevo.xhtml).
    public void existeArchivoNuevo() {
        try{
            FacesContext cty = FacesContext.getCurrentInstance();
            String directorio = cty.getExternalContext().getInitParameter("directory_path_promotions");
            File archivo1 = new File(directorio + "/" + getFile().getFileName()+"/");
            if (archivo1.exists()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Mensaje", "El archivo seleccionado ya existe para una promoción.");
                RequestContext.getCurrentInstance().showMessageInDialog(message);
            }
            else{
                guardarPromocion();
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: existeArchivoNuevo.");
        }
    }
        
    //Método para guardar una Promoción (promocion_nuevo.xhtml).
    public void guardarPromocion(){
        try {
            promocionNuevo.setPromocionEstado(Boolean.TRUE);
            promocionNuevo.setPromocionUsuarioCreacion("Nombre Usuario");
            promocionNuevo.setPromocionFechaCreacion(new Date());
            promocionNuevo.setPromocionActiva(Boolean.TRUE);
            promocionNuevo.setPromocionCorreoLimitadoEspera(0);
            getPromocionesFacade().create(promocionNuevo);
            subeArchivoNuevo(file);
            promocionNuevo = new Promociones();
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: guardarPromocion.");
        }
    }
    
    //Método que guarda el archivo seleccionado (promocion_nuevo.xhtml).
    public void subeArchivoNuevo(UploadedFile file) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String directorioArchivo = ctx.getExternalContext().getInitParameter("directory_path_promotions");
        String nombreArchivo = getFile().getFileName();
        int punto = nombreArchivo.lastIndexOf(".");
        String extension = nombreArchivo.substring(punto + 1, nombreArchivo.length());
        File archivoImagen = new File(directorioArchivo + "/" + getFile().getFileName());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivoImagen);
            byte[] buffer = new byte[BUFFER_SIZE];
            int bulk;
            InputStream inputStream = getFile().getInputstream();
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
            promocionNuevo.setPromocionImagenNombre(getFile().getFileName());
            promocionNuevo.setPromocionImagenUrl(directorioArchivo + "/" + getFile().getFileName());
            getPromocionesFacade().edit(promocionNuevo);
            promocionNuevo = new Promociones();
            mensajeGuardado("La promoción se ha guardado.");
        } catch (IOException e) {
            mensajeError("Se detuvo el proceso en el método: subeArchivoNuevo.");
        }
    }

    //Método para inicializar los valores de fechas para promoción de tipo cumpleaños (promocion_editar.xhtml).
    public void inicializaFechasEditar(){
        try{
            if(promocionEditar.getPromocionTipo() == 2){
                Date fechaInicio = new Date();
                Date fechaFin = new Date();
                fechaInicio.setMonth(0);
                fechaInicio.setDate(1);
                fechaFin.setMonth(11);
                fechaFin.setDate(31);
                promocionEditar.setPromocionInicio(fechaInicio);
                promocionEditar.setPromocionFin(fechaFin);
            }
            else{
                promocionEditar.setPromocionInicio(null);
                promocionEditar.setPromocionFin(null);
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: inicializaFechasEditar.");
        }
    }
    
    //Método para verificar si ya existe el archivo a subir (promocion_editar.xhtml).
    public void existeArchivoEditar() {
        try{
            if(file != null){
                FacesContext cty = FacesContext.getCurrentInstance();
                String directorio = cty.getExternalContext().getInitParameter("directory_path_promotions");
                File archivo1 = new File(directorio + "/" + getFile().getFileName()+"/");
                if (archivo1.exists()) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Mensaje", "El archivo seleccionado ya existe para una promoción.");
                    RequestContext.getCurrentInstance().showMessageInDialog(message);
                }
                else{
                    eliminarArchivo();
                    subeArchivoEditar(file);
                }
            }
            else{
                editarPromocion();
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: existeArchivoEditar.");
        }
    }
        
    //Método para eliminar un archivo (promocion_editar.xhtml).
    public void eliminarArchivo() throws FileNotFoundException {
        try{
            File archivoEliminar = new File(promocionEditar.getPromocionImagenUrl());
            System.out.println("Documento a eliminar: "+archivoEliminar);
            if (archivoEliminar.exists()) {
                System.out.println("El archivo existe.");
                if (archivoEliminar.delete()) {
                    System.out.println("El archivo se eliminó.");
                }
            }
            else{
                System.out.println("El archivo no existe.");
            }
        } catch (Exception e){
            mensajeError("Se detuvo el proceso en el método: eliminarArchivo.");
        }
    }

    //Método que guarda el archivo seleccionado (promocion_editar.xhtml).
    public void subeArchivoEditar(UploadedFile file) throws InterruptedException {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String directorioArchivo = ctx.getExternalContext().getInitParameter("directory_path_promotions");
        String nombreArchivo = getFile().getFileName();
        int punto = nombreArchivo.lastIndexOf(".");
        String extension = nombreArchivo.substring(punto + 1, nombreArchivo.length());
        File archivoImagen = new File(directorioArchivo + "/" + getFile().getFileName());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivoImagen);
            byte[] buffer = new byte[BUFFER_SIZE];
            int bulk;
            InputStream inputStream = getFile().getInputstream();
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
            promocionEditar.setPromocionImagenNombre(getFile().getFileName());
            promocionEditar.setPromocionImagenUrl(directorioArchivo + "/" + getFile().getFileName());
            getPromocionesFacade().edit(promocionEditar);
            Thread.sleep(3000);
            editarPromocion();
        } catch (IOException e) {
            mensajeError("Se detuvo el proceso en el método: subeArchivoEditar.");
        }
    }

    //Método para editar una Promoción (promocion_editar.xhtml)
    public void editarPromocion(){
        try {
            promocionEditar.setPromocionUsuarioModificacion("Nombre Usuario");
            promocionEditar.setPromocionFechaModificacion(new Date());
            getPromocionesFacade().edit(promocionEditar);
            mensajeGuardado("La promoción se ha actualizado.");
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: editarPromocion.");
        }
    }

    //Método para eliminar una Promoción (promocion_eliminar_listado.xhtml)
    public void eliminarPromocion(){
        try{
            File archivoEliminar = new File(promocionEditar.getPromocionImagenUrl());
            System.out.println("Documento a eliminar: "+archivoEliminar);
            if (archivoEliminar.exists()) {
                System.out.println("El archivo existe.");
                if (archivoEliminar.delete()) {
                    System.out.println("El archivo se eliminó.");
                    promocionEditar.setPromocionImagenNombre("");
                    promocionEditar.setPromocionImagenUrl("");
                    promocionEditar.setPromocionEstado(Boolean.FALSE);
                    promocionEditar.setPromocionUsuarioModificacion("Nombre Usuario");
                    promocionEditar.setPromocionFechaModificacion(new Date());
                    getPromocionesFacade().edit(promocionEditar);
                    mensajeGuardado("La promoción se ha eliminado.");
                }
            }
            else{
                System.out.println("El archivo no existe.");
                promocionEditar.setPromocionImagenNombre("");
                promocionEditar.setPromocionImagenUrl("");
                promocionEditar.setPromocionEstado(Boolean.FALSE);
                promocionEditar.setPromocionUsuarioModificacion("Nombre Usuario");
                promocionEditar.setPromocionFechaModificacion(new Date());
                getPromocionesFacade().edit(promocionEditar);
                mensajeGuardado("La promoción se ha eliminado.");
            }
        } catch (Exception e){
            mensajeError("Se detuvo el proceso en el método: eliminarPromocion.");
        }
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