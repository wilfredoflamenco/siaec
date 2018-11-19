package converters;

import dao.PromocionesFacade;
import entities.Promociones;
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

@Named(value = "promocionConvertidor")
@ManagedBean
@ViewScoped
public class PromocionConvertidor implements Converter {

    @EJB
    private PromocionesFacade promocionesFacade;

    public PromocionConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                Promociones promo = getPromocionesFacade().find(id);
                return promo;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "Seleccione una promoción."));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Promociones)) {
            return null;
        }
        return String.valueOf(((Promociones) value).getPromocionId());
    }
    
    public PromocionesFacade getPromocionesFacade() {
        return promocionesFacade;
    }
    
}
