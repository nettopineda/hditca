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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByPrimerApellido", query = "SELECT u FROM Usuario u WHERE u.primerApellido = :primerApellido"),
    @NamedQuery(name = "Usuario.findBySegundoApellido", query = "SELECT u FROM Usuario u WHERE u.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),    
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ID")
    private String id;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Size(max = 100)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Size(max = 100)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 100)
    @Column(name = "TELEFONO")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<TicketHistorico> ticketHistoricoList;
    @JoinColumn(name = "ROL", referencedColumnName = "ID")
    @ManyToOne
    private Rol rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Ticket> ticketList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario1")
    private DetalleUsuario detalleUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jefe")
    private List<DetalleUsuario> detalleUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editor")
    private List<DetalleTicket> detalleTicketList;

    public Usuario() {
    }

    public Usuario(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<TicketHistorico> getTicketHistoricoList() {
        return ticketHistoricoList;
    }

    public void setTicketHistoricoList(List<TicketHistorico> ticketHistoricoList) {
        this.ticketHistoricoList = ticketHistoricoList;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public DetalleUsuario getDetalleUsuario() {
        return detalleUsuario;
    }

    public void setDetalleUsuario(DetalleUsuario detalleUsuario) {
        this.detalleUsuario = detalleUsuario;
    }

    @XmlTransient
    public List<DetalleUsuario> getDetalleUsuarioList() {
        return detalleUsuarioList;
    }

    public void setDetalleUsuarioList(List<DetalleUsuario> detalleUsuarioList) {
        this.detalleUsuarioList = detalleUsuarioList;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itca.com.entidades.Usuario[ id=" + id + " ]";
    }
    
}
