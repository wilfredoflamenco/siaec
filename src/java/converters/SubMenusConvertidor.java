package converters;

import dao.SubmenusFacade;
import entities.Submenus;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

@Named(value = "subMenusConvertidor")
@ManagedBean
@ViewScoped
public class SubMenusConvertidor implements Converter {

    @EJB
    private SubmenusFacade subMenuFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                 int id = Integer.parseInt(value);
                 Submenus sub = getSubMenuFacade().find(id);
                return  sub;
            } catch (Exception e) {
                 throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "Seleccione un privilego."));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(!(value instanceof Submenus)){
            return null;
        }
        return String.valueOf(((Submenus) value).getSubmenuId());
    }

    public SubmenusFacade getSubMenuFacade() {
        return subMenuFacade;
    }

    
}
