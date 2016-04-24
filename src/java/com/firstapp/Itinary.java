/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstapp;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lin
 */
@Entity
@Table(name = "ITINARY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itinary.findAll", query = "SELECT i FROM Itinary i"),
    @NamedQuery(name = "Itinary.findByItinaryNumber", query = "SELECT i FROM Itinary i WHERE i.itinaryNumber = :itinaryNumber"),
    @NamedQuery(name = "Itinary.findByItinaryStatus", query = "SELECT i FROM Itinary i WHERE i.itinaryStatus = :itinaryStatus")})
public class Itinary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITINARY_NUMBER")
    private Integer itinaryNumber;
    @Column(name = "ITINARY_STATUS")
    private Character itinaryStatus;
    @OneToMany(mappedBy = "itinaryNumber")
    private Collection<Booking> bookingCollection;
    @JoinColumn(name = "PASSANGER_CODE", referencedColumnName = "PASSANGER_CODE")
    @ManyToOne(optional = false)
    private Passanger passangerCode;

    public Itinary() {
    }

    public Itinary(Integer itinaryNumber) {
        this.itinaryNumber = itinaryNumber;
    }

    public Integer getItinaryNumber() {
        return itinaryNumber;
    }

    public void setItinaryNumber(Integer itinaryNumber) {
        this.itinaryNumber = itinaryNumber;
    }

    public Character getItinaryStatus() {
        return itinaryStatus;
    }

    public void setItinaryStatus(Character itinaryStatus) {
        this.itinaryStatus = itinaryStatus;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    public Passanger getPassangerCode() {
        return passangerCode;
    }

    public void setPassangerCode(Passanger passangerCode) {
        this.passangerCode = passangerCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itinaryNumber != null ? itinaryNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itinary)) {
            return false;
        }
        Itinary other = (Itinary) object;
        if ((this.itinaryNumber == null && other.itinaryNumber != null) || (this.itinaryNumber != null && !this.itinaryNumber.equals(other.itinaryNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.Itinary[ itinaryNumber=" + itinaryNumber + " ]";
    }
    
}
