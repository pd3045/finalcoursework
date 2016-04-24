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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lin
 */
@Entity
@Table(name = "CREDIT_CARD_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditCardDetails.findAll", query = "SELECT c FROM CreditCardDetails c"),
    @NamedQuery(name = "CreditCardDetails.findByCardReferenceNumber", query = "SELECT c FROM CreditCardDetails c WHERE c.cardReferenceNumber = :cardReferenceNumber"),
    @NamedQuery(name = "CreditCardDetails.findByCardNumber", query = "SELECT c FROM CreditCardDetails c WHERE c.cardNumber = :cardNumber"),
    @NamedQuery(name = "CreditCardDetails.findByExpiryDate", query = "SELECT c FROM CreditCardDetails c WHERE c.expiryDate = :expiryDate"),
    @NamedQuery(name = "CreditCardDetails.findByValid", query = "SELECT c FROM CreditCardDetails c WHERE c.valid = :valid")})
public class CreditCardDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARD_REFERENCE_NUMBER")
    private Integer cardReferenceNumber;
    @Column(name = "CARD_NUMBER")
    private Integer cardNumber;
    @Column(name = "EXPIRY_DATE")
    private Integer expiryDate;
    @Column(name = "VALID")
    private Character valid;
    @OneToMany(mappedBy = "creditCardRef")
    private Collection<Passanger> passangerCollection;

    public CreditCardDetails() {
    }

    public CreditCardDetails(Integer cardReferenceNumber) {
        this.cardReferenceNumber = cardReferenceNumber;
    }

    public Integer getCardReferenceNumber() {
        return cardReferenceNumber;
    }

    public void setCardReferenceNumber(Integer cardReferenceNumber) {
        this.cardReferenceNumber = cardReferenceNumber;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Integer expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Character getValid() {
        return valid;
    }

    public void setValid(Character valid) {
        this.valid = valid;
    }

    @XmlTransient
    public Collection<Passanger> getPassangerCollection() {
        return passangerCollection;
    }

    public void setPassangerCollection(Collection<Passanger> passangerCollection) {
        this.passangerCollection = passangerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardReferenceNumber != null ? cardReferenceNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditCardDetails)) {
            return false;
        }
        CreditCardDetails other = (CreditCardDetails) object;
        if ((this.cardReferenceNumber == null && other.cardReferenceNumber != null) || (this.cardReferenceNumber != null && !this.cardReferenceNumber.equals(other.cardReferenceNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.CreditCardDetails[ cardReferenceNumber=" + cardReferenceNumber + " ]";
    }
    
}
