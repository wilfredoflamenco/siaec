/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.UnidadesMedidas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Stateless
public class UnidadesMedidasFacade extends AbstractFacade<UnidadesMedidas> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadesMedidasFacade() {
        super(UnidadesMedidas.class);
    }
    
    public List<UnidadesMedidas> unidadesMedidasDisponibles(boolean unidadMedidaEstado){
        return getEntityManager().createNamedQuery("UnidadesMedidas.findByUnidadmedidaEstado").setParameter("unidadmedidaEstado", unidadMedidaEstado).getResultList();
    }
    
}
