/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itca.com.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DATUM
 */
@Embeddable
public class TicketHistoricoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "TICKET_ID")
    private String ticketId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "USUARIO_ID")
    private String usuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public TicketHistoricoPK() {
    }

    public TicketHistoricoPK(String ticketId, String usuarioId, Date fecha) {
        this.ticketId = ticketId;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketHistoricoPK)) {
            return false;
        }
        TicketHistoricoPK other = (TicketHistoricoPK) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itca.com.entidades.TicketHistoricoPK[ ticketId=" + ticketId + ", usuarioId=" + usuarioId + ", fecha=" + fecha + " ]";
    }
    
}
