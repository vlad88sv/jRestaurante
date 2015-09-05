/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Entity
@Table(name = "res_nodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResNodo.findAll", query = "SELECT r FROM ResNodo r"),
    @NamedQuery(name = "ResNodo.findByNodId", query = "SELECT r FROM ResNodo r WHERE r.nodId = :nodId"),
    @NamedQuery(name = "ResNodo.findByNodNodo", query = "SELECT r FROM ResNodo r WHERE r.nodNodo = :nodNodo"),
    @NamedQuery(name = "ResNodo.findByNodActivo", query = "SELECT r FROM ResNodo r WHERE r.nodActivo = :nodActivo")})
public class ResNodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nod_id")
    private Integer nodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nod_nodo")
    private String nodNodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nod_activo")
    private boolean nodActivo;
    @OneToMany(mappedBy = "capNodoId")
    private List<ResCategoriaProductos> resCategoriaProductosList;

    public ResNodo() {
    }

    public ResNodo(Integer nodId) {
        this.nodId = nodId;
    }

    public ResNodo(Integer nodId, String nodNodo, boolean nodActivo) {
        this.nodId = nodId;
        this.nodNodo = nodNodo;
        this.nodActivo = nodActivo;
    }

    public Integer getNodId() {
        return nodId;
    }

    public void setNodId(Integer nodId) {
        this.nodId = nodId;
    }

    public String getNodNodo() {
        return nodNodo;
    }

    public void setNodNodo(String nodNodo) {
        this.nodNodo = nodNodo;
    }

    public boolean getNodActivo() {
        return nodActivo;
    }

    public void setNodActivo(boolean nodActivo) {
        this.nodActivo = nodActivo;
    }

    @XmlTransient
    public List<ResCategoriaProductos> getResCategoriaProductosList() {
        return resCategoriaProductosList;
    }

    public void setResCategoriaProductosList(List<ResCategoriaProductos> resCategoriaProductosList) {
        this.resCategoriaProductosList = resCategoriaProductosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nodId != null ? nodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResNodo)) {
            return false;
        }
        ResNodo other = (ResNodo) object;
        if ((this.nodId == null && other.nodId != null) || (this.nodId != null && !this.nodId.equals(other.nodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResNodo[ nodId=" + nodId + " ]";
    }
    
}
