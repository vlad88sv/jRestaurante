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
@Table(name = "res_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResRoles.findAll", query = "SELECT r FROM ResRoles r"),
    @NamedQuery(name = "ResRoles.findByRolId", query = "SELECT r FROM ResRoles r WHERE r.rolId = :rolId"),
    @NamedQuery(name = "ResRoles.findByRolRol", query = "SELECT r FROM ResRoles r WHERE r.rolRol = :rolRol")})
public class ResRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_id")
    private Integer rolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "rol_rol")
    private String rolRol;
    @OneToMany(mappedBy = "empRolId")
    private List<ResEmpleados> resEmpleadosList;

    public ResRoles() {
    }

    public ResRoles(Integer rolId) {
        this.rolId = rolId;
    }

    public ResRoles(Integer rolId, String rolRol) {
        this.rolId = rolId;
        this.rolRol = rolRol;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolRol() {
        return rolRol;
    }

    public void setRolRol(String rolRol) {
        this.rolRol = rolRol;
    }

    @XmlTransient
    public List<ResEmpleados> getResEmpleadosList() {
        return resEmpleadosList;
    }

    public void setResEmpleadosList(List<ResEmpleados> resEmpleadosList) {
        this.resEmpleadosList = resEmpleadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResRoles)) {
            return false;
        }
        ResRoles other = (ResRoles) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jrestaurant.entities.ResRoles[ rolId=" + rolId + " ]";
    }
    
}
