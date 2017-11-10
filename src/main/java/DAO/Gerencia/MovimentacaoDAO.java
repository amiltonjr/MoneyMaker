package DAO.Gerencia;

import Entity.Gerencia.Movimentacao;
import java.util.List;

import javax.persistence.EntityManager;

public class MovimentacaoDAO {

    private static MovimentacaoDAO instance;
    protected EntityManager entityManager;

    public static MovimentacaoDAO getInstance() {
        if (instance == null) {
            instance = new MovimentacaoDAO();
        }
        
        return instance;
    }

    private MovimentacaoDAO() {
        entityManager = Instance.getEntityManager();
    }
    
    public EntityManager getEntity() {
        return entityManager;
    }

    public Movimentacao getById(final int id) {
        return entityManager.find(Movimentacao.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Movimentacao> findAll() {
        return entityManager.createQuery("FROM " + Movimentacao.class.getName()).getResultList();
    }

    public boolean persist(Movimentacao mov) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(mov);
            entityManager.getTransaction().commit();
            entityManager.clear();
            
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    public void merge(Movimentacao mov) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(mov);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Movimentacao mov) {
        try {
            entityManager.getTransaction().begin();
//            mov = entityManager.find(Movimentacao.class, mov.getId());
            entityManager.remove(mov);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Movimentacao cliente = getById(id);
            remove(cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
