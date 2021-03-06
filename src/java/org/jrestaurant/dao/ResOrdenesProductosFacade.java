/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jrestaurant.entities.ResOrdenesProductos;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Stateless
public class ResOrdenesProductosFacade extends AbstractFacade<ResOrdenesProductos> {
    @PersistenceContext(unitName = "MySQLPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResOrdenesProductosFacade() {
        super(ResOrdenesProductos.class);
    }
    
}
