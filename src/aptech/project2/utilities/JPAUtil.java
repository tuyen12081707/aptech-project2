/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Admin
 */
public class JPAUtil {

    private static EntityManagerFactory factory;
    private static JPAUtil instance;

    private JPAUtil() {

    }

    public static JPAUtil getInstance() {
        if (instance == null) {
            instance = new JPAUtil();
        }
        return instance;
    }

    public EntityManagerFactory getFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("aptech-project2PU");
        }
        return factory;
    }

    public EntityManager getEntityManager() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("aptech-project2PU");
        }
        return factory.createEntityManager();
    }

}
