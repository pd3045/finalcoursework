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
@Table(name = "FLIGHT_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FlightType.findAll", query = "SELECT f FROM FlightType f"),
    @NamedQuery(name = "FlightType.findByFlightType", query = "SELECT f FROM FlightType f WHERE f.flightType = :flightType"),
    @NamedQuery(name = "FlightType.findByFlightTypeDescription", query = "SELECT f FROM FlightType f WHERE f.flightTypeDescription = :flightTypeDescription")})
public class FlightType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "FLIGHT_TYPE")
    private String flightType;
    @Size(max = 20)
    @Column(name = "FLIGHT_TYPE_DESCRIPTION")
    private String flightTypeDescription;
    @OneToMany(mappedBy = "flightType")
    private Collection<Booking> bookingCollection;

    public FlightType() {
    }

    public FlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getFlightTypeDescription() {
        return flightTypeDescription;
    }

    public void setFlightTypeDescription(String flightTypeDescription) {
        this.flightTypeDescription = flightTypeDescription;
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
        hash += (flightType != null ? flightType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FlightType)) {
            return false;
        }
        FlightType other = (FlightType) object;
        if ((this.flightType == null && other.flightType != null) || (this.flightType != null && !this.flightType.equals(other.flightType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.FlightType[ flightType=" + flightType + " ]";
    }
    
}
