/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Cidade;
import br.data.entity.Estado;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author evee
 */
public class CrudEstado extends AbstractCrud<Estado> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudEstado() {
        super(Estado.class);
    }

    public Estado findByUf(String uf) {
        Query query = getEntityManager().createNativeQuery("SELECT * FROM estado WHERE uf = '"+ uf+"'", Estado.class);
        Object singleResult = query.getSingleResult();
        return (Estado) singleResult;
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        }
        return em;
    }

}
