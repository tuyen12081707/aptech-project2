/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service;

import aptech.project2.dao.Catalog;
import aptech.project2.service.exceptions.NonexistentEntityException;
import aptech.project2.utilities.JPAUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Admin
 */
public class CatalogJpaController implements Serializable {

    private static CatalogJpaController instance;
    private EntityManagerFactory emf = null;

    private CatalogJpaController() {
        this.emf = JPAUtil.getInstance().getFactory();
    }

    public static CatalogJpaController getInstance() {
        if (instance == null) {
            instance = new CatalogJpaController();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Catalog catalog) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(catalog);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Catalog catalog) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            catalog = em.merge(catalog);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = catalog.getId();
                if (findCatalog(id) == null) {
                    throw new NonexistentEntityException("The catalog with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Catalog catalog;
            try {
                catalog = em.getReference(Catalog.class, id);
                catalog.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The catalog with id " + id + " no longer exists.", enfe);
            }
            em.remove(catalog);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Catalog> findCatalogEntities() {
        return findCatalogEntities(true, -1, -1);
    }

    public List<Catalog> findCatalogEntities(int maxResults, int firstResult) {
        return findCatalogEntities(false, maxResults, firstResult);
    }

    private List<Catalog> findCatalogEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Catalog.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Catalog findCatalog(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Catalog.class, id);
        } finally {
            em.close();
        }
    }

    public int getCatalogCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Catalog> rt = cq.from(Catalog.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
