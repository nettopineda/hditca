/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itca.com.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DATUM
 */
@Entity
@Table(name = "DETALLE_TICKET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleTicket.findAll", query = "SELECT d FROM DetalleTicket d"),
    @NamedQuery(name = "DetalleTicket.findByTicket", query = "SELECT d FROM DetalleTicket d WHERE d.detalleTicketPK.ticket = :ticket"),
    @NamedQuery(name = "DetalleTicket.findById", query = "SELECT d FROM DetalleTicket d WHERE d.detalleTicketPK.id = :id"),
    @NamedQuery(name = "DetalleTicket.findByDetalle", query = "SELECT d FROM DetalleTicket d WHERE d.detalle = :detalle"),
    @NamedQuery(name = "DetalleTicket.findByFecha", query = "SELECT d FROM DetalleTicket d WHERE d.fecha = :fecha")})
public class DetalleTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleTicketPK detalleTicketPK;
    @Size(max = 500)
    @Column(name = "DETALLE")
    private String detalle;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "EDITOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario editor;
    @JoinColumn(name = "TICKET", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ticket ticket1;

    public DetalleTicket() {
    }

    public DetalleTicket(DetalleTicketPK detalleTicketPK) {
        this.detalleTicketPK = detalleTicketPK;
    }

    public DetalleTicket(String ticket, long id) {
        this.detalleTicketPK = new DetalleTicketPK(ticket, id);
    }

    public DetalleTicketPK getDetalleTicketPK() {
        return detalleTicketPK;
    }

    public void setDetalleTicketPK(DetalleTicketPK detalleTicketPK) {
        this.detalleTicketPK = detalleTicketPK;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getEditor() {
        return editor;
    }

    public void setEditor(Usuario editor) {
        this.editor = editor;
    }

    public Ticket getTicket1() {
        return ticket1;
    }

    public void setTicket1(Ticket ticket1) {
        this.ticket1 = ticket1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleTicketPK != null ? detalleTicketPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTicket)) {
            return false;
        }
        DetalleTicket other = (DetalleTicket) object;
        if ((this.detalleTicketPK == null && other.detalleTicketPK != null) || (this.detalleTicketPK != null && !this.detalleTicketPK.equals(other.detalleTicketPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itca.com.entidades.DetalleTicket[ detalleTicketPK=" + detalleTicketPK + " ]";
    }
    
}
