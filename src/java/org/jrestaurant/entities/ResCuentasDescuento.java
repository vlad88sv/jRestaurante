/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Entity
@Table(name = "res_cuentas_descuento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResCuentasDescuento.findAll", query = "SELECT r FROM ResCuentasDescuento r"),
    @NamedQuery(name = "ResCuentasDescuento.findByIdCuentasDesc", query = "SELECT r FROM ResCuentasDescuento r WHERE r.idCuentasDesc = :idCuentasDesc"),
    @NamedQuery(name = "ResCuentasDescuento.findByFechaIngreso", query = "SELECT r FROM ResCuentasDescuento r WHERE r.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "ResCuentasDescuento.findByRazonDescuento", query = "SELECT r FROM ResCuentasDescuento r WHERE r.razonDescuento = :razonDescuento")})
public class ResCuentasDescuento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuentas_desc")
    private Integer idCuentasDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "razon_descuento")
    private String razonDescuento;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "cue_id")
    @ManyToOne(optional = false)
    private ResCuentas idCuenta;
    @JoinColumn(name = "id_empleado", referencedColumnName = "emp_id")
    @ManyToOne(optional = false)
    private ResEmpleados idEmpleado;

    public ResCuentasDescuento() {
    }

    public ResCuentasDescuento(Integer idCuentasDesc) {
        this.idCuentasDesc = idCuentasDesc;
    }

    public ResCuentasDescuento(Integer idCuentasDesc, Date fechaIngreso, String razonDescuento) {
        this.idCuentasDesc = idCuentasDesc;
        this.fechaIngreso = fechaIngreso;
        this.razonDescuento = razonDescuento;
    }

    public Integer getIdCuentasDesc() {
        return idCuentasDesc;
    }

    public void setIdCuentasDesc(Integer idCuentasDesc) {
        this.idCuentasDesc = idCuentasDesc;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getRazonDescuento() {
        return razonDescuento;
    }

    public void setRazonDescuento(String razonDescuento) {
        this.razonDescuento = razonDescuento;
    }

    public ResCuentas getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(ResCuentas idCuenta) {
        this.idCuenta = idCuenta;
    }

    public ResEmpleados getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(ResEmpleados idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentasDesc != null ? idCuentasDesc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResCuentasDescuento)) {
            return false;
        }
        ResCuentasDescuento other = (ResCuentasDescuento) object;
        if ((this.idCuentasDesc == null && other.idCuentasDesc != null) || (this.idCuentasDesc != null && !this.idCuentasDesc.equals(other.idCuentasDesc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResCuentasDescuento[ idCuentasDesc=" + idCuentasDesc + " ]";
    }
    
}
