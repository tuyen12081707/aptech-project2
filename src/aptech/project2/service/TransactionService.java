/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service;

import aptech.project2.dao.Product;
import aptech.project2.dao.Transaction;
import aptech.project2.dao.User;
import aptech.project2.service.exceptions.NonexistentEntityException;
import aptech.project2.utilities.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

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

    private TransactionService() {
        super(Transaction.class);
    }

 public void delteById(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transaction transaction;
            try {
                transaction = em.getReference(Transaction.class, id);
                transaction.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transaction with id " + id + " no longer exists.", enfe);
            }
            em.remove(transaction);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return JPAUtil.getInstance().getEntityManager();
    }

    public static void main(String[] args) {
        Transaction transaction = TransactionService.getInstance().find(1);

    }

}
