/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean.controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Lin
 */
@Named(value = "Login_jsfbean")
@RequestScoped
public class Login_jsfbean {
private String login_username ;
private String login_password;
    /**
     * Creates a new instance of Login_jsfbean
     */
    public Login_jsfbean() {
    }

    public String getLogin_username() {
        return login_username;
    }

    public void setLogin_username(String login_username) {
        this.login_username = login_username;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }


    
}
