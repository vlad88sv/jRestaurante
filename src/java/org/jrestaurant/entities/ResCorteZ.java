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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Entity
@Table(name = "res_corte_z")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResCorteZ.findAll", query = "SELECT r FROM ResCorteZ r"),
    @NamedQuery(name = "ResCorteZ.findByIdCorteZ", query = "SELECT r FROM ResCorteZ r WHERE r.idCorteZ = :idCorteZ"),
    @NamedQuery(name = "ResCorteZ.findByFechaInicio", query = "SELECT r FROM ResCorteZ r WHERE r.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "ResCorteZ.findByFechaFin", query = "SELECT r FROM ResCorteZ r WHERE r.fechaFin = :fechaFin"),
    @NamedQuery(name = "ResCorteZ.findByFechaRecibido", query = "SELECT r FROM ResCorteZ r WHERE r.fechaRecibido = :fechaRecibido"),
    @NamedQuery(name = "ResCorteZ.findByFechaRemesado", query = "SELECT r FROM ResCorteZ r WHERE r.fechaRemesado = :fechaRemesado"),
    @NamedQuery(name = "ResCorteZ.findByRevisionRecepcion", query = "SELECT r FROM ResCorteZ r WHERE r.revisionRecepcion = :revisionRecepcion"),
    @NamedQuery(name = "ResCorteZ.findByTotalCuadrar", query = "SELECT r FROM ResCorteZ r WHERE r.totalCuadrar = :totalCuadrar"),
    @NamedQuery(name = "ResCorteZ.findByTotalDescuentos", query = "SELECT r FROM ResCorteZ r WHERE r.totalDescuentos = :totalDescuentos"),
    @NamedQuery(name = "ResCorteZ.findByTotalDiferencia", query = "SELECT r FROM ResCorteZ r WHERE r.totalDiferencia = :totalDiferencia"),
    @NamedQuery(name = "ResCorteZ.findByTotalEfectivo", query = "SELECT r FROM ResCorteZ r WHERE r.totalEfectivo = :totalEfectivo"),
    @NamedQuery(name = "ResCorteZ.findByTotalPos", query = "SELECT r FROM ResCorteZ r WHERE r.totalPos = :totalPos"),
    @NamedQuery(name = "ResCorteZ.findByTotalCompras", query = "SELECT r FROM ResCorteZ r WHERE r.totalCompras = :totalCompras"),
    @NamedQuery(name = "ResCorteZ.findByTotalCaja", query = "SELECT r FROM ResCorteZ r WHERE r.totalCaja = :totalCaja")})
public class ResCorteZ implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_corte_z")
    private Integer idCorteZ;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_recibido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecibido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_remesado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRemesado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "revision_recepcion")
    private int revisionRecepcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_cuadrar")
    private BigDecimal totalCuadrar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_descuentos")
    private BigDecimal totalDescuentos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_diferencia")
    private BigDecimal totalDiferencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_efectivo")
    private BigDecimal totalEfectivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_pos")
    private BigDecimal totalPos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_compras")
    private BigDecimal totalCompras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_caja")
    private BigDecimal totalCaja;
    @JoinColumn(name = "id_emp_recepcion", referencedColumnName = "emp_id")
    @ManyToOne(optional = false)
    private ResEmpleados idEmpRecepcion;
    @JoinColumn(name = "id_emp_remesado", referencedColumnName = "emp_id")
    @ManyToOne(optional = false)
    private ResEmpleados idEmpRemesado;
    @JoinColumn(name = "id_emp_recibido", referencedColumnName = "emp_id")
    @ManyToOne(optional = false)
    private ResEmpleados idEmpRecibido;
    @JoinColumn(name = "id_emp_ingreso", referencedColumnName = "emp_id")
    @ManyToOne(optional = false)
    private ResEmpleados idEmpIngreso;

    public ResCorteZ() {
    }

    public ResCorteZ(Integer idCorteZ) {
        this.idCorteZ = idCorteZ;
    }

    public ResCorteZ(Integer idCorteZ, Date fechaInicio, Date fechaFin, Date fechaRecibido, Date fechaRemesado, int revisionRecepcion, BigDecimal totalCuadrar, BigDecimal totalDescuentos, BigDecimal totalDiferencia, BigDecimal totalEfectivo, BigDecimal totalPos, BigDecimal totalCompras, BigDecimal totalCaja) {
        this.idCorteZ = idCorteZ;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaRecibido = fechaRecibido;
        this.fechaRemesado = fechaRemesado;
        this.revisionRecepcion = revisionRecepcion;
        this.totalCuadrar = totalCuadrar;
        this.totalDescuentos = totalDescuentos;
        this.totalDiferencia = totalDiferencia;
        this.totalEfectivo = totalEfectivo;
        this.totalPos = totalPos;
        this.totalCompras = totalCompras;
        this.totalCaja = totalCaja;
    }

    public Integer getIdCorteZ() {
        return idCorteZ;
    }

    public void setIdCorteZ(Integer idCorteZ) {
        this.idCorteZ = idCorteZ;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public Date getFechaRemesado() {
        return fechaRemesado;
    }

    public void setFechaRemesado(Date fechaRemesado) {
        this.fechaRemesado = fechaRemesado;
    }

    public int getRevisionRecepcion() {
        return revisionRecepcion;
    }

    public void setRevisionRecepcion(int revisionRecepcion) {
        this.revisionRecepcion = revisionRecepcion;
    }

    public BigDecimal getTotalCuadrar() {
        return totalCuadrar;
    }

    public void setTotalCuadrar(BigDecimal totalCuadrar) {
        this.totalCuadrar = totalCuadrar;
    }

    public BigDecimal getTotalDescuentos() {
        return totalDescuentos;
    }

    public void setTotalDescuentos(BigDecimal totalDescuentos) {
        this.totalDescuentos = totalDescuentos;
    }

    public BigDecimal getTotalDiferencia() {
        return totalDiferencia;
    }

    public void setTotalDiferencia(BigDecimal totalDiferencia) {
        this.totalDiferencia = totalDiferencia;
    }

    public BigDecimal getTotalEfectivo() {
        return totalEfectivo;
    }

    public void setTotalEfectivo(BigDecimal totalEfectivo) {
        this.totalEfectivo = totalEfectivo;
    }

    public BigDecimal getTotalPos() {
        return totalPos;
    }

    public void setTotalPos(BigDecimal totalPos) {
        this.totalPos = totalPos;
    }

    public BigDecimal getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(BigDecimal totalCompras) {
        this.totalCompras = totalCompras;
    }

    public BigDecimal getTotalCaja() {
        return totalCaja;
    }

    public void setTotalCaja(BigDecimal totalCaja) {
        this.totalCaja = totalCaja;
    }

    public ResEmpleados getIdEmpRecepcion() {
        return idEmpRecepcion;
    }

    public void setIdEmpRecepcion(ResEmpleados idEmpRecepcion) {
        this.idEmpRecepcion = idEmpRecepcion;
    }

    public ResEmpleados getIdEmpRemesado() {
        return idEmpRemesado;
    }

    public void setIdEmpRemesado(ResEmpleados idEmpRemesado) {
        this.idEmpRemesado = idEmpRemesado;
    }

    public ResEmpleados getIdEmpRecibido() {
        return idEmpRecibido;
    }

    public void setIdEmpRecibido(ResEmpleados idEmpRecibido) {
        this.idEmpRecibido = idEmpRecibido;
    }

    public ResEmpleados getIdEmpIngreso() {
        return idEmpIngreso;
    }

    public void setIdEmpIngreso(ResEmpleados idEmpIngreso) {
        this.idEmpIngreso = idEmpIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorteZ != null ? idCorteZ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResCorteZ)) {
            return false;
        }
        ResCorteZ other = (ResCorteZ) object;
        if ((this.idCorteZ == null && other.idCorteZ != null) || (this.idCorteZ != null && !this.idCorteZ.equals(other.idCorteZ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResCorteZ[ idCorteZ=" + idCorteZ + " ]";
    }
    
}
