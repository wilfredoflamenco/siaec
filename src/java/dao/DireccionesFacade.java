/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Direcciones;
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
public class DireccionesFacade extends AbstractFacade<Direcciones> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionesFacade() {
        super(Direcciones.class);
    }
    
    //Método que obtiene una dirección por sucursal. (cat_sucursal_consultar.xhtml)
    public Direcciones direccionPorSucursal(int sucursalId) {
        try {
            return (Direcciones) getEntityManager().createNamedQuery("Direcciones.findByDireccionPorSucursal").setParameter("sucursalId", sucursalId).getSingleResult();
        } catch (NoResultException e) { //Por si no encuentra ningun resultado que retorne cero
            return null;
        }
    }
    
    //Método que obtiene una dirección por medico. (cat_medico_consultar.xhtml)
    public Direcciones direccionPorMedico(int medicoId) {
        try {
            return (Direcciones) getEntityManager().createNamedQuery("Direcciones.findByDireccionPorMedico").setParameter("medicoId", medicoId).getSingleResult();
        } catch (NoResultException e) { //Por si no encuentra ningun resultado que retorne cero
            return null;
        }
    }
    
    //Método que obtiene una dirección por paciente. (.xhtml)
    public Direcciones direccionPorPaciente(int pacienteId) {
        try {
            return (Direcciones) getEntityManager().createNamedQuery("Direcciones.findByDireccionPorPaciente").setParameter("pacienteId", pacienteId).getSingleResult();
        } catch (NoResultException e) { //Por si no encuentra ningun resultado que retorne cero
            return null;
        }
    }
    
    public Direcciones DireccionDePaciente(Integer pacienteId) {
        //http://alejandroayala.solmedia.ec/?p=947
        List <Direcciones> results = getEntityManager().createNamedQuery("Direcciones.findByPacienteDireccion").setParameter("pacienteId", pacienteId).getResultList();
        Direcciones foundEntity = null;
        if (!results.isEmpty()) {
        // ignores multiple results
            foundEntity = results.get(0);
        }
        return foundEntity;
    }
    
}
