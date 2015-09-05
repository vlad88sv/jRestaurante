/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Entity
@Table(name = "res_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResProductos.findAll", query = "SELECT r FROM ResProductos r"),
    @NamedQuery(name = "ResProductos.findByProId", query = "SELECT r FROM ResProductos r WHERE r.proId = :proId"),
    @NamedQuery(name = "ResProductos.findByProProducto", query = "SELECT r FROM ResProductos r WHERE r.proProducto = :proProducto"),
    @NamedQuery(name = "ResProductos.findByProPrecio", query = "SELECT r FROM ResProductos r WHERE r.proPrecio = :proPrecio"),
    @NamedQuery(name = "ResProductos.findByProActivo", query = "SELECT r FROM ResProductos r WHERE r.proActivo = :proActivo")})
public class ResProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer proId;
    @Size(max = 50)
    @Column(name = "pro_producto")
    private String proProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pro_precio")
    private BigDecimal proPrecio;
    @Column(name = "pro_activo")
    private Boolean proActivo;
    @OneToMany(mappedBy = "orpProductoId")
    private List<ResOrdenesProductos> resOrdenesProductosList;
    @JoinColumn(name = "pro_producto_categoria_id", referencedColumnName = "cap_id")
    @ManyToOne
    private ResCategoriaProductos proProductoCategoriaId;

    public ResProductos() {
    }

    public ResProductos(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProProducto() {
        return proProducto;
    }

    public void setProProducto(String proProducto) {
        this.proProducto = proProducto;
    }

    public BigDecimal getProPrecio() {
        return proPrecio;
    }

    public void setProPrecio(BigDecimal proPrecio) {
        this.proPrecio = proPrecio;
    }

    public Boolean getProActivo() {
        return proActivo;
    }

    public void setProActivo(Boolean proActivo) {
        this.proActivo = proActivo;
    }

    @XmlTransient
    public List<ResOrdenesProductos> getResOrdenesProductosList() {
        return resOrdenesProductosList;
    }

    public void setResOrdenesProductosList(List<ResOrdenesProductos> resOrdenesProductosList) {
        this.resOrdenesProductosList = resOrdenesProductosList;
    }

    public ResCategoriaProductos getProProductoCategoriaId() {
        return proProductoCategoriaId;
    }

    public void setProProductoCategoriaId(ResCategoriaProductos proProductoCategoriaId) {
        this.proProductoCategoriaId = proProductoCategoriaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResProductos)) {
            return false;
        }
        ResProductos other = (ResProductos) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResProductos[ proId=" + proId + " ]";
    }
    
}
