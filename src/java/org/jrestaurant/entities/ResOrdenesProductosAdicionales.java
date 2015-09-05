/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Entity
@Table(name = "res_ordenes_productos_adicionales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResOrdenesProductosAdicionales.findAll", query = "SELECT r FROM ResOrdenesProductosAdicionales r"),
    @NamedQuery(name = "ResOrdenesProductosAdicionales.findByOpaId", query = "SELECT r FROM ResOrdenesProductosAdicionales r WHERE r.opaId = :opaId"),
    @NamedQuery(name = "ResOrdenesProductosAdicionales.findByOpaOperacion", query = "SELECT r FROM ResOrdenesProductosAdicionales r WHERE r.opaOperacion = :opaOperacion"),
    @NamedQuery(name = "ResOrdenesProductosAdicionales.findByOpaActivo", query = "SELECT r FROM ResOrdenesProductosAdicionales r WHERE r.opaActivo = :opaActivo"),
    @NamedQuery(name = "ResOrdenesProductosAdicionales.findByResOrdenesProductosAdicionalesOpaId", query = "SELECT r FROM ResOrdenesProductosAdicionales r WHERE r.resOrdenesProductosAdicionalesOpaId = :resOrdenesProductosAdicionalesOpaId")})
public class ResOrdenesProductosAdicionales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "opa_id")
    private Integer opaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "opa_operacion")
    private boolean opaOperacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "opa_activo")
    private boolean opaActivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "res_ordenes_productos_adicionales_opa_id")
    private int resOrdenesProductosAdicionalesOpaId;
    @JoinColumn(name = "opa_ordenes_producto_id", referencedColumnName = "orp_id")
    @ManyToOne
    private ResOrdenesProductos opaOrdenesProductoId;
    @JoinColumn(name = "opa_adicional_id", referencedColumnName = "adi_id")
    @ManyToOne
    private ResAdicionables opaAdicionalId;

    public ResOrdenesProductosAdicionales() {
    }

    public ResOrdenesProductosAdicionales(Integer opaId) {
        this.opaId = opaId;
    }

    public ResOrdenesProductosAdicionales(Integer opaId, boolean opaOperacion, boolean opaActivo, int resOrdenesProductosAdicionalesOpaId) {
        this.opaId = opaId;
        this.opaOperacion = opaOperacion;
        this.opaActivo = opaActivo;
        this.resOrdenesProductosAdicionalesOpaId = resOrdenesProductosAdicionalesOpaId;
    }

    public Integer getOpaId() {
        return opaId;
    }

    public void setOpaId(Integer opaId) {
        this.opaId = opaId;
    }

    public boolean getOpaOperacion() {
        return opaOperacion;
    }

    public void setOpaOperacion(boolean opaOperacion) {
        this.opaOperacion = opaOperacion;
    }

    public boolean getOpaActivo() {
        return opaActivo;
    }

    public void setOpaActivo(boolean opaActivo) {
        this.opaActivo = opaActivo;
    }

    public int getResOrdenesProductosAdicionalesOpaId() {
        return resOrdenesProductosAdicionalesOpaId;
    }

    public void setResOrdenesProductosAdicionalesOpaId(int resOrdenesProductosAdicionalesOpaId) {
        this.resOrdenesProductosAdicionalesOpaId = resOrdenesProductosAdicionalesOpaId;
    }

    public ResOrdenesProductos getOpaOrdenesProductoId() {
        return opaOrdenesProductoId;
    }

    public void setOpaOrdenesProductoId(ResOrdenesProductos opaOrdenesProductoId) {
        this.opaOrdenesProductoId = opaOrdenesProductoId;
    }

    public ResAdicionables getOpaAdicionalId() {
        return opaAdicionalId;
    }

    public void setOpaAdicionalId(ResAdicionables opaAdicionalId) {
        this.opaAdicionalId = opaAdicionalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opaId != null ? opaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResOrdenesProductosAdicionales)) {
            return false;
        }
        ResOrdenesProductosAdicionales other = (ResOrdenesProductosAdicionales) object;
        if ((this.opaId == null && other.opaId != null) || (this.opaId != null && !this.opaId.equals(other.opaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResOrdenesProductosAdicionales[ opaId=" + opaId + " ]";
    }
    
}
