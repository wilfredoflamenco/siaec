package converters;

import dao.UnidadesMedidasFacade;
import entities.UnidadesMedidas;
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
@Named(value = "unidadMedidaConvertidor")
@ManagedBean
@ViewScoped
public class UnidadMedidaConvertidor implements Converter{

    @EJB
    private UnidadesMedidasFacade unidadesMedidasFacade;

    public UnidadMedidaConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                UnidadesMedidas unidad = getUnidadesMedidasFacade().find(id);
                return unidad;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "Seleccione una unidad de medida."));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof UnidadesMedidas)) {
            return null;
        }
        return String.valueOf(((UnidadesMedidas) value).getUnidadmedidaId());
    }

    public UnidadesMedidasFacade getUnidadesMedidasFacade() {
        return unidadesMedidasFacade;
    }
    
}
