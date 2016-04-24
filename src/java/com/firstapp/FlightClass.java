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
 * @author Lin
 */
@Entity
@Table(name = "FLIGHT_CLASS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FlightClass.findAll", query = "SELECT f FROM FlightClass f"),
    @NamedQuery(name = "FlightClass.findByFlightClass", query = "SELECT f FROM FlightClass f WHERE f.flightClass = :flightClass"),
    @NamedQuery(name = "FlightClass.findByFlightClassDescription", query = "SELECT f FROM FlightClass f WHERE f.flightClassDescription = :flightClassDescription")})
public class FlightClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "FLIGHT_CLASS")
    private String flightClass;
    @Size(max = 20)
    @Column(name = "FLIGHT_CLASS_DESCRIPTION")
    private String flightClassDescription;
    @OneToMany(mappedBy = "flightClass")
    private Collection<Booking> bookingCollection;

    public FlightClass() {
    }

    public FlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String getFlightClassDescription() {
        return flightClassDescription;
    }

    public void setFlightClassDescription(String flightClassDescription) {
        this.flightClassDescription = flightClassDescription;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightClass != null ? flightClass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FlightClass)) {
            return false;
        }
        FlightClass other = (FlightClass) object;
        if ((this.flightClass == null && other.flightClass != null) || (this.flightClass != null && !this.flightClass.equals(other.flightClass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.FlightClass[ flightClass=" + flightClass + " ]";
    }
    
}
