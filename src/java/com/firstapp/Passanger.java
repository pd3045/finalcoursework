/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstapp;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "PASSANGER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passanger.findAll", query = "SELECT p FROM Passanger p"),
    @NamedQuery(name = "Passanger.findByPassangerCode", query = "SELECT p FROM Passanger p WHERE p.passangerCode = :passangerCode"),
    @NamedQuery(name = "Passanger.findByFirstName", query = "SELECT p FROM Passanger p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Passanger.findByMiddleName", query = "SELECT p FROM Passanger p WHERE p.middleName = :middleName"),
    @NamedQuery(name = "Passanger.findByLastName", query = "SELECT p FROM Passanger p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Passanger.findByHouseNumber", query = "SELECT p FROM Passanger p WHERE p.houseNumber = :houseNumber"),
    @NamedQuery(name = "Passanger.findByStreetName", query = "SELECT p FROM Passanger p WHERE p.streetName = :streetName"),
    @NamedQuery(name = "Passanger.findByCity", query = "SELECT p FROM Passanger p WHERE p.city = :city"),
    @NamedQuery(name = "Passanger.findByCountry", query = "SELECT p FROM Passanger p WHERE p.country = :country"),
    @NamedQuery(name = "Passanger.findByEmail", query = "SELECT p FROM Passanger p WHERE p.email = :email"),
    @NamedQuery(name = "Passanger.findByRole", query = "SELECT p FROM Passanger p WHERE p.role = :role"),
    @NamedQuery(name = "Passanger.findByLoginId", query = "SELECT p FROM Passanger p WHERE p.loginId = :loginId")})
public class Passanger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PASSANGER_CODE")
    private Integer passangerCode;
    @Size(max = 40)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 30)
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Size(max = 30)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "HOUSE_NUMBER")
    private Integer houseNumber;
    @Size(max = 50)
    @Column(name = "STREET_NAME")
    private String streetName;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 25)
    @Column(name = "COUNTRY")
    private String country;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE")
    private Character role;
    @Column(name = "LOGIN_ID")
    private Integer loginId;
    @JoinColumn(name = "CREDIT_CARD_REF", referencedColumnName = "CARD_REFERENCE_NUMBER")
    @ManyToOne
    private CreditCardDetails creditCardRef;
    @OneToMany(mappedBy = "passangerCode")
    private Collection<Booking> bookingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passangerCode")
    private Collection<Itinary> itinaryCollection;

    public Passanger() {
    }

    public Passanger(Integer passangerCode) {
        this.passangerCode = passangerCode;
    }

    public Passanger(Integer passangerCode, Character role) {
        this.passangerCode = passangerCode;
        this.role = role;
    }

    public Integer getPassangerCode() {
        return passangerCode;
    }

    public void setPassangerCode(Integer passangerCode) {
        this.passangerCode = passangerCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getRole() {
        return role;
    }

    public void setRole(Character role) {
        this.role = role;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public CreditCardDetails getCreditCardRef() {
        return creditCardRef;
    }

    public void setCreditCardRef(CreditCardDetails creditCardRef) {
        this.creditCardRef = creditCardRef;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @XmlTransient
    public Collection<Itinary> getItinaryCollection() {
        return itinaryCollection;
    }

    public void setItinaryCollection(Collection<Itinary> itinaryCollection) {
        this.itinaryCollection = itinaryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passangerCode != null ? passangerCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passanger)) {
            return false;
        }
        Passanger other = (Passanger) object;
        if ((this.passangerCode == null && other.passangerCode != null) || (this.passangerCode != null && !this.passangerCode.equals(other.passangerCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.Passanger[ passangerCode=" + passangerCode + " ]";
    }
    
}
