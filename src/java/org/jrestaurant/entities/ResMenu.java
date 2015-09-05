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
@Table(name = "res_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResMenu.findAll", query = "SELECT r FROM ResMenu r"),
    @NamedQuery(name = "ResMenu.findByMenId", query = "SELECT r FROM ResMenu r WHERE r.menId = :menId"),
    @NamedQuery(name = "ResMenu.findByMenMenu", query = "SELECT r FROM ResMenu r WHERE r.menMenu = :menMenu"),
    @NamedQuery(name = "ResMenu.findByMenActivo", query = "SELECT r FROM ResMenu r WHERE r.menActivo = :menActivo")})
public class ResMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "men_id")
    private Integer menId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "men_menu")
    private String menMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_activo")
    private boolean menActivo;
    @OneToMany(mappedBy = "capMenuId")
    private List<ResCategoriaProductos> resCategoriaProductosList;

    public ResMenu() {
    }

    public ResMenu(Integer menId) {
        this.menId = menId;
    }

    public ResMenu(Integer menId, String menMenu, boolean menActivo) {
        this.menId = menId;
        this.menMenu = menMenu;
        this.menActivo = menActivo;
    }

    public Integer getMenId() {
        return menId;
    }

    public void setMenId(Integer menId) {
        this.menId = menId;
    }

    public String getMenMenu() {
        return menMenu;
    }

    public void setMenMenu(String menMenu) {
        this.menMenu = menMenu;
    }

    public boolean getMenActivo() {
        return menActivo;
    }

    public void setMenActivo(boolean menActivo) {
        this.menActivo = menActivo;
    }

    @XmlTransient
    public List<ResCategoriaProductos> getResCategoriaProductosList() {
        return resCategoriaProductosList;
    }

    public void setResCategoriaProductosList(List<ResCategoriaProductos> resCategoriaProductosList) {
        this.resCategoriaProductosList = resCategoriaProductosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menId != null ? menId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResMenu)) {
            return false;
        }
        ResMenu other = (ResMenu) object;
        if ((this.menId == null && other.menId != null) || (this.menId != null && !this.menId.equals(other.menId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResMenu[ menId=" + menId + " ]";
    }
    
}
