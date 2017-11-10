/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Gerencia;

import Entity.Gerencia.Conta;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ContaDAO {

    private static ContaDAO instance;
    protected EntityManager entityManager;

    public static ContaDAO getInstance() {
        if (instance == null) {
            instance = new ContaDAO();
        }

        return instance;
    }

    private ContaDAO() {
        entityManager = Instance.getEntityManager();
    }
    
    public EntityManager getEntity() {
        return entityManager;
    }

    public Conta getById(final int id) {
        return entityManager.find(Conta.class, id);
    }

    public Conta getByNumber(String numero) {

        try {
            
            Query query = entityManager.createQuery("select c from Conta as c where c.numeroConta=:param", Conta.class);

            query.setParameter("param", numero);
            
            Object res = query.getSingleResult();

            return (Conta) res;
        } catch (Exception e) {
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    public List<Conta> findAll() {
        return entityManager.createQuery("FROM " + Conta.class.getName()).getResultList();
    }

    public boolean persist(Conta conta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(conta);
            entityManager.getTransaction().commit();
            entityManager.clear();
            
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    public void merge(Conta conta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(conta);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Conta conta) {
        try {
            entityManager.getTransaction().begin();
            conta = entityManager.find(Conta.class, conta.getId());
            entityManager.remove(conta);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Conta cliente = getById(id);
            remove(cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
