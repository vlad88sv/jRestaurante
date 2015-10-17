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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vladimir Hidalgo <vladimiroski@gmail.com>
 */
@Entity
@Table(name = "res_cuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResCuentas.findAll", query = "SELECT r FROM ResCuentas r"),
    @NamedQuery(name = "ResCuentas.findByCueId", query = "SELECT r FROM ResCuentas r WHERE r.cueId = :cueId"),
    @NamedQuery(name = "ResCuentas.findByCueEstado", query = "SELECT r FROM ResCuentas r WHERE r.cueEstado = :cueEstado"),
    @NamedQuery(name = "ResCuentas.findByCueMesa", query = "SELECT r FROM ResCuentas r WHERE r.cueMesa = :cueMesa"),
    @NamedQuery(name = "ResCuentas.findByCueFechaCreacion", query = "SELECT r FROM ResCuentas r WHERE r.cueFechaCreacion = :cueFechaCreacion"),
    @NamedQuery(name = "ResCuentas.findByCueFechaCierre", query = "SELECT r FROM ResCuentas r WHERE r.cueFechaCierre = :cueFechaCierre"),
    @NamedQuery(name = "ResCuentas.findByCueBanderaExentoIva", query = "SELECT r FROM ResCuentas r WHERE r.cueBanderaExentoIva = :cueBanderaExentoIva"),
    @NamedQuery(name = "ResCuentas.findByCueBanderaExentoPropina", query = "SELECT r FROM ResCuentas r WHERE r.cueBanderaExentoPropina = :cueBanderaExentoPropina")})
public class ResCuentas implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cue_mesa")
    private String cueMesa;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cue_id")
    private Integer cueId;
    @Column(name = "cue_estado")
    private Boolean cueEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cue_fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cueFechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cue_fecha_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cueFechaCierre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cue_bandera_exento_iva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cueBanderaExentoIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cue_bandera_exento_propina")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cueBanderaExentoPropina;
    
    @OneToMany(mappedBy = "ordCuentaId")
    private List<ResCuentasOrdenes> resCuentasOrdenesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuenta")
    private List<ResCuentasDescuento> resCuentasDescuentoList;

    public ResCuentas() {
    }

    public ResCuentas(Integer cueId) {
        this.cueId = cueId;
    }

    public ResCuentas(Integer cueId, Date cueFechaCreacion, Date cueFechaCierre, Date cueBanderaExentoIva, Date cueBanderaExentoPropina) {
        this.cueId = cueId;
        this.cueFechaCreacion = cueFechaCreacion;
        this.cueFechaCierre = cueFechaCierre;
        this.cueBanderaExentoIva = cueBanderaExentoIva;
        this.cueBanderaExentoPropina = cueBanderaExentoPropina;
    }

    public Integer getCueId() {
        return cueId;
    }

    public void setCueId(Integer cueId) {
        this.cueId = cueId;
    }

    public Boolean getCueEstado() {
        return cueEstado;
    }

    public void setCueEstado(Boolean cueEstado) {
        this.cueEstado = cueEstado;
    }

    public Date getCueFechaCreacion() {
        return cueFechaCreacion;
    }

    public void setCueFechaCreacion(Date cueFechaCreacion) {
        this.cueFechaCreacion = cueFechaCreacion;
    }

    public Date getCueFechaCierre() {
        return cueFechaCierre;
    }

    public void setCueFechaCierre(Date cueFechaCierre) {
        this.cueFechaCierre = cueFechaCierre;
    }

    public Date getCueBanderaExentoIva() {
        return cueBanderaExentoIva;
    }

    public void setCueBanderaExentoIva(Date cueBanderaExentoIva) {
        this.cueBanderaExentoIva = cueBanderaExentoIva;
    }

    public Date getCueBanderaExentoPropina() {
        return cueBanderaExentoPropina;
    }

    public void setCueBanderaExentoPropina(Date cueBanderaExentoPropina) {
        this.cueBanderaExentoPropina = cueBanderaExentoPropina;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cueId != null ? cueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResCuentas)) {
            return false;
        }
        ResCuentas other = (ResCuentas) object;
        if ((this.cueId == null && other.cueId != null) || (this.cueId != null && !this.cueId.equals(other.cueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResCuentas[ cueId=" + cueId + " ]";
    }

    public String getCueMesa() {
        return cueMesa;
    }

    public void setCueMesa(String cueMesa) {
        this.cueMesa = cueMesa;
    }
    
}
