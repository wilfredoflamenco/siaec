package converters;

import dao.MunicipiosFacade;
import entities.Municipios;
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
@Named(value = "municipioConvertidor")
@ManagedBean
@ViewScoped
public class MunicipioConvertidor implements Converter {

    @EJB
    private MunicipiosFacade municipiosFacade;

    public MunicipioConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                Municipios muni = getMunicipiosFacade().find(id);
                return muni;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "Municipio es requerido."));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Municipios)) {
            return null;
        }
        return String.valueOf(((Municipios) value).getMunicipioId());
    }

    public MunicipiosFacade getMunicipiosFacade() {
        return municipiosFacade;
    }

}
