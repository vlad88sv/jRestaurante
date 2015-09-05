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
@Table(name = "res_adicionables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResAdicionables.findAll", query = "SELECT r FROM ResAdicionables r"),
    @NamedQuery(name = "ResAdicionables.findByAdiId", query = "SELECT r FROM ResAdicionables r WHERE r.adiId = :adiId"),
    @NamedQuery(name = "ResAdicionables.findByAdiAdicionable", query = "SELECT r FROM ResAdicionables r WHERE r.adiAdicionable = :adiAdicionable"),
    @NamedQuery(name = "ResAdicionables.findByAdiBanderaImportante", query = "SELECT r FROM ResAdicionables r WHERE r.adiBanderaImportante = :adiBanderaImportante"),
    @NamedQuery(name = "ResAdicionables.findByAdiBanderaAgregable", query = "SELECT r FROM ResAdicionables r WHERE r.adiBanderaAgregable = :adiBanderaAgregable"),
    @NamedQuery(name = "ResAdicionables.findByAdiBanderaQuitable", query = "SELECT r FROM ResAdicionables r WHERE r.adiBanderaQuitable = :adiBanderaQuitable"),
    @NamedQuery(name = "ResAdicionables.findByAdiBanderaEstadistico", query = "SELECT r FROM ResAdicionables r WHERE r.adiBanderaEstadistico = :adiBanderaEstadistico"),
    @NamedQuery(name = "ResAdicionables.findByAdiPrecio", query = "SELECT r FROM ResAdicionables r WHERE r.adiPrecio = :adiPrecio"),
    @NamedQuery(name = "ResAdicionables.findByAdiActivo", query = "SELECT r FROM ResAdicionables r WHERE r.adiActivo = :adiActivo")})
public class ResAdicionables implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adi_id")
    private Integer adiId;
    @Size(max = 50)
    @Column(name = "adi_adicionable")
    private String adiAdicionable;
    @Column(name = "adi_bandera_importante")
    private Boolean adiBanderaImportante;
    @Column(name = "adi_bandera_agregable")
    private Boolean adiBanderaAgregable;
    @Column(name = "adi_bandera_quitable")
    private Boolean adiBanderaQuitable;
    @Column(name = "adi_bandera_estadistico")
    private Boolean adiBanderaEstadistico;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "adi_precio")
    private BigDecimal adiPrecio;
    @Column(name = "adi_activo")
    private Boolean adiActivo;
    @OneToMany(mappedBy = "opaAdicionalId")
    private List<ResOrdenesProductosAdicionales> resOrdenesProductosAdicionalesList;

    public ResAdicionables() {
    }

    public ResAdicionables(Integer adiId) {
        this.adiId = adiId;
    }

    public Integer getAdiId() {
        return adiId;
    }

    public void setAdiId(Integer adiId) {
        this.adiId = adiId;
    }

    public String getAdiAdicionable() {
        return adiAdicionable;
    }

    public void setAdiAdicionable(String adiAdicionable) {
        this.adiAdicionable = adiAdicionable;
    }

    public Boolean getAdiBanderaImportante() {
        return adiBanderaImportante;
    }

    public void setAdiBanderaImportante(Boolean adiBanderaImportante) {
        this.adiBanderaImportante = adiBanderaImportante;
    }

    public Boolean getAdiBanderaAgregable() {
        return adiBanderaAgregable;
    }

    public void setAdiBanderaAgregable(Boolean adiBanderaAgregable) {
        this.adiBanderaAgregable = adiBanderaAgregable;
    }

    public Boolean getAdiBanderaQuitable() {
        return adiBanderaQuitable;
    }

    public void setAdiBanderaQuitable(Boolean adiBanderaQuitable) {
        this.adiBanderaQuitable = adiBanderaQuitable;
    }

    public Boolean getAdiBanderaEstadistico() {
        return adiBanderaEstadistico;
    }

    public void setAdiBanderaEstadistico(Boolean adiBanderaEstadistico) {
        this.adiBanderaEstadistico = adiBanderaEstadistico;
    }

    public BigDecimal getAdiPrecio() {
        return adiPrecio;
    }

    public void setAdiPrecio(BigDecimal adiPrecio) {
        this.adiPrecio = adiPrecio;
    }

    public Boolean getAdiActivo() {
        return adiActivo;
    }

    public void setAdiActivo(Boolean adiActivo) {
        this.adiActivo = adiActivo;
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
        hash += (adiId != null ? adiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResAdicionables)) {
            return false;
        }
        ResAdicionables other = (ResAdicionables) object;
        if ((this.adiId == null && other.adiId != null) || (this.adiId != null && !this.adiId.equals(other.adiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResAdicionables[ adiId=" + adiId + " ]";
    }
    
}
