/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Imagenes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Stateless
public class ImagenesFacade extends AbstractFacade<Imagenes> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImagenesFacade() {
        super(Imagenes.class);
    }
    
    //Método que obtiene lista de imágenes por paciente. (imagenes_gestionar.xhtml)
    public List<Imagenes> todasImagenesPorPaciente(int pacienteId) {
        return getEntityManager().createNamedQuery("Imagenes.findByImagenesPorPaciente").setParameter("pacienteId", pacienteId).getResultList();
    }
    
}
