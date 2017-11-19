package DAO.Gerencia;

import Entity.Gerencia.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class ClienteDAO {

    private static ClienteDAO instance;
    protected EntityManager entityManager;

    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }

        return instance;
    }

    private ClienteDAO() {
        entityManager = Instance.getEntityManager();
    }
    
    public EntityManager getEntity() {
        return entityManager;
    }
    
    public Cliente getById(final int id) {
        return entityManager.find(Cliente.class, id);
    }

    public Cliente getByCPF(String numero) {

        try {
            Query query = entityManager.createQuery("select c from Cliente as c where c.cpf=:param", Cliente.class);

            query.setParameter("param", numero);

            Object res = query.getSingleResult();

            return (Cliente) res;
        } catch (Exception e) {
            return null;
        }
    }

    public Cliente getByNome(String numero) {
        try {

            Query query = entityManager.createQuery("select c from Cliente as c where c.nome=:param", Cliente.class);

            query.setParameter("param", numero);

            Object res = query.getSingleResult();

            return (Cliente) res;
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> findAll() {
        return entityManager.createQuery("FROM Cliente").getResultList();
    }

    public boolean persist(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
            entityManager.clear();
            
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    public void merge(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            cliente = entityManager.find(Cliente.class, cliente.getId());
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Cliente cliente = getById(id);
            remove(cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
