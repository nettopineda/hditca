/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itca.com.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DATUM
 */
@Embeddable
public class DetalleCategoriaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ITEM")
    private String item;

    public DetalleCategoriaPK() {
    }

    public DetalleCategoriaPK(String id, String item) {
        this.id = id;
        this.item = item;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (item != null ? item.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCategoriaPK)) {
            return false;
        }
        DetalleCategoriaPK other = (DetalleCategoriaPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if ((this.item == null && other.item != null) || (this.item != null && !this.item.equals(other.item))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itca.com.entidades.DetalleCategoriaPK[ id=" + id + ", item=" + item + " ]";
    }
    
}
