package converters;

import dao.TratamientosFacade;
import entities.Tratamientos;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

/* @author Equipo 19-2018 FIA-UES */
@Named(value = "tratamientoConvertidor")
@ManagedBean
@ViewScoped
public class TratamientoConvertidor implements Converter {

    @EJB
    private TratamientosFacade tratamientosFacade;

    public TratamientoConvertidor() {
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                Tratamientos trata = getTratamientosFacade().find(id);
                return trata;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "Seleccione un tratamiento."));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Tratamientos)) {
            return null;
        }
        return String.valueOf(((Tratamientos) value).getTratamientoId());
    }

    public TratamientosFacade getTratamientosFacade() {
        return tratamientosFacade;
    }

}
