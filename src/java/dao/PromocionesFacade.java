/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Promociones;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Stateless
public class PromocionesFacade extends AbstractFacade<Promociones> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromocionesFacade() {
        super(Promociones.class);
    }
    
    public List<Promociones> promocionesDisponibles(boolean promocionEstado){
        return getEntityManager().createNamedQuery("Promociones.findByPromocionEstado").setParameter("promocionEstado", promocionEstado).getResultList();
    }
    
    //Para correos Erick
    public List<Promociones> promocionesFechaMes() {
        return getEntityManager().createNamedQuery("Promociones.cumpleanyosMes").setParameter("fecha_actual", new Date()).getResultList();
    }
	
    public List<Promociones> promocionesEspeciales() {
        return getEntityManager().createNamedQuery("Promociones.promocionesEspeciales").setParameter("fecha_actual", new Date()).getResultList();
    }
	
    public List<Promociones> promocionesReinicioCumpAndEsp(){
        return getEntityManager().createNamedQuery("Promociones.promocionesReinicioEspAndCump").setParameter("fecha_actual", new Date()).getResultList();
    }

    //LISTA DE PROMOCIONES ENTRE DOS FECHAS EXISTENTES, PARA VALIDACION DE PROMOS DEMANDADAS
     public List<Promociones> findPromocionReport(Date fechainicio, Date fechafin){
        return getEntityManager().createNamedQuery("Promociones.findpromocionDemandaReport").setParameter("fechainicio", fechainicio).setParameter("fechafin", fechafin).getResultList();
    }
     
}
