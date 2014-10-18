/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itca.com.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DATUM
 */
@Entity
@Table(name = "TICKET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findById", query = "SELECT t FROM Ticket t WHERE t.id = :id"),
    @NamedQuery(name = "Ticket.findByTitulo", query = "SELECT t FROM Ticket t WHERE t.titulo = :titulo"),
    @NamedQuery(name = "Ticket.findByDescripcion", query = "SELECT t FROM Ticket t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Ticket.findByFechaInicio", query = "SELECT t FROM Ticket t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Ticket.findByFechaFin", query = "SELECT t FROM Ticket t WHERE t.fechaFin = :fechaFin")})
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ID")
    private String id;
    @Size(max = 100)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private List<TicketHistorico> ticketHistoricoList;
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "SEVERIDAD", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Severidad severidad;
    @JoinColumn(name = "ESTADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Estado estado;
    @JoinColumn(name = "TIPO_TICKET", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Categoria tipoTicket;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket1")
    private List<DetalleTicket> detalleTicketList;

    public Ticket() {
    }

    public Ticket(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public List<TicketHistorico> getTicketHistoricoList() {
        return ticketHistoricoList;
    }

    public void setTicketHistoricoList(List<TicketHistorico> ticketHistoricoList) {
        this.ticketHistoricoList = ticketHistoricoList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Severidad getSeveridad() {
        return severidad;
    }

    public void setSeveridad(Severidad severidad) {
        this.severidad = severidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Categoria getTipoTicket() {
        return tipoTicket;
    }

    public void setTipoTicket(Categoria tipoTicket) {
        this.tipoTicket = tipoTicket;
    }

    @XmlTransient
    public List<DetalleTicket> getDetalleTicketList() {
        return detalleTicketList;
    }

    public void setDetalleTicketList(List<DetalleTicket> detalleTicketList) {
        this.detalleTicketList = detalleTicketList;
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
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itca.com.entidades.Ticket[ id=" + id + " ]";
    }
    
}
