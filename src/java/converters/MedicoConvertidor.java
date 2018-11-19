package converters;

import dao.MedicosFacade;
import entities.Medicos;
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

@Named(value = "medicoConvertidor")
@ManagedBean
@ViewScoped
public class MedicoConvertidor implements Converter {

    @EJB
    private MedicosFacade medicosFacade;
    
    public MedicoConvertidor() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                Medicos medico = getMedicosFacade().find(id);
                return medico;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "Seleccione un médico."));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Medicos)) {
            return null;
        }
        return String.valueOf(((Medicos) value).getMedicoId());
    }
     
    public MedicosFacade getMedicosFacade() {
        return medicosFacade;
    }
    
}
