/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TiposInsumos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Stateless
public class TiposInsumosFacade extends AbstractFacade<TiposInsumos> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposInsumosFacade() {
        super(TiposInsumos.class);
    }
    
    public List<TiposInsumos> tiposInsumosDisponibles(boolean TipoInsumo){
        return getEntityManager().createNamedQuery("TiposInsumos.findByTipoinsumoEstado").setParameter("tipoinsumoEstado", TipoInsumo).getResultList();
    }
    
}
