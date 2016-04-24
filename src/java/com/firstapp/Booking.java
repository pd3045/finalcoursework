/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstapp;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lin
 */
@Entity
@Table(name = "BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookingId", query = "SELECT b FROM Booking b WHERE b.bookingId = :bookingId"),
    @NamedQuery(name = "Booking.findByDateBooked", query = "SELECT b FROM Booking b WHERE b.dateBooked = :dateBooked"),
    @NamedQuery(name = "Booking.findByNumberTravelling", query = "SELECT b FROM Booking b WHERE b.numberTravelling = :numberTravelling"),
    @NamedQuery(name = "Booking.findByTotalPrice", query = "SELECT b FROM Booking b WHERE b.totalPrice = :totalPrice")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKING_ID")
    private Integer bookingId;
    @Column(name = "DATE_BOOKED")
    @Temporal(TemporalType.DATE)
    private Date dateBooked;
    @Column(name = "NUMBER_TRAVELLING")
    private Integer numberTravelling;
    @Column(name = "TOTAL_PRICE")
    private Integer totalPrice;
    @JoinColumn(name = "FLIGHT_NUMBER", referencedColumnName = "FLIGHT_NUMBER")
    @ManyToOne
    private Flights flightNumber;
    @JoinColumn(name = "FLIGHT_CLASS", referencedColumnName = "FLIGHT_CLASS")
    @ManyToOne
    private FlightClass flightClass;
    @JoinColumn(name = "FLIGHT_TYPE", referencedColumnName = "FLIGHT_TYPE")
    @ManyToOne
    private FlightType flightType;
    @JoinColumn(name = "ITINARY_NUMBER", referencedColumnName = "ITINARY_NUMBER")
    @ManyToOne
    private Itinary itinaryNumber;
    @JoinColumn(name = "PASSANGER_CODE", referencedColumnName = "PASSANGER_CODE")
    @ManyToOne
    private Passanger passangerCode;
    @JoinColumn(name = "TICKET_NUMBER", referencedColumnName = "TICKET_ID")
    @ManyToOne
    private Ticket ticketNumber;

    public Booking() {
    }

    public Booking(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Date getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(Date dateBooked) {
        this.dateBooked = dateBooked;
    }

    public Integer getNumberTravelling() {
        return numberTravelling;
    }

    public void setNumberTravelling(Integer numberTravelling) {
        this.numberTravelling = numberTravelling;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Flights getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Flights flightNumber) {
        this.flightNumber = flightNumber;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public Itinary getItinaryNumber() {
        return itinaryNumber;
    }

    public void setItinaryNumber(Itinary itinaryNumber) {
        this.itinaryNumber = itinaryNumber;
    }

    public Passanger getPassangerCode() {
        return passangerCode;
    }

    public void setPassangerCode(Passanger passangerCode) {
        this.passangerCode = passangerCode;
    }

    public Ticket getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Ticket ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.Booking[ bookingId=" + bookingId + " ]";
    }
    
}
