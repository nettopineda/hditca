/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itca.com.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DATUM
 */
@Entity
@Table(name = "DETALLE_CATEGORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCategoria.findAll", query = "SELECT d FROM DetalleCategoria d"),
    @NamedQuery(name = "DetalleCategoria.findById", query = "SELECT d FROM DetalleCategoria d WHERE d.detalleCategoriaPK.id = :id"),
    @NamedQuery(name = "DetalleCategoria.findByItem", query = "SELECT d FROM DetalleCategoria d WHERE d.detalleCategoriaPK.item = :item"),
    @NamedQuery(name = "DetalleCategoria.findByDescripcion", query = "SELECT d FROM DetalleCategoria d WHERE d.descripcion = :descripcion")})
public class DetalleCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleCategoriaPK detalleCategoriaPK;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categoria categoria;

    public DetalleCategoria() {
    }

    public DetalleCategoria(DetalleCategoriaPK detalleCategoriaPK) {
        this.detalleCategoriaPK = detalleCategoriaPK;
    }

    public DetalleCategoria(String id, String item) {
        this.detalleCategoriaPK = new DetalleCategoriaPK(id, item);
    }

    public DetalleCategoriaPK getDetalleCategoriaPK() {
        return detalleCategoriaPK;
    }

    public void setDetalleCategoriaPK(DetalleCategoriaPK detalleCategoriaPK) {
        this.detalleCategoriaPK = detalleCategoriaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleCategoriaPK != null ? detalleCategoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCategoria)) {
            return false;
        }
        DetalleCategoria other = (DetalleCategoria) object;
        if ((this.detalleCategoriaPK == null && other.detalleCategoriaPK != null) || (this.detalleCategoriaPK != null && !this.detalleCategoriaPK.equals(other.detalleCategoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itca.com.entidades.DetalleCategoria[ detalleCategoriaPK=" + detalleCategoriaPK + " ]";
    }
    
}
