/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itca.com.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.itca.com.entidades.Estado;

/**
 *
 * @author DATUM
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> {
    @PersistenceContext(unitName = "hdAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacade() {
        super(Estado.class);
    }
    
}
