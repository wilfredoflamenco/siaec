/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Consultas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Stateless
public class ConsultasFacade extends AbstractFacade<Consultas> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultasFacade() {
        super(Consultas.class);
    }
    
    //Método que obtiene lista de consultas por paciente. (consultas_listado_consultar.xhtml y consultas_listado_gestionar.xhtml)
    public List<Consultas> todosPacientesPorPaciente(int pacienteId) {
        return getEntityManager().createNamedQuery("Consultas.findByConsultasPorPaciente").setParameter("pacienteId", pacienteId).getResultList();
    }
    
}
