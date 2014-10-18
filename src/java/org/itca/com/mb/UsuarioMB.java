/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itca.com.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.itca.com.beans.UsuarioFacade;
import org.itca.com.entidades.Usuario;

/**
 *
 * @author DATUM
 */
@ManagedBean
@SessionScoped
public class UsuarioMB {
    
    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario usuario;
    
    
    /**
     * Creates a new instance of UsuarioMB
     */
    public UsuarioMB() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String insertaUsuario(){
        usuarioFacade.create(usuario);
        //usuarioFacade.agregarUsuario(usuario);
        usuario = new Usuario();
        return "";
    }
    
}
