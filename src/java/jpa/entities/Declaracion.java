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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "declaracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Declaracion.findAll", query = "SELECT d FROM Declaracion d")
    , @NamedQuery(name = "Declaracion.findByCodigo", query = "SELECT d FROM Declaracion d WHERE d.codigo = :codigo")
    , @NamedQuery(name = "Declaracion.findByAnio", query = "SELECT d FROM Declaracion d WHERE d.anio = :anio")
    , @NamedQuery(name = "Declaracion.findByFraccionbasica", query = "SELECT d FROM Declaracion d WHERE d.fraccionbasica = :fraccionbasica")
    , @NamedQuery(name = "Declaracion.findByExceso", query = "SELECT d FROM Declaracion d WHERE d.exceso = :exceso")
    , @NamedQuery(name = "Declaracion.findByImpuestofb", query = "SELECT d FROM Declaracion d WHERE d.impuestofb = :impuestofb")
    , @NamedQuery(name = "Declaracion.findByImpuestofe", query = "SELECT d FROM Declaracion d WHERE d.impuestofe = :impuestofe")})
public class Declaracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    private int anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fraccionbasica")
    private double fraccionbasica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exceso")
    private double exceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuestofb")
    private double impuestofb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuestofe")
    private double impuestofe;
    @JoinColumn(name = "usuario_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuario usuarioCedula;

    public Declaracion() {
    }

    public Declaracion(Integer codigo) {
        this.codigo = codigo;
    }

    public Declaracion(Integer codigo, int anio, double fraccionbasica, double exceso, double impuestofb, double impuestofe) {
        this.codigo = codigo;
        this.anio = anio;
        this.fraccionbasica = fraccionbasica;
        this.exceso = exceso;
        this.impuestofb = impuestofb;
        this.impuestofe = impuestofe;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getFraccionbasica() {
        return fraccionbasica;
    }

    public void setFraccionbasica(double fraccionbasica) {
        this.fraccionbasica = fraccionbasica;
    }

    public double getExceso() {
        return exceso;
    }

    public void setExceso(double exceso) {
        this.exceso = exceso;
    }

    public double getImpuestofb() {
        return impuestofb;
    }

    public void setImpuestofb(double impuestofb) {
        this.impuestofb = impuestofb;
    }

    public double getImpuestofe() {
        return impuestofe;
    }

    public void setImpuestofe(double impuestofe) {
        this.impuestofe = impuestofe;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Declaracion)) {
            return false;
        }
        Declaracion other = (Declaracion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Declaracion[ codigo=" + codigo + " ]";
    }
    
}
