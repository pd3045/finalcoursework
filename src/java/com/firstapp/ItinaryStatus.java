/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstapp;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lin
 */
@Entity
@Table(name = "ITINARY_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItinaryStatus.findAll", query = "SELECT i FROM ItinaryStatus i"),
    @NamedQuery(name = "ItinaryStatus.findByItinaryStatus", query = "SELECT i FROM ItinaryStatus i WHERE i.itinaryStatus = :itinaryStatus"),
    @NamedQuery(name = "ItinaryStatus.findByItinaryStatusDescription", query = "SELECT i FROM ItinaryStatus i WHERE i.itinaryStatusDescription = :itinaryStatusDescription")})
public class ItinaryStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ITINARY_STATUS")
    private String itinaryStatus;
    @Size(max = 20)
    @Column(name = "ITINARY_STATUS_DESCRIPTION")
    private String itinaryStatusDescription;

    public ItinaryStatus() {
    }

    public ItinaryStatus(String itinaryStatus) {
        this.itinaryStatus = itinaryStatus;
    }

    public String getItinaryStatus() {
        return itinaryStatus;
    }

    public void setItinaryStatus(String itinaryStatus) {
        this.itinaryStatus = itinaryStatus;
    }

    public String getItinaryStatusDescription() {
        return itinaryStatusDescription;
    }

    public void setItinaryStatusDescription(String itinaryStatusDescription) {
        this.itinaryStatusDescription = itinaryStatusDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itinaryStatus != null ? itinaryStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItinaryStatus)) {
            return false;
        }
        ItinaryStatus other = (ItinaryStatus) object;
        if ((this.itinaryStatus == null && other.itinaryStatus != null) || (this.itinaryStatus != null && !this.itinaryStatus.equals(other.itinaryStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.ItinaryStatus[ itinaryStatus=" + itinaryStatus + " ]";
    }
    
}
