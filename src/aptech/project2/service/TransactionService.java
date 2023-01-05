/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service;

import aptech.project2.dao.Transaction;
import aptech.project2.dao.User;
import aptech.project2.utilities.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Admin
 */
public class TransactionService extends AbstractFacade<Transaction> {

    private static TransactionService instance;

    public static TransactionService getInstance() {
        if (instance == null) {
            instance = new TransactionService();
        }
        return instance;
    }

    public TransactionService() {
        super(Transaction.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JPAUtil.getInstance().getEntityManager();
    }

    public static void main(String[] args) {
        Transaction transaction = TransactionService.getInstance().find(1);
      
    }
}
