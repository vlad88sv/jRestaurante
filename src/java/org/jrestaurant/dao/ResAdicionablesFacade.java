/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jrestaurant.entities.ResAdicionables;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Stateless
public class ResAdicionablesFacade extends AbstractFacade<ResAdicionables> {
    @PersistenceContext(unitName = "MySQLPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResAdicionablesFacade() {
        super(ResAdicionables.class);
    }
    
}
