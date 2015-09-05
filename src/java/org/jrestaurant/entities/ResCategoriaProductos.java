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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "res_categoria_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResCategoriaProductos.findAll", query = "SELECT r FROM ResCategoriaProductos r"),
    @NamedQuery(name = "ResCategoriaProductos.findByCapId", query = "SELECT r FROM ResCategoriaProductos r WHERE r.capId = :capId"),
    @NamedQuery(name = "ResCategoriaProductos.findByCapCategoriaProducto", query = "SELECT r FROM ResCategoriaProductos r WHERE r.capCategoriaProducto = :capCategoriaProducto")})
public class ResCategoriaProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cap_id")
    private Integer capId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cap_categoria_producto")
    private String capCategoriaProducto;
    @OneToMany(mappedBy = "proProductoCategoriaId")
    private List<ResProductos> resProductosList;
    @JoinColumn(name = "cap_nodo_id", referencedColumnName = "nod_id")
    @ManyToOne
    private ResNodo capNodoId;
    @JoinColumn(name = "cap_menu_id", referencedColumnName = "men_id")
    @ManyToOne
    private ResMenu capMenuId;

    public ResCategoriaProductos() {
    }

    public ResCategoriaProductos(Integer capId) {
        this.capId = capId;
    }

    public ResCategoriaProductos(Integer capId, String capCategoriaProducto) {
        this.capId = capId;
        this.capCategoriaProducto = capCategoriaProducto;
    }

    public Integer getCapId() {
        return capId;
    }

    public void setCapId(Integer capId) {
        this.capId = capId;
    }

    public String getCapCategoriaProducto() {
        return capCategoriaProducto;
    }

    public void setCapCategoriaProducto(String capCategoriaProducto) {
        this.capCategoriaProducto = capCategoriaProducto;
    }

    @XmlTransient
    public List<ResProductos> getResProductosList() {
        return resProductosList;
    }

    public void setResProductosList(List<ResProductos> resProductosList) {
        this.resProductosList = resProductosList;
    }

    public ResNodo getCapNodoId() {
        return capNodoId;
    }

    public void setCapNodoId(ResNodo capNodoId) {
        this.capNodoId = capNodoId;
    }

    public ResMenu getCapMenuId() {
        return capMenuId;
    }

    public void setCapMenuId(ResMenu capMenuId) {
        this.capMenuId = capMenuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capId != null ? capId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResCategoriaProductos)) {
            return false;
        }
        ResCategoriaProductos other = (ResCategoriaProductos) object;
        if ((this.capId == null && other.capId != null) || (this.capId != null && !this.capId.equals(other.capId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResCategoriaProductos[ capId=" + capId + " ]";
    }
    
}
