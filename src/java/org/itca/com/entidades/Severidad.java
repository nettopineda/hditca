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
@Table(name = "SEVERIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Severidad.findAll", query = "SELECT s FROM Severidad s"),
    @NamedQuery(name = "Severidad.findById", query = "SELECT s FROM Severidad s WHERE s.id = :id"),
    @NamedQuery(name = "Severidad.findByNombreSeveridad", query = "SELECT s FROM Severidad s WHERE s.nombreSeveridad = :nombreSeveridad")})
public class Severidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ID")
    private String id;
    @Size(max = 25)
    @Column(name = "NOMBRE_SEVERIDAD")
    private String nombreSeveridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "severidad")
    private List<Ticket> ticketList;

    public Severidad() {
    }

    public Severidad(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreSeveridad() {
        return nombreSeveridad;
    }

    public void setNombreSeveridad(String nombreSeveridad) {
        this.nombreSeveridad = nombreSeveridad;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
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
        if (!(object instanceof Severidad)) {
            return false;
        }
        Severidad other = (Severidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itca.com.entidades.Severidad[ id=" + id + " ]";
    }
    
}
