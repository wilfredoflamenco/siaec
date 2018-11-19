/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Tratamientos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Stateless
public class TratamientosFacade extends AbstractFacade<Tratamientos> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TratamientosFacade() {
        super(Tratamientos.class);
    }
    
    public List<Tratamientos> tratamientosDisponibles(boolean tratamientoEstado){
        return getEntityManager().createNamedQuery("Tratamientos.findByTratamientoEstado").setParameter("tratamientoEstado", tratamientoEstado).getResultList();
    }
    
}
