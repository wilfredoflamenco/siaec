/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Clinicas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Stateless
public class ClinicasFacade extends AbstractFacade<Clinicas> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClinicasFacade() {
        super(Clinicas.class);
    }
    
    public List<Clinicas> clinicasDisponibles(boolean clinicaEstado){
        return getEntityManager().createNamedQuery("Clinicas.findByClinicaEstado").setParameter("clinicaEstado", clinicaEstado).getResultList();
    }
    
}
