/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.DetallesConsultas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Stateless
public class DetallesConsultasFacade extends AbstractFacade<DetallesConsultas> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallesConsultasFacade() {
        super(DetallesConsultas.class);
    }
    
    //Método que obtiene lista de detalles de consultas por paciente. (odontograma_gestionar.xhtml)
    public List<DetallesConsultas> detalleConsultaPorPaciente(int pacienteId) {
        return getEntityManager().createNamedQuery("DetallesConsultas.findByDetalleconsultaPorPaciente").setParameter("pacienteId", pacienteId).getResultList();
    }
    
}
