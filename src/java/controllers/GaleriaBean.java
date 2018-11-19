package controllers;

import dao.ImagenesFacade;
import entities.Imagenes;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

@Named(value = "galeriaBean")
@SessionScoped
public class GaleriaBean implements Serializable {

    @EJB
    private ImagenesFacade imagenesFacade;
    private List<Imagenes> fotos = new ArrayList<Imagenes>();

    public ImagenesFacade getImagenesFacade() {
        return imagenesFacade;
    }

    public List<Imagenes> getFotos() {
        return fotos;
    }
    public void setFotos(List<Imagenes> fotos) {
        this.fotos = fotos;
    }

    
    public GaleriaBean() {
    }

    public void listaFotosEvento() {
        System.out.println("Entra al método 1.");
        fotos = getImagenesFacade().findAll();
        System.out.println("Paso 1.");
        for (Imagenes f : fotos) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
            String nombreArchivo = f.getImagenId().toString() + ".jpg";
            String archivo = ("C:/Users/Fam. Gomez Aldana/Documents/NetBeansProjects/Smiling/web/temp/" + nombreArchivo);
            //String archivo = scontext.getContextPath().concat("/web/temp/" + nombreArchivo);
            creaArchivo(f.getImagenImagen(), archivo);
        }
    }

    public void creaArchivo(byte[] bytes, String archivo) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(archivo);
            fos.write(bytes);
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GaleriaBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GaleriaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
