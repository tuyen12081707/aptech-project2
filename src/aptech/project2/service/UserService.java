/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service;

import aptech.project2.model.Transaction;
import aptech.project2.model.User;
import aptech.project2.utilities.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Admin
 */
public class UserService extends AbstractFacade<User> {

    private static UserService instance;

    private UserService() {
        super(User.class);
    }

    public static UserService getInstace() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    @Override
    protected EntityManager getEntityManager() {
        return JPAUtil.getInstance().getEntityManager();
    }

    public static void main(String[] args) {
        User u = UserService.getInstace().find(1);
        for (Transaction t : u.getTransactionCollection()) {
            System.out.println("name" + t.getUserId().getName() + " va "+ t.getUserId().getId());
        }
    }

}
