/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service;

import aptech.project2.dao.User;
import aptech.project2.utilities.JPAUtil;
import aptech.project2.utilities.MD5Util;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author protu
 */
public class AuthService {
    private static AuthService instance;
    private User authUser;

    private AuthService() {
    }
       public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }   
        public User login(String username, String password) {
        EntityManager em = null;
        try {
            em = JPAUtil.getInstance().getEntityManager();
            Query query = em.createNamedQuery("User.login", User.class);
            query.setParameter("username", username);
            String pwdHash = MD5Util.encrypt(password);
            query.setParameter("password", pwdHash);
            User user = (User) query.getSingleResult();
            if (user != null) {
                this.setAuthUser(user);
            }
            return user;
        } catch(Exception e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean checkAuthen() {
        return authUser != null;
    }
    
    public User getAuthUser() {
        return authUser;
    }

    public void setAuthUser(User authUser) {
        this.authUser = authUser;
    }
}
