/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jrestaurant.entities.ResNodo;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Query;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Stateless
public class ResNodoFacade extends AbstractFacade<ResNodo> {
    @PersistenceContext(unitName = "MySQLPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResNodoFacade() {
        super(ResNodo.class);
    }
    
    public ArrayList<ResNodo> ResNodoFindAll() {
        Query query = em.createNamedQuery("ResNodo.findAll");
        ArrayList<ResNodo> alResNodo = (ArrayList) query.getResultList();
        return alResNodo;
    }
    
    public ArrayList<ResNodo> ResNodoFindByNodId(Integer nodId) {
        Query query = em.createNamedQuery("ResNodo.findByNodId");
        query.setParameter("nodId", nodId);
        ArrayList<ResNodo> alResNodo = (ArrayList) query.getResultList();
        return alResNodo;
    }
    
    
    public ArrayList<ResNodo> ResNodoFindByNodNodo(String nodNodo) {
        Query query = em.createNamedQuery("ResNodo.findByNodNodo");
        query.setParameter("nodNodo", nodNodo);
        ArrayList<ResNodo> alResNodo = (ArrayList) query.getResultList();
        return alResNodo;
    }
    
    public ArrayList<ResNodo> ResNodoFindByNodActivo(boolean nodActivo) {
        Query query = em.createNamedQuery("ResNodo.findByNodActivo");
        query.setParameter("nodActivo", nodActivo);
        ArrayList<ResNodo> alResNodo = (ArrayList) query.getResultList();
        return alResNodo;
    }
    
    
}
