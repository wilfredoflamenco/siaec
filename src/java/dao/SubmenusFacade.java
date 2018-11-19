/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Submenus;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Stateless
public class SubmenusFacade extends AbstractFacade<Submenus> {

    @PersistenceContext(unitName = "siaecPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubmenusFacade() {
        super(Submenus.class);
    }
    
    public List<Submenus> subMenuPorMenu(Integer menu_id) {
        return getEntityManager().createNamedQuery("Submenus.findMenu").setParameter("menu_id", menu_id).getResultList();
    }

}
