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
import org.jrestaurant.entities.ResEmpleados;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Stateless
public class ResEmpleadosFacade extends AbstractFacade<ResEmpleados> {
    @PersistenceContext(unitName = "MySQLPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResEmpleadosFacade() {
        super(ResEmpleados.class);
    }
    
    public ArrayList<ResEmpleados> resEmpleadosFindAll() {
        Query query = em.createNamedQuery("ResEmpleados.findAll");
        ArrayList<ResEmpleados> alResEmpleados = (ArrayList) query.getResultList();
        return alResEmpleados;
    }
    
    public ArrayList<ResEmpleados> resEmpleadosFindByEmpId(int empId) {
        Query query = em.createNamedQuery("ResEmpleados.findByEmpId");
        query.setParameter("empId", empId); 
        ArrayList<ResEmpleados> alResEmpleados = (ArrayList) query.getResultList();
        return alResEmpleados;
    }
    
    public ArrayList<ResEmpleados> resEmpleadosFindByEmpUsario(String empUsario) {
        Query query = em.createNamedQuery("ResEmpleados.findByEmpUsario");
        query.setParameter("empUsario", empUsario); 
        ArrayList<ResEmpleados> alResEmpleados = (ArrayList) query.getResultList();
        return alResEmpleados;
    }
    
    public ArrayList<ResEmpleados> resEmpleadosFindByEmpClave(String empClave) {
        Query query = em.createNamedQuery("ResEmpleados.findByEmpClave");
        query.setParameter("empClave", empClave); 
        ArrayList<ResEmpleados> alResEmpleados = (ArrayList) query.getResultList();
        return alResEmpleados;
    }

    public ArrayList<ResEmpleados> resEmpleadosFindByEmpNombre(String empNombre) {
        Query query = em.createNamedQuery("ResEmpleados.findByEmpNombre");
        query.setParameter("empNombre", empNombre); 
        ArrayList<ResEmpleados> alResEmpleados = (ArrayList) query.getResultList();
        return alResEmpleados;
    }
       
    public ArrayList<ResEmpleados> resEmpleadosFindByEmpActivo(boolean empActivo) {
        Query query = em.createNamedQuery("ResEmpleados.findByEmpActivo");
        query.setParameter("empActivo", empActivo); 
        ArrayList<ResEmpleados> alResEmpleados = (ArrayList) query.getResultList();
        return alResEmpleados;
    }

}
