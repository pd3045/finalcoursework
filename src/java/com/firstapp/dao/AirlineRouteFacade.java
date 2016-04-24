/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstapp.dao;

import com.firstapp.AirlineRoute;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lin
 */
@Stateless
public class AirlineRouteFacade extends AbstractFacade<AirlineRoute> {

    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AirlineRouteFacade() {
        super(AirlineRoute.class);
    }
    
}
