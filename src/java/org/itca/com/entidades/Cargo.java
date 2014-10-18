/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itca.com.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DATUM
 */
@Entity
@Table(name = "CARGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findById", query = "SELECT c FROM Cargo c WHERE c.id = :id"),
    @NamedQuery(name = "Cargo.findByNombreCargo", query = "SELECT c FROM Cargo c WHERE c.nombreCargo = :nombreCargo"),
    @NamedQuery(name = "Cargo.findByDescripcion", query = "SELECT c FROM Cargo c WHERE c.descripcion = :descripcion")})
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ID")
    private String id;
    @Size(max = 100)
    @Column(name = "NOMBRE_CARGO")
    private String nombreCargo;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo")
    private List<DetalleUsuario> detalleUsuarioList;

    public Cargo() {
    }

    public Cargo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<DetalleUsuario> getDetalleUsuarioList() {
        return detalleUsuarioList;
    }

    public void setDetalleUsuarioList(List<DetalleUsuario> detalleUsuarioList) {
        this.detalleUsuarioList = detalleUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itca.com.entidades.Cargo[ id=" + id + " ]";
    }
    
}
