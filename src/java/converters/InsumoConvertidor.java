/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import dao.InsumosFacade;
import entities.Insumos;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;


/**
 *
 * @author WilfredoFlamenco
 */
@Named(value = "insumoConvertidor")
@ManagedBean
@ViewScoped
public class InsumoConvertidor implements Converter{

    @EJB
    private InsumosFacade insumosFacade;
    
    public InsumoConvertidor() {
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                Insumos insu = getInsumosFacade().find(id);
                return insu;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "Seleccione un tratamiento."));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Insumos)) {
            return null;
        }
        return String.valueOf(((Insumos) value).getInsumoId());
    }

    public InsumosFacade getInsumosFacade() {
        return insumosFacade;
    }
    
}
