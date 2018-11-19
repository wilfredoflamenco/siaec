/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Existencias;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Stateless
public class ExistenciasFacade extends AbstractFacade<Existencias> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExistenciasFacade() {
        super(Existencias.class);
    }
    
    public Existencias existenciaPorInsumo(int sucursalId, int insumoId) {
        try {
            return (Existencias) getEntityManager().createNamedQuery("Existencias.findByExistenciaPorInsumo").setParameter("sucursalId", sucursalId).setParameter("insumoId", insumoId).getSingleResult();
        } catch (NoResultException e) { //Por si no encuentra ningun resultado que retorne cero
            return null;
        }
    }
        
    public List<Existencias> solicitudInsumos(){
        return getEntityManager().createNamedQuery("Existencias.findByExistenciaPorMinimo").getResultList();
    }
    
    public List<Existencias> solicitudInsumosAgotados(){
        double agotado = 0.0;
        return getEntityManager().createNamedQuery("Existencias.findByExistenciaAgotada").setParameter("agotado", agotado).getResultList();
    }
    
    public List<Existencias> solicitudInsumosPorAgotados(){
        double agotado = 0.0;
        return getEntityManager().createNamedQuery("Existencias.findByExistenciaPorAgotarse").setParameter("agotado", agotado).getResultList();
    }
    
}
