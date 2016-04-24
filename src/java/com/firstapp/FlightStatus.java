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
@Table(name = "FLIGHT_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FlightStatus.findAll", query = "SELECT f FROM FlightStatus f"),
    @NamedQuery(name = "FlightStatus.findByFlightStatus", query = "SELECT f FROM FlightStatus f WHERE f.flightStatus = :flightStatus"),
    @NamedQuery(name = "FlightStatus.findByDescription", query = "SELECT f FROM FlightStatus f WHERE f.description = :description")})
public class FlightStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "FLIGHT_STATUS")
    private String flightStatus;
    @Size(max = 30)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "flightStatus")
    private Collection<Flights> flightsCollection;

    public FlightStatus() {
    }

    public FlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Flights> getFlightsCollection() {
        return flightsCollection;
    }

    public void setFlightsCollection(Collection<Flights> flightsCollection) {
        this.flightsCollection = flightsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightStatus != null ? flightStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FlightStatus)) {
            return false;
        }
        FlightStatus other = (FlightStatus) object;
        if ((this.flightStatus == null && other.flightStatus != null) || (this.flightStatus != null && !this.flightStatus.equals(other.flightStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.FlightStatus[ flightStatus=" + flightStatus + " ]";
    }
    
}
