/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Declaracion;

/**
 *
 * @author alejo
 */
@Stateless
public class DeclaracionFacade extends AbstractFacade<Declaracion> {

    @PersistenceContext(unitName = "ProyectoTelematicasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeclaracionFacade() {
        super(Declaracion.class);
    }
    
}
