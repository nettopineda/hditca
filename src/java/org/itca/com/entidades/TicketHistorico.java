/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itca.com.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DATUM
 */
@Entity
@Table(name = "TICKET_HISTORICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketHistorico.findAll", query = "SELECT t FROM TicketHistorico t"),
    @NamedQuery(name = "TicketHistorico.findByTicketId", query = "SELECT t FROM TicketHistorico t WHERE t.ticketHistoricoPK.ticketId = :ticketId"),
    @NamedQuery(name = "TicketHistorico.findByUsuarioId", query = "SELECT t FROM TicketHistorico t WHERE t.ticketHistoricoPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "TicketHistorico.findByFecha", query = "SELECT t FROM TicketHistorico t WHERE t.ticketHistoricoPK.fecha = :fecha")})
public class TicketHistorico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TicketHistoricoPK ticketHistoricoPK;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "TICKET_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ticket ticket;

    public TicketHistorico() {
    }

    public TicketHistorico(TicketHistoricoPK ticketHistoricoPK) {
        this.ticketHistoricoPK = ticketHistoricoPK;
    }

    public TicketHistorico(String ticketId, String usuarioId, Date fecha) {
        this.ticketHistoricoPK = new TicketHistoricoPK(ticketId, usuarioId, fecha);
    }

    public TicketHistoricoPK getTicketHistoricoPK() {
        return ticketHistoricoPK;
    }

    public void setTicketHistoricoPK(TicketHistoricoPK ticketHistoricoPK) {
        this.ticketHistoricoPK = ticketHistoricoPK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketHistoricoPK != null ? ticketHistoricoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketHistorico)) {
            return false;
        }
        TicketHistorico other = (TicketHistorico) object;
        if ((this.ticketHistoricoPK == null && other.ticketHistoricoPK != null) || (this.ticketHistoricoPK != null && !this.ticketHistoricoPK.equals(other.ticketHistoricoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itca.com.entidades.TicketHistorico[ ticketHistoricoPK=" + ticketHistoricoPK + " ]";
    }
    
}
