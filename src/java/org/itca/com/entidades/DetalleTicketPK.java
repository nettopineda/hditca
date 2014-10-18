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
public class DetalleTicketPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "TICKET")
    private String ticket;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private long id;

    public DetalleTicketPK() {
    }

    public DetalleTicketPK(String ticket, long id) {
        this.ticket = ticket;
        this.id = id;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticket != null ? ticket.hashCode() : 0);
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTicketPK)) {
            return false;
        }
        DetalleTicketPK other = (DetalleTicketPK) object;
        if ((this.ticket == null && other.ticket != null) || (this.ticket != null && !this.ticket.equals(other.ticket))) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itca.com.entidades.DetalleTicketPK[ ticket=" + ticket + ", id=" + id + " ]";
    }
    
}
