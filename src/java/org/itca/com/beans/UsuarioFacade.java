/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itca.com.beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.itca.com.entidades.Usuario;

/**
 *
 * @author DATUM
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "hdAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public List<Usuario> consultaUsuarioRol(Usuario usuario){
    List<Usuario> lista = new ArrayList<Usuario>();
    Query q = em.createNamedQuery("Usuario.findByUsuarioRol",Usuario.class);
    q.setParameter("addressline1", "%".concat(c.getAddressLine1()).concat("%"));
    lista = q.getResultList();
    return lista;
    
}
