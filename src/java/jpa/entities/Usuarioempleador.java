/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "usuarioempleador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarioempleador.findAll", query = "SELECT u FROM Usuarioempleador u")
    , @NamedQuery(name = "Usuarioempleador.findById", query = "SELECT u FROM Usuarioempleador u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarioempleador.findByTotalingresos", query = "SELECT u FROM Usuarioempleador u WHERE u.totalingresos = :totalingresos")
    , @NamedQuery(name = "Usuarioempleador.findByAnio", query = "SELECT u FROM Usuarioempleador u WHERE u.anio = :anio")})
public class Usuarioempleador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalingresos")
    private Double totalingresos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anio;
    @JoinColumn(name = "empleador_ruc", referencedColumnName = "ruc")
    @ManyToOne(optional = false)
    private Empleador empleadorRuc;
    @JoinColumn(name = "usuario_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuario usuarioCedula;

    public Usuarioempleador() {
    }

    public Usuarioempleador(Integer id) {
        this.id = id;
    }

    public Usuarioempleador(Integer id, Date anio) {
        this.id = id;
        this.anio = anio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalingresos() {
        return totalingresos;
    }

    public void setTotalingresos(Double totalingresos) {
        this.totalingresos = totalingresos;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public Empleador getEmpleadorRuc() {
        return empleadorRuc;
    }

    public void setEmpleadorRuc(Empleador empleadorRuc) {
        this.empleadorRuc = empleadorRuc;
    }

    public Usuario getUsuarioCedula() {
        return usuarioCedula;
    }

    public void setUsuarioCedula(Usuario usuarioCedula) {
        this.usuarioCedula = usuarioCedula;
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
        if (!(object instanceof Usuarioempleador)) {
            return false;
        }
        Usuarioempleador other = (Usuarioempleador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Usuarioempleador[ id=" + id + " ]";
    }
    
}
