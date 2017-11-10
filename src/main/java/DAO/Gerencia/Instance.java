package DAO.Gerencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Instance {

    private static EntityManager entityManager = null;
    private static EntityManagerFactory factory = null;

    public static EntityManager getEntityManager() {
        factory = Persistence.createEntityManagerFactory("BancoMoneyMaker_GERPU");

        if (entityManager == null)
            entityManager = factory.createEntityManager();
        
        return entityManager;
    }
}
