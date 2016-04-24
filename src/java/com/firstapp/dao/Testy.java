/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstapp.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lin
 */
@Entity
@Table(name = "TESTY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testy.findAll", query = "SELECT t FROM Testy t"),
    @NamedQuery(name = "Testy.findByPrim", query = "SELECT t FROM Testy t WHERE t.prim = :prim"),
    @NamedQuery(name = "Testy.findByHigh", query = "SELECT t FROM Testy t WHERE t.high = :high")})
public class Testy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIM")
    private Integer prim;
    @Column(name = "HIGH")
    private Integer high;

    public Testy() {
    }

    public Testy(Integer prim) {
        this.prim = prim;
    }

    public Integer getPrim() {
        return prim;
    }

    public void setPrim(Integer prim) {
        this.prim = prim;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prim != null ? prim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testy)) {
            return false;
        }
        Testy other = (Testy) object;
        if ((this.prim == null && other.prim != null) || (this.prim != null && !this.prim.equals(other.prim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.dao.Testy[ prim=" + prim + " ]";
    }
    
}
