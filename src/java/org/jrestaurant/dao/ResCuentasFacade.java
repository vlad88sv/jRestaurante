/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.dao;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.jrestaurant.entities.ResCuentas;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Stateless
public class ResCuentasFacade extends AbstractFacade<ResCuentas> {
    @PersistenceContext(unitName = "MySQLPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResCuentasFacade() {
        super(ResCuentas.class);
    }
 
    public ArrayList<ResCuentas> ObtenerIDCuentasAbiertas() {
       Query query = em.createNamedQuery("ResCuentas.findByCueEstado");
       query.setParameter("cueEstado", 0); // 0 = cuentas abiertas
       ArrayList<ResCuentas> alResCuentas = (ArrayList) query.getResultList();
       return alResCuentas;
    }
        
    
}
