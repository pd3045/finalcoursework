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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lin
 */
@Entity
@Table(name = "custinf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Custinf.findAll", query = "SELECT c FROM Custinf c"),
    @NamedQuery(name = "Custinf.findByCustId", query = "SELECT c FROM Custinf c WHERE c.custId = :custId"),
    @NamedQuery(name = "Custinf.findByFname", query = "SELECT c FROM Custinf c WHERE c.fname = :fname")})
public class Custinf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CUST_ID")
    private Integer custId;
    @Size(max = 50)
    @Column(name = "FNAME")
    private String fname;

    public Custinf() {
    }

    public Custinf(Integer custId) {
        this.custId = custId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custId != null ? custId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Custinf)) {
            return false;
        }
        Custinf other = (Custinf) object;
        if ((this.custId == null && other.custId != null) || (this.custId != null && !this.custId.equals(other.custId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.Custinf[ custId=" + custId + " ]";
    }
    
}
