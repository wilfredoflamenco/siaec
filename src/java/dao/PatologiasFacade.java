/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Patologias;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Stateless
public class PatologiasFacade extends AbstractFacade<Patologias> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PatologiasFacade() {
        super(Patologias.class);
    }
    
    public List<Patologias> patologiasDisponibles(boolean patologiaEstado){
        return getEntityManager().createNamedQuery("Patologias.findByPatologiaEstado").setParameter("patologiaEstado", patologiaEstado).getResultList();
    }
    
}
