/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Citas;
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
public class CitasFacade extends AbstractFacade<Citas> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitasFacade() {
        super(Citas.class);
    }
    
    public List<Citas> citasAtendidasEstado(Integer estadoId) {         //http://alejandroayala.solmedia.ec/?p=947
        List <Citas> results = getEntityManager().createNamedQuery("Citas.findByCitasTotalEstado").setParameter("idEstado", estadoId).getResultList();
        return results;
    }
    
    public List<Citas> citasRangoFecha(Date inicio, Date fin){
        List <Citas> results = getEntityManager().createNamedQuery("Citas.findByCitasMesEstado").setParameter("fecha_inferior", inicio).setParameter("fecha_superior", fin).getResultList();
        return results;
    }
    
    public List<Citas> citasAtendidasPorSucursal(Integer sucursalId, Integer estadoId) {
        //http://alejandroayala.solmedia.ec/?p=947
        List <Citas> results = getEntityManager().createNamedQuery("Citas.findByCitaAtendidaPorSucursal").setParameter("idClinica", sucursalId).setParameter("idEstado", estadoId).getResultList();
        return results;
    }
    
    public List<Citas> citasReservadoSucursal(Date fecha_cita, int clinica_id, Date citaHora) {
        return getEntityManager().createNamedQuery("Citas.reservadasClinica").setParameter("fecha_cita", fecha_cita).setParameter("clinica_id", clinica_id).setParameter("citaHora", citaHora).getResultList();
    }
    
    public List<Citas> citasProximas(Date fecha){
        return getEntityManager().createNamedQuery("Citas.programasFechaActual").setParameter("fecha_cita", fecha).getResultList();
    }
    
}
