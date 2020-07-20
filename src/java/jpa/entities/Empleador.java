/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
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
 * @author alejo
 */
@Entity
@Table(name = "empleador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleador.findAll", query = "SELECT e FROM Empleador e")
    , @NamedQuery(name = "Empleador.findByRuc", query = "SELECT e FROM Empleador e WHERE e.ruc = :ruc")
    , @NamedQuery(name = "Empleador.findByNombre", query = "SELECT e FROM Empleador e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleador.findByRazon", query = "SELECT e FROM Empleador e WHERE e.razon = :razon")})
public class Empleador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "razon")
    private String razon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadorRuc")
    private Collection<Usuarioempleador> usuarioempleadorCollection;

    public Empleador() {
    }

    public Empleador(String ruc) {
        this.ruc = ruc;
    }

    public Empleador(String ruc, String nombre, String razon) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.razon = razon;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    @XmlTransient
    public Collection<Usuarioempleador> getUsuarioempleadorCollection() {
        return usuarioempleadorCollection;
    }

    public void setUsuarioempleadorCollection(Collection<Usuarioempleador> usuarioempleadorCollection) {
        this.usuarioempleadorCollection = usuarioempleadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruc != null ? ruc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleador)) {
            return false;
        }
        Empleador other = (Empleador) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Empleador[ ruc=" + ruc + " ]";
    }
    
}
