/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.dao;

import java.util.ArrayList;
import java.util.Date;
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

    public ArrayList<ResCuentas> obtenerIDCuentasAbiertas() {
        Query query = em.createNamedQuery("ResCuentas.findByCueEstado");
        query.setParameter("cueEstado", 0); // 0 = cuentas abiertas
        ArrayList<ResCuentas> alResCuentas = (ArrayList) query.getResultList();
        return alResCuentas;
    }

    public ArrayList<ResCuentas> resCuentasfindAll() {
        Query query = em.createNamedQuery("ResCuentas.findAll");
        ArrayList<ResCuentas> alResCuentas = (ArrayList) query.getResultList();
        return alResCuentas;
    }

    public ArrayList<ResCuentas> resCuentasfindByCueId(int cueId) {
        Query query = em.createNamedQuery("ResCuentas.findByCueId");
        query.setParameter("cueId", cueId); 
        ArrayList<ResCuentas> alResCuentas = (ArrayList) query.getResultList();
        return alResCuentas;
    }

    public ArrayList<ResCuentas> resCuentasfindByCueEstado(int cueEstado) {
        Query query = em.createNamedQuery("ResCuentas.findByCueEstado");
        query.setParameter("cueEstado", cueEstado); 
        ArrayList<ResCuentas> alResCuentas = (ArrayList) query.getResultList();
        return alResCuentas;
    }

    public ArrayList<ResCuentas> resCuentasfindByCueMesa(int cueMesa) {
        Query query = em.createNamedQuery("ResCuentas.findByCueMesa");
        query.setParameter("findByCueMesa", cueMesa); 
        ArrayList<ResCuentas> alResCuentas = (ArrayList) query.getResultList();
        return alResCuentas;
    }

    public ArrayList<ResCuentas> resCuentasfindByCueFechaCreacion(Date cueFechaCreacion) {
        Query query = em.createNamedQuery("ResCuentas.findByCueFechaCreacion");
        query.setParameter("cueFechaCreacion", cueFechaCreacion); 
        ArrayList<ResCuentas> alResCuentas = (ArrayList) query.getResultList();
        return alResCuentas;
    }

    public ArrayList<ResCuentas> resCuentasfindByCueFechaCierre(Date cueFechaCierre) {
        Query query = em.createNamedQuery("ResCuentas.findByCueFechaCierre");
        query.setParameter("cueFechaCierre", cueFechaCierre); 
        ArrayList<ResCuentas> alResCuentas = (ArrayList) query.getResultList();
        return alResCuentas;
    }

    public ArrayList<ResCuentas> resCuentasfindByCueBanderaExentoIva(int cueBanderaExentoIva) {
        Query query = em.createNamedQuery("ResCuentas.findByCueBanderaExentoIva");
        query.setParameter("cueBanderaExentoIva", cueBanderaExentoIva); 
        ArrayList<ResCuentas> alResCuentas = (ArrayList) query.getResultList();
        return alResCuentas;
    }

    public ArrayList<ResCuentas> resCuentasfindByCueBanderaExentoPropina(int cueBanderaExentoPropina) {
        Query query = em.createNamedQuery("ResCuentas.findByCueBanderaExentoPropina");
        query.setParameter("cueBanderaExentoPropina", cueBanderaExentoPropina); 
        ArrayList<ResCuentas> alResCuentas = (ArrayList) query.getResultList();
        return alResCuentas;
    }

}
