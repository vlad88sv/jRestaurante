/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jrestaurant.entities.ResMenu;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Query;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Stateless
public class ResMenuFacade extends AbstractFacade<ResMenu> {
    @PersistenceContext(unitName = "MySQLPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResMenuFacade() {
        super(ResMenu.class);
    }
    
    public ArrayList<ResMenu> resMenuFindAll() {
        Query query = em.createNamedQuery("ResMenu.findAll");
        ArrayList<ResMenu> alResMenu = (ArrayList) query.getResultList();
        return alResMenu;
    }
    
    public ArrayList<ResMenu> resMenuFindByMenId(Integer menId) {
        Query query = em.createNamedQuery("ResMenu.findByMenId");
        query.setParameter("menId", menId); 
        ArrayList<ResMenu> alResMenu = (ArrayList) query.getResultList();
        return alResMenu;
    }
    
    public ArrayList<ResMenu> resMenuFindByMenMenu(String menMenu) {
        Query query = em.createNamedQuery("ResMenu.findByMenMenu");
        query.setParameter("menMenu", menMenu); 
        ArrayList<ResMenu> alResMenu = (ArrayList) query.getResultList();
        return alResMenu;
    }
    
    public ArrayList<ResMenu> resMenuFindByMenActivo(boolean menActivo) {
        Query query = em.createNamedQuery("ResMenu.findByMenActivo");
        query.setParameter("menActivo", menActivo); 
        ArrayList<ResMenu> alResMenu = (ArrayList) query.getResultList();
        return alResMenu;
    }
    
}
