/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "res_compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResCompras.findAll", query = "SELECT r FROM ResCompras r"),
    @NamedQuery(name = "ResCompras.findByIdCompras", query = "SELECT r FROM ResCompras r WHERE r.idCompras = :idCompras"),
    @NamedQuery(name = "ResCompras.findByProveedor", query = "SELECT r FROM ResCompras r WHERE r.proveedor = :proveedor"),
    @NamedQuery(name = "ResCompras.findByDescripcion", query = "SELECT r FROM ResCompras r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "ResCompras.findByMonto", query = "SELECT r FROM ResCompras r WHERE r.monto = :monto"),
    @NamedQuery(name = "ResCompras.findByFechaIngreso", query = "SELECT r FROM ResCompras r WHERE r.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "ResCompras.findByCentroCosto", query = "SELECT r FROM ResCompras r WHERE r.centroCosto = :centroCosto")})
public class ResCompras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compras")
    private Integer idCompras;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "proveedor")
    private String proveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "centro_costo")
    private String centroCosto;
    @JoinColumn(name = "id_empleado", referencedColumnName = "emp_id")
    @ManyToOne(optional = false)
    private ResEmpleados idEmpleado;

    public ResCompras() {
    }

    public ResCompras(Integer idCompras) {
        this.idCompras = idCompras;
    }

    public ResCompras(Integer idCompras, String proveedor, String descripcion, BigDecimal monto, Date fechaIngreso, String centroCosto) {
        this.idCompras = idCompras;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fechaIngreso = fechaIngreso;
        this.centroCosto = centroCosto;
    }

    public Integer getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(Integer idCompras) {
        this.idCompras = idCompras;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCentroCosto() {
        return centroCosto;
    }

    public void setCentroCosto(String centroCosto) {
        this.centroCosto = centroCosto;
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
        hash += (idCompras != null ? idCompras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResCompras)) {
            return false;
        }
        ResCompras other = (ResCompras) object;
        if ((this.idCompras == null && other.idCompras != null) || (this.idCompras != null && !this.idCompras.equals(other.idCompras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResCompras[ idCompras=" + idCompras + " ]";
    }
    
}
