/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Odontogramas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Stateless
public class OdontogramasFacade extends AbstractFacade<Odontogramas> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OdontogramasFacade() {
        super(Odontogramas.class);
    }
    
    //Método que obtiene un odontograma por paciente y código de pieza. (odontograma_consultar.xhtml)
    public Odontogramas odontogramaPorPiezaPaciente(int pacienteId, String piezaCodigo) {
        try {
            return (Odontogramas) getEntityManager().createNamedQuery("Odontogramas.findByOdontogramaPorPiezaPaciente").setParameter("pacienteId", pacienteId).setParameter("piezaCodigo", piezaCodigo).getSingleResult();
        } catch (NoResultException e) { //Por si no encuentra ningun resultado que retorne cero
            return null;
        }
    }
    
}
