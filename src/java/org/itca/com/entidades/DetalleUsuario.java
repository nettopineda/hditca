/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itca.com.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DATUM
 */
@Entity
@Table(name = "DETALLE_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleUsuario.findAll", query = "SELECT d FROM DetalleUsuario d"),
    @NamedQuery(name = "DetalleUsuario.findByUsuario", query = "SELECT d FROM DetalleUsuario d WHERE d.usuario = :usuario")})
public class DetalleUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "USUARIO")
    private String usuario;
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario1;
    @JoinColumn(name = "JEFE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario jefe;
    @JoinColumn(name = "DEPARTAMENTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Departamento departamento;
    @JoinColumn(name = "CARGO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cargo cargo;

    public DetalleUsuario() {
    }

    public DetalleUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getJefe() {
        return jefe;
    }

    public void setJefe(Usuario jefe) {
        this.jefe = jefe;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleUsuario)) {
            return false;
        }
        DetalleUsuario other = (DetalleUsuario) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itca.com.entidades.DetalleUsuario[ usuario=" + usuario + " ]";
    }
    
}
