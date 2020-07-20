/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Usuarioempleador;

/**
 *
 * @author alejo
 */
@Stateless
public class UsuarioempleadorFacade extends AbstractFacade<Usuarioempleador> {

    @PersistenceContext(unitName = "ProyectoTelematicasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioempleadorFacade() {
        super(Usuarioempleador.class);
    }
    
}
