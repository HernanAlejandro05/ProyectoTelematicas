/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByNumerofactura", query = "SELECT f FROM Factura f WHERE f.numerofactura = :numerofactura")
    , @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Factura.findByValor", query = "SELECT f FROM Factura f WHERE f.valor = :valor")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerofactura")
    private Integer numerofactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @JoinColumn(name = "proveedor_ruc", referencedColumnName = "ruc")
    @ManyToOne(optional = false)
    private Proveedor proveedorRuc;
    @JoinColumn(name = "usuario_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuario usuarioCedula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaNumerofactura")
    private Collection<Deducible> deducibleCollection;

    public Factura() {
    }

    public Factura(Integer numerofactura) {
        this.numerofactura = numerofactura;
    }

    public Factura(Integer numerofactura, Date fecha, double valor) {
        this.numerofactura = numerofactura;
        this.fecha = fecha;
        this.valor = valor;
    }

    public Integer getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(Integer numerofactura) {
        this.numerofactura = numerofactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Proveedor getProveedorRuc() {
        return proveedorRuc;
    }

    public void setProveedorRuc(Proveedor proveedorRuc) {
        this.proveedorRuc = proveedorRuc;
    }

    public Usuario getUsuarioCedula() {
        return usuarioCedula;
    }

    public void setUsuarioCedula(Usuario usuarioCedula) {
        this.usuarioCedula = usuarioCedula;
    }

    @XmlTransient
    public Collection<Deducible> getDeducibleCollection() {
        return deducibleCollection;
    }

    public void setDeducibleCollection(Collection<Deducible> deducibleCollection) {
        this.deducibleCollection = deducibleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerofactura != null ? numerofactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.numerofactura == null && other.numerofactura != null) || (this.numerofactura != null && !this.numerofactura.equals(other.numerofactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Factura[ numerofactura=" + numerofactura + " ]";
    }
    
}
