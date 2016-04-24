/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstapp;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lin
 */
@Entity
@Table(name = "FLIGHTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flights.findAll", query = "SELECT f FROM Flights f"),
    @NamedQuery(name = "Flights.findByFlightNumber", query = "SELECT f FROM Flights f WHERE f.flightNumber = :flightNumber"),
    @NamedQuery(name = "Flights.findByDepartureDay", query = "SELECT f FROM Flights f WHERE f.departureDay = :departureDay"),
    @NamedQuery(name = "Flights.findByDepartureTime", query = "SELECT f FROM Flights f WHERE f.departureTime = :departureTime"),
    @NamedQuery(name = "Flights.findByArrivalDate", query = "SELECT f FROM Flights f WHERE f.arrivalDate = :arrivalDate"),
    @NamedQuery(name = "Flights.findByArrivalTime", query = "SELECT f FROM Flights f WHERE f.arrivalTime = :arrivalTime"),
    @NamedQuery(name = "Flights.findByEconomySeatsAvailable", query = "SELECT f FROM Flights f WHERE f.economySeatsAvailable = :economySeatsAvailable"),
    @NamedQuery(name = "Flights.findByBusinessSeatsAvailable", query = "SELECT f FROM Flights f WHERE f.businessSeatsAvailable = :businessSeatsAvailable"),
    @NamedQuery(name = "Flights.findByEconomyPriceOneway", query = "SELECT f FROM Flights f WHERE f.economyPriceOneway = :economyPriceOneway"),
    @NamedQuery(name = "Flights.findByEconomyPriceReturn", query = "SELECT f FROM Flights f WHERE f.economyPriceReturn = :economyPriceReturn"),
    @NamedQuery(name = "Flights.findByBusinessPriceOneway", query = "SELECT f FROM Flights f WHERE f.businessPriceOneway = :businessPriceOneway"),
    @NamedQuery(name = "Flights.findByBusinessPriceReturn", query = "SELECT f FROM Flights f WHERE f.businessPriceReturn = :businessPriceReturn")})
public class Flights implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "FLIGHT_NUMBER")
    private String flightNumber;
    @Column(name = "DEPARTURE_DAY")
    @Temporal(TemporalType.DATE)
    private Date departureDay;
    @Column(name = "DEPARTURE_TIME")
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    @Column(name = "ARRIVAL_DATE")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Column(name = "ARRIVAL_TIME")
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;
    @Column(name = "ECONOMY_SEATS_AVAILABLE")
    private Integer economySeatsAvailable;
    @Column(name = "BUSINESS_SEATS_AVAILABLE")
    private Integer businessSeatsAvailable;
    @Column(name = "ECONOMY_PRICE_ONEWAY")
    private Integer economyPriceOneway;
    @Column(name = "ECONOMY_PRICE_RETURN")
    private Integer economyPriceReturn;
    @Column(name = "BUSINESS_PRICE_ONEWAY")
    private Integer businessPriceOneway;
    @Column(name = "BUSINESS_PRICE_RETURN")
    private Integer businessPriceReturn;
    @JoinColumn(name = "ROUTE_ID", referencedColumnName = "ROUTE_ID")
    @ManyToOne
    private AirlineRoute routeId;
    @JoinColumn(name = "FLIGHT_STATUS", referencedColumnName = "FLIGHT_STATUS")
    @ManyToOne
    private FlightStatus flightStatus;
    @OneToMany(mappedBy = "flightNumber")
    private Collection<Booking> bookingCollection;

    public Flights() {
    }

    public Flights(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(Date departureDay) {
        this.departureDay = departureDay;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getEconomySeatsAvailable() {
        return economySeatsAvailable;
    }

    public void setEconomySeatsAvailable(Integer economySeatsAvailable) {
        this.economySeatsAvailable = economySeatsAvailable;
    }

    public Integer getBusinessSeatsAvailable() {
        return businessSeatsAvailable;
    }

    public void setBusinessSeatsAvailable(Integer businessSeatsAvailable) {
        this.businessSeatsAvailable = businessSeatsAvailable;
    }

    public Integer getEconomyPriceOneway() {
        return economyPriceOneway;
    }

    public void setEconomyPriceOneway(Integer economyPriceOneway) {
        this.economyPriceOneway = economyPriceOneway;
    }

    public Integer getEconomyPriceReturn() {
        return economyPriceReturn;
    }

    public void setEconomyPriceReturn(Integer economyPriceReturn) {
        this.economyPriceReturn = economyPriceReturn;
    }

    public Integer getBusinessPriceOneway() {
        return businessPriceOneway;
    }

    public void setBusinessPriceOneway(Integer businessPriceOneway) {
        this.businessPriceOneway = businessPriceOneway;
    }

    public Integer getBusinessPriceReturn() {
        return businessPriceReturn;
    }

    public void setBusinessPriceReturn(Integer businessPriceReturn) {
        this.businessPriceReturn = businessPriceReturn;
    }

    public AirlineRoute getRouteId() {
        return routeId;
    }

    public void setRouteId(AirlineRoute routeId) {
        this.routeId = routeId;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
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
        hash += (flightNumber != null ? flightNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flights)) {
            return false;
        }
        Flights other = (Flights) object;
        if ((this.flightNumber == null && other.flightNumber != null) || (this.flightNumber != null && !this.flightNumber.equals(other.flightNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.Flights[ flightNumber=" + flightNumber + " ]";
    }
    
}
