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
@Table(name = "AIRLINE_CODE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AirlineCode.findAll", query = "SELECT a FROM AirlineCode a"),
    @NamedQuery(name = "AirlineCode.findByAirlineCode", query = "SELECT a FROM AirlineCode a WHERE a.airlineCode = :airlineCode"),
    @NamedQuery(name = "AirlineCode.findByAirlineName", query = "SELECT a FROM AirlineCode a WHERE a.airlineName = :airlineName"),
    @NamedQuery(name = "AirlineCode.findByCountry", query = "SELECT a FROM AirlineCode a WHERE a.country = :country")})
public class AirlineCode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "AIRLINE_CODE")
    private String airlineCode;
    @Size(max = 30)
    @Column(name = "AIRLINE_NAME")
    private String airlineName;
    @Size(max = 30)
    @Column(name = "COUNTRY")
    private String country;
    @OneToMany(mappedBy = "airlineCode")
    private Collection<AirlineRoute> airlineRouteCollection;

    public AirlineCode() {
    }

    public AirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlTransient
    public Collection<AirlineRoute> getAirlineRouteCollection() {
        return airlineRouteCollection;
    }

    public void setAirlineRouteCollection(Collection<AirlineRoute> airlineRouteCollection) {
        this.airlineRouteCollection = airlineRouteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (airlineCode != null ? airlineCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AirlineCode)) {
            return false;
        }
        AirlineCode other = (AirlineCode) object;
        if ((this.airlineCode == null && other.airlineCode != null) || (this.airlineCode != null && !this.airlineCode.equals(other.airlineCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.AirlineCode[ airlineCode=" + airlineCode + " ]";
    }
    
}
