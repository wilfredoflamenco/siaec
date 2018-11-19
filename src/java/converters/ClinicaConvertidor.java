
package converters;

import dao.ClinicasFacade;
import entities.Clinicas;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

@Named(value = "clinicaConvertidor")
@ManagedBean
@ViewScoped
public class ClinicaConvertidor implements Converter, Serializable{
    
    @EJB 
    private ClinicasFacade clinicaFacade;
    
    public ClinicaConvertidor() {
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (  value.trim().equals("") || value.trim().equals("Seleccione uno...") || value.trim().equals("null") ) {
            //System.out.println("converters.ClinicaConvertidor.getAsObject()");
            return null;
        } else {
            try {
              //  System.out.println("converters.ClinicaConvertidor.getAsObject() Es el else");
                int id = Integer.parseInt(value);
                Clinicas clinica = getClinicaFacade().find(id);
                return clinica;
            } catch (Exception e) {
                System.err.print(e);
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "Seleccione una unidad de medida."));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Clinicas)) {
            //System.out.println("converters.ClinicaConvertidor.getAsString() ntancio clinica");
            return null;
        }
        //System.out.println("converters.ClinicaConvertidor.getAsString() retorno");
        return String.valueOf(((Clinicas) value).getClinicaId());
    }

    public ClinicasFacade getClinicaFacade() {
        return clinicaFacade;
    }
    
    
    
}
