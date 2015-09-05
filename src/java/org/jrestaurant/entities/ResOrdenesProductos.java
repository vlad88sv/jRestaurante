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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Entity
@Table(name = "res_ordenes_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResOrdenesProductos.findAll", query = "SELECT r FROM ResOrdenesProductos r"),
    @NamedQuery(name = "ResOrdenesProductos.findByOrpId", query = "SELECT r FROM ResOrdenesProductos r WHERE r.orpId = :orpId"),
    @NamedQuery(name = "ResOrdenesProductos.findByOrpActivo", query = "SELECT r FROM ResOrdenesProductos r WHERE r.orpActivo = :orpActivo")})
public class ResOrdenesProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orp_id")
    private Integer orpId;
    @Column(name = "orp_activo")
    private Boolean orpActivo;
    @JoinColumn(name = "orp_cuenta_ordenes_id", referencedColumnName = "ord_id")
    @ManyToOne
    private ResCuentasOrdenes orpCuentaOrdenesId;
    @JoinColumn(name = "orp_producto_id", referencedColumnName = "pro_id")
    @ManyToOne
    private ResProductos orpProductoId;
    @OneToMany(mappedBy = "opaOrdenesProductoId")
    private List<ResOrdenesProductosAdicionales> resOrdenesProductosAdicionalesList;

    public ResOrdenesProductos() {
    }

    public ResOrdenesProductos(Integer orpId) {
        this.orpId = orpId;
    }

    public Integer getOrpId() {
        return orpId;
    }

    public void setOrpId(Integer orpId) {
        this.orpId = orpId;
    }

    public Boolean getOrpActivo() {
        return orpActivo;
    }

    public void setOrpActivo(Boolean orpActivo) {
        this.orpActivo = orpActivo;
    }

    public ResCuentasOrdenes getOrpCuentaOrdenesId() {
        return orpCuentaOrdenesId;
    }

    public void setOrpCuentaOrdenesId(ResCuentasOrdenes orpCuentaOrdenesId) {
        this.orpCuentaOrdenesId = orpCuentaOrdenesId;
    }

    public ResProductos getOrpProductoId() {
        return orpProductoId;
    }

    public void setOrpProductoId(ResProductos orpProductoId) {
        this.orpProductoId = orpProductoId;
    }

    @XmlTransient
    public List<ResOrdenesProductosAdicionales> getResOrdenesProductosAdicionalesList() {
        return resOrdenesProductosAdicionalesList;
    }

    public void setResOrdenesProductosAdicionalesList(List<ResOrdenesProductosAdicionales> resOrdenesProductosAdicionalesList) {
        this.resOrdenesProductosAdicionalesList = resOrdenesProductosAdicionalesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orpId != null ? orpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResOrdenesProductos)) {
            return false;
        }
        ResOrdenesProductos other = (ResOrdenesProductos) object;
        if ((this.orpId == null && other.orpId != null) || (this.orpId != null && !this.orpId.equals(other.orpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResOrdenesProductos[ orpId=" + orpId + " ]";
    }
    
}
