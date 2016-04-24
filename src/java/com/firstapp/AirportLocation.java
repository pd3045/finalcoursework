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
@Table(name = "AIRPORT_LOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AirportLocation.findAll", query = "SELECT a FROM AirportLocation a"),
    @NamedQuery(name = "AirportLocation.findByAirportCode", query = "SELECT a FROM AirportLocation a WHERE a.airportCode = :airportCode"),
    @NamedQuery(name = "AirportLocation.findByAirportName", query = "SELECT a FROM AirportLocation a WHERE a.airportName = :airportName"),
    @NamedQuery(name = "AirportLocation.findByAirportCity", query = "SELECT a FROM AirportLocation a WHERE a.airportCity = :airportCity"),
    @NamedQuery(name = "AirportLocation.findByAirportCountry", query = "SELECT a FROM AirportLocation a WHERE a.airportCountry = :airportCountry")})
public class AirportLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "AIRPORT_CODE")
    private String airportCode;
    @Size(max = 30)
    @Column(name = "AIRPORT_NAME")
    private String airportName;
    @Size(max = 30)
    @Column(name = "AIRPORT_CITY")
    private String airportCity;
    @Size(max = 30)
    @Column(name = "AIRPORT_COUNTRY")
    private String airportCountry;
    @OneToMany(mappedBy = "departureAirportCode")
    private Collection<AirlineRoute> airlineRouteCollection;
    @OneToMany(mappedBy = "arrivalAirportCode")
    private Collection<AirlineRoute> airlineRouteCollection1;

    public AirportLocation() {
    }

    public AirportLocation(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }

    @XmlTransient
    public Collection<AirlineRoute> getAirlineRouteCollection() {
        return airlineRouteCollection;
    }

    public void setAirlineRouteCollection(Collection<AirlineRoute> airlineRouteCollection) {
        this.airlineRouteCollection = airlineRouteCollection;
    }

    @XmlTransient
    public Collection<AirlineRoute> getAirlineRouteCollection1() {
        return airlineRouteCollection1;
    }

    public void setAirlineRouteCollection1(Collection<AirlineRoute> airlineRouteCollection1) {
        this.airlineRouteCollection1 = airlineRouteCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (airportCode != null ? airportCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AirportLocation)) {
            return false;
        }
        AirportLocation other = (AirportLocation) object;
        if ((this.airportCode == null && other.airportCode != null) || (this.airportCode != null && !this.airportCode.equals(other.airportCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.AirportLocation[ airportCode=" + airportCode + " ]";
    }
    
}
