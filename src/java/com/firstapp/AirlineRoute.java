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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lin
 */
@Entity
@Table(name = "AIRLINE_ROUTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AirlineRoute.findAll", query = "SELECT a FROM AirlineRoute a"),
    @NamedQuery(name = "AirlineRoute.findByRouteId", query = "SELECT a FROM AirlineRoute a WHERE a.routeId = :routeId"),
    @NamedQuery(name = "AirlineRoute.findByNumberOfStops", query = "SELECT a FROM AirlineRoute a WHERE a.numberOfStops = :numberOfStops"),
    @NamedQuery(name = "AirlineRoute.findByDirect", query = "SELECT a FROM AirlineRoute a WHERE a.direct = :direct"),
    @NamedQuery(name = "AirlineRoute.findByDescription", query = "SELECT a FROM AirlineRoute a WHERE a.description = :description")})
public class AirlineRoute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROUTE_ID")
    private Integer routeId;
    @Column(name = "NUMBER_OF_STOPS")
    private Integer numberOfStops;
    @Column(name = "DIRECT")
    private Character direct;
    @Size(max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "AIRLINE_CODE", referencedColumnName = "AIRLINE_CODE")
    @ManyToOne
    private AirlineCode airlineCode;
    @JoinColumn(name = "DEPARTURE_AIRPORT_CODE", referencedColumnName = "AIRPORT_CODE")
    @ManyToOne
    private AirportLocation departureAirportCode;
    @JoinColumn(name = "ARRIVAL_AIRPORT_CODE", referencedColumnName = "AIRPORT_CODE")
    @ManyToOne
    private AirportLocation arrivalAirportCode;
    @OneToMany(mappedBy = "routeId")
    private Collection<Flights> flightsCollection;

    public AirlineRoute() {
    }

    public AirlineRoute(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(Integer numberOfStops) {
        this.numberOfStops = numberOfStops;
    }

    public Character getDirect() {
        return direct;
    }

    public void setDirect(Character direct) {
        this.direct = direct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AirlineCode getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(AirlineCode airlineCode) {
        this.airlineCode = airlineCode;
    }

    public AirportLocation getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(AirportLocation departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public AirportLocation getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(AirportLocation arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
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
        hash += (routeId != null ? routeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AirlineRoute)) {
            return false;
        }
        AirlineRoute other = (AirlineRoute) object;
        if ((this.routeId == null && other.routeId != null) || (this.routeId != null && !this.routeId.equals(other.routeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.AirlineRoute[ routeId=" + routeId + " ]";
    }
    
}
