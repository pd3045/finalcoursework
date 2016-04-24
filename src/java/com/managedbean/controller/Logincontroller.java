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
@Named(value = "Logincontroller")
@RequestScoped
public class Logincontroller {

    /**
     * Creates a new instance of Logincontroller
     */
    public Logincontroller() {
    }
    public String navigate(){
        /**  Navigate to Page Confirming Login
         */
    return "Confirmed";
    }
}