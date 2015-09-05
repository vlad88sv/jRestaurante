/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Entity
@Table(name = "res_cuentas_ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResCuentasOrdenes.findAll", query = "SELECT r FROM ResCuentasOrdenes r"),
    @NamedQuery(name = "ResCuentasOrdenes.findByOrdId", query = "SELECT r FROM ResCuentasOrdenes r WHERE r.ordId = :ordId"),
    @NamedQuery(name = "ResCuentasOrdenes.findByOrdEstadoOrden", query = "SELECT r FROM ResCuentasOrdenes r WHERE r.ordEstadoOrden = :ordEstadoOrden"),
    @NamedQuery(name = "ResCuentasOrdenes.findByOrdFechatiempoIngreso", query = "SELECT r FROM ResCuentasOrdenes r WHERE r.ordFechatiempoIngreso = :ordFechatiempoIngreso")})
public class ResCuentasOrdenes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ord_id")
    private Integer ordId;
    @Column(name = "ord_estado_orden")
    private Boolean ordEstadoOrden;
    @Column(name = "ord_fechatiempo_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordFechatiempoIngreso;
    @OneToMany(mappedBy = "orpCuentaOrdenesId")
    private List<ResOrdenesProductos> resOrdenesProductosList;
    @JoinColumn(name = "ord_empleado_id", referencedColumnName = "emp_id")
    @ManyToOne
    private ResEmpleados ordEmpleadoId;
    @JoinColumn(name = "ord_cuenta_id", referencedColumnName = "cue_id")
    @ManyToOne
    private ResCuentas ordCuentaId;

    public ResCuentasOrdenes() {
    }

    public ResCuentasOrdenes(Integer ordId) {
        this.ordId = ordId;
    }

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public Boolean getOrdEstadoOrden() {
        return ordEstadoOrden;
    }

    public void setOrdEstadoOrden(Boolean ordEstadoOrden) {
        this.ordEstadoOrden = ordEstadoOrden;
    }

    public Date getOrdFechatiempoIngreso() {
        return ordFechatiempoIngreso;
    }

    public void setOrdFechatiempoIngreso(Date ordFechatiempoIngreso) {
        this.ordFechatiempoIngreso = ordFechatiempoIngreso;
    }

    @XmlTransient
    public List<ResOrdenesProductos> getResOrdenesProductosList() {
        return resOrdenesProductosList;
    }

    public void setResOrdenesProductosList(List<ResOrdenesProductos> resOrdenesProductosList) {
        this.resOrdenesProductosList = resOrdenesProductosList;
    }

    public ResEmpleados getOrdEmpleadoId() {
        return ordEmpleadoId;
    }

    public void setOrdEmpleadoId(ResEmpleados ordEmpleadoId) {
        this.ordEmpleadoId = ordEmpleadoId;
    }

    public ResCuentas getOrdCuentaId() {
        return ordCuentaId;
    }

    public void setOrdCuentaId(ResCuentas ordCuentaId) {
        this.ordCuentaId = ordCuentaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordId != null ? ordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResCuentasOrdenes)) {
            return false;
        }
        ResCuentasOrdenes other = (ResCuentasOrdenes) object;
        if ((this.ordId == null && other.ordId != null) || (this.ordId != null && !this.ordId.equals(other.ordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResCuentasOrdenes[ ordId=" + ordId + " ]";
    }
    
}
