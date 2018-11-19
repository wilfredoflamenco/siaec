package converters;

import dao.PatologiasFacade;
import entities.Patologias;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

@Named(value = "patologiaConvertidor")
@ManagedBean
@ViewScoped
public class PatologiaConvertidor implements Converter{
    
    @EJB
    private PatologiasFacade patologiasFacade;
    
    public PatologiaConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                Patologias pat = getPatologiasFacade().find(id);
                return pat;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "Seleccione una patologia."));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Patologias)) {
            return null;
        }
        return String.valueOf(((Patologias) value).getPatologiaId());
    }
    
    public PatologiasFacade getPatologiasFacade() {
        return patologiasFacade;
    }
    
}
