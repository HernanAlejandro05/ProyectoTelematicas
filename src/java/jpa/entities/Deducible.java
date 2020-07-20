/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "deducible")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deducible.findAll", query = "SELECT d FROM Deducible d")
    , @NamedQuery(name = "Deducible.findByCodigo", query = "SELECT d FROM Deducible d WHERE d.codigo = :codigo")
    , @NamedQuery(name = "Deducible.findByDescripcion", query = "SELECT d FROM Deducible d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "Deducible.findByCantidad", query = "SELECT d FROM Deducible d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Deducible.findByValordeduciblevivienda", query = "SELECT d FROM Deducible d WHERE d.valordeduciblevivienda = :valordeduciblevivienda")
    , @NamedQuery(name = "Deducible.findByValordeducibleeducacion", query = "SELECT d FROM Deducible d WHERE d.valordeducibleeducacion = :valordeducibleeducacion")
    , @NamedQuery(name = "Deducible.findByValordeduciblesalud", query = "SELECT d FROM Deducible d WHERE d.valordeduciblesalud = :valordeduciblesalud")
    , @NamedQuery(name = "Deducible.findByValordeduciblevestimenta", query = "SELECT d FROM Deducible d WHERE d.valordeduciblevestimenta = :valordeduciblevestimenta")
    , @NamedQuery(name = "Deducible.findByValordeduciblealimentacion", query = "SELECT d FROM Deducible d WHERE d.valordeduciblealimentacion = :valordeduciblealimentacion")})
public class Deducible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valordeduciblevivienda")
    private Double valordeduciblevivienda;
    @Column(name = "valordeducibleeducacion")
    private Double valordeducibleeducacion;
    @Column(name = "valordeduciblesalud")
    private Double valordeduciblesalud;
    @Column(name = "valordeduciblevestimenta")
    private Double valordeduciblevestimenta;
    @Column(name = "valordeduciblealimentacion")
    private Double valordeduciblealimentacion;
    @JoinColumn(name = "factura_numerofactura", referencedColumnName = "numerofactura")
    @ManyToOne(optional = false)
    private Factura facturaNumerofactura;

    public Deducible() {
    }

    public Deducible(Integer codigo) {
        this.codigo = codigo;
    }

    public Deducible(Integer codigo, String descripcion, int cantidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValordeduciblevivienda() {
        return valordeduciblevivienda;
    }

    public void setValordeduciblevivienda(Double valordeduciblevivienda) {
        this.valordeduciblevivienda = valordeduciblevivienda;
    }

    public Double getValordeducibleeducacion() {
        return valordeducibleeducacion;
    }

    public void setValordeducibleeducacion(Double valordeducibleeducacion) {
        this.valordeducibleeducacion = valordeducibleeducacion;
    }

    public Double getValordeduciblesalud() {
        return valordeduciblesalud;
    }

    public void setValordeduciblesalud(Double valordeduciblesalud) {
        this.valordeduciblesalud = valordeduciblesalud;
    }

    public Double getValordeduciblevestimenta() {
        return valordeduciblevestimenta;
    }

    public void setValordeduciblevestimenta(Double valordeduciblevestimenta) {
        this.valordeduciblevestimenta = valordeduciblevestimenta;
    }

    public Double getValordeduciblealimentacion() {
        return valordeduciblealimentacion;
    }

    public void setValordeduciblealimentacion(Double valordeduciblealimentacion) {
        this.valordeduciblealimentacion = valordeduciblealimentacion;
    }

    public Factura getFacturaNumerofactura() {
        return facturaNumerofactura;
    }

    public void setFacturaNumerofactura(Factura facturaNumerofactura) {
        this.facturaNumerofactura = facturaNumerofactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deducible)) {
            return false;
        }
        Deducible other = (Deducible) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Deducible[ codigo=" + codigo + " ]";
    }
    
}
