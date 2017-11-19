package DAO.Gerencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class Instance {

    private static EntityManager entityManager = null;
    private static EntityManagerFactory factory = null;

    public static EntityManager getEntityManager() {
        try {
            factory = Persistence.createEntityManagerFactory("BancoMoneyMaker_GERPU");

            if (entityManager == null)
                entityManager = factory.createEntityManager();

            return entityManager;
        } catch (Exception e) {
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados!", "Banco MoneyMaker", JOptionPane.ERROR_MESSAGE);
            
            System.exit(1);
        }
        
        return null;
    }
}
