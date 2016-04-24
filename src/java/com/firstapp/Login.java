/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstapp;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lin
 */
@Entity
@Table(name = "LOGIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByLoginId", query = "SELECT l FROM Login l WHERE l.loginId = :loginId"),
    @NamedQuery(name = "Login.findByLoginUsername", query = "SELECT l FROM Login l WHERE l.loginUsername = :loginUsername"),
    @NamedQuery(name = "Login.findByLoginPassword", query = "SELECT l FROM Login l WHERE l.loginPassword = :loginPassword"),
    @NamedQuery(name = "Login.findByLoginValid", query = "SELECT l FROM Login l WHERE l.loginValid = :loginValid")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOGIN_ID")
    private Integer loginId;
    @Size(max = 6)
    @Column(name = "LOGIN_USERNAME")
    private String loginUsername;
    @Size(max = 15)
    @Column(name = "LOGIN_PASSWORD")
    private String loginPassword;
    @Column(name = "LOGIN_VALID")
    private Character loginValid;

    public Login() {
    }

    public Login(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Character getLoginValid() {
        return loginValid;
    }

    public void setLoginValid(Character loginValid) {
        this.loginValid = loginValid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginId != null ? loginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.loginId == null && other.loginId != null) || (this.loginId != null && !this.loginId.equals(other.loginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.Login[ loginId=" + loginId + " ]";
    }
    
}
