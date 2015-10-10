/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jrestaurant.entities.ResOrdenesProductosAdicionales;


import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Query;
/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Stateless
public class ResOrdenesProductosAdicionalesFacade extends AbstractFacade<ResOrdenesProductosAdicionales> {
    @PersistenceContext(unitName = "MySQLPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResOrdenesProductosAdicionalesFacade() {
        super(ResOrdenesProductosAdicionales.class);
    }
    
    public ArrayList<ResOrdenesProductosAdicionales> ResOrdenesProductosAdicionalesFindAll() {
        Query query = em.createNamedQuery("ResOrdenesProductosAdicionales.findAll");
        ArrayList<ResOrdenesProductosAdicionales> alResOrdenesProductosAdicionales = (ArrayList) query.getResultList();
        return alResOrdenesProductosAdicionales;
    }
    
    public ArrayList<ResOrdenesProductosAdicionales> ResOrdenesProductosAdicionalesFindByOpaId(Integer opaId) {
        Query query = em.createNamedQuery("ResOrdenesProductosAdicionales.findByOpaId");
        query.setParameter("opaId", opaId);
        ArrayList<ResOrdenesProductosAdicionales> alResOrdenesProductosAdicionales = (ArrayList) query.getResultList();
        return alResOrdenesProductosAdicionales;
    } 
    
    public ArrayList<ResOrdenesProductosAdicionales> ResOrdenesProductosAdicionalesFindByOpaOperacion(boolean opaOperacion) {
        Query query = em.createNamedQuery("ResOrdenesProductosAdicionales.findByOpaOperacion");
        query.setParameter("opaOperacion", opaOperacion);
        ArrayList<ResOrdenesProductosAdicionales> alResOrdenesProductosAdicionales = (ArrayList) query.getResultList();
        return alResOrdenesProductosAdicionales;
    }
    
    public ArrayList<ResOrdenesProductosAdicionales> ResOrdenesProductosAdicionalesFindByOpaActivo(boolean opaActivo) {
        Query query = em.createNamedQuery("ResOrdenesProductosAdicionales.findByOpaActivo");
        query.setParameter("opaOperacion", opaActivo);
        ArrayList<ResOrdenesProductosAdicionales> alResOrdenesProductosAdicionales = (ArrayList) query.getResultList();
        return alResOrdenesProductosAdicionales;
    }  
    
    public ArrayList<ResOrdenesProductosAdicionales> ResOrdenesProductosAdicionalesFindByResOrdenesProductosAdicionalesOpaId(int resOrdenesProductosAdicionalesOpaId) {
        Query query = em.createNamedQuery("ResOrdenesProductosAdicionales.findByResOrdenesProductosAdicionalesOpaId");
        query.setParameter("resOrdenesProductosAdicionalesOpaId", resOrdenesProductosAdicionalesOpaId);
        ArrayList<ResOrdenesProductosAdicionales> alResOrdenesProductosAdicionales = (ArrayList) query.getResultList();
        return alResOrdenesProductosAdicionales;
    }     
    
}
