/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrestaurant.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "res_empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResEmpleados.findAll", query = "SELECT r FROM ResEmpleados r"),
    @NamedQuery(name = "ResEmpleados.findByEmpId", query = "SELECT r FROM ResEmpleados r WHERE r.empId = :empId"),
    @NamedQuery(name = "ResEmpleados.findByEmpUsario", query = "SELECT r FROM ResEmpleados r WHERE r.empUsario = :empUsario"),
    @NamedQuery(name = "ResEmpleados.findByEmpClave", query = "SELECT r FROM ResEmpleados r WHERE r.empClave = :empClave"),
    @NamedQuery(name = "ResEmpleados.findByEmpNombre", query = "SELECT r FROM ResEmpleados r WHERE r.empNombre = :empNombre"),
    @NamedQuery(name = "ResEmpleados.findByEmpActivo", query = "SELECT r FROM ResEmpleados r WHERE r.empActivo = :empActivo")})
public class ResEmpleados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "emp_id")
    private Integer empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "emp_usario")
    private String empUsario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "emp_clave")
    private String empClave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "emp_nombre")
    private String empNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_activo")
    private boolean empActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpRecepcion")
    private List<ResCorteZ> resCorteZList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpRemesado")
    private List<ResCorteZ> resCorteZList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpRecibido")
    private List<ResCorteZ> resCorteZList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpIngreso")
    private List<ResCorteZ> resCorteZList3;
    @JoinColumn(name = "emp_rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private ResRoles empRolId;
    @OneToMany(mappedBy = "ordEmpleadoId")
    private List<ResCuentasOrdenes> resCuentasOrdenesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<ResCuentasDescuento> resCuentasDescuentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<ResCompras> resComprasList;

    public ResEmpleados() {
    }

    public ResEmpleados(Integer empId) {
        this.empId = empId;
    }

    public ResEmpleados(Integer empId, String empUsario, String empClave, String empNombre, boolean empActivo) {
        this.empId = empId;
        this.empUsario = empUsario;
        this.empClave = empClave;
        this.empNombre = empNombre;
        this.empActivo = empActivo;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpUsario() {
        return empUsario;
    }

    public void setEmpUsario(String empUsario) {
        this.empUsario = empUsario;
    }

    public String getEmpClave() {
        return empClave;
    }

    public void setEmpClave(String empClave) {
        this.empClave = empClave;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public boolean getEmpActivo() {
        return empActivo;
    }

    public void setEmpActivo(boolean empActivo) {
        this.empActivo = empActivo;
    }

    @XmlTransient
    public List<ResCorteZ> getResCorteZList() {
        return resCorteZList;
    }

    public void setResCorteZList(List<ResCorteZ> resCorteZList) {
        this.resCorteZList = resCorteZList;
    }

    @XmlTransient
    public List<ResCorteZ> getResCorteZList1() {
        return resCorteZList1;
    }

    public void setResCorteZList1(List<ResCorteZ> resCorteZList1) {
        this.resCorteZList1 = resCorteZList1;
    }

    @XmlTransient
    public List<ResCorteZ> getResCorteZList2() {
        return resCorteZList2;
    }

    public void setResCorteZList2(List<ResCorteZ> resCorteZList2) {
        this.resCorteZList2 = resCorteZList2;
    }

    @XmlTransient
    public List<ResCorteZ> getResCorteZList3() {
        return resCorteZList3;
    }

    public void setResCorteZList3(List<ResCorteZ> resCorteZList3) {
        this.resCorteZList3 = resCorteZList3;
    }

    public ResRoles getEmpRolId() {
        return empRolId;
    }

    public void setEmpRolId(ResRoles empRolId) {
        this.empRolId = empRolId;
    }

    @XmlTransient
    public List<ResCuentasOrdenes> getResCuentasOrdenesList() {
        return resCuentasOrdenesList;
    }

    public void setResCuentasOrdenesList(List<ResCuentasOrdenes> resCuentasOrdenesList) {
        this.resCuentasOrdenesList = resCuentasOrdenesList;
    }

    @XmlTransient
    public List<ResCuentasDescuento> getResCuentasDescuentoList() {
        return resCuentasDescuentoList;
    }

    public void setResCuentasDescuentoList(List<ResCuentasDescuento> resCuentasDescuentoList) {
        this.resCuentasDescuentoList = resCuentasDescuentoList;
    }

    @XmlTransient
    public List<ResCompras> getResComprasList() {
        return resComprasList;
    }

    public void setResComprasList(List<ResCompras> resComprasList) {
        this.resComprasList = resComprasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResEmpleados)) {
            return false;
        }
        ResEmpleados other = (ResEmpleados) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResEmpleados[ empId=" + empId + " ]";
    }
    
}
