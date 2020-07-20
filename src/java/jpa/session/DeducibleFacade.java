/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Deducible;

/**
 *
 * @author alejo
 */
@Stateless
public class DeducibleFacade extends AbstractFacade<Deducible> {

    @PersistenceContext(unitName = "ProyectoTelematicasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeducibleFacade() {
        super(Deducible.class);
    }
    
}
