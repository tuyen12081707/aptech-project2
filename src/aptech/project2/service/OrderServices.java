package aptech.project2.service;

import aptech.project2.model.Orders;
import aptech.project2.utilities.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DQT
 */
public class OrderServices {

    private static OrderServices instance;

    private Orders order;

    private OrderServices(){}

    public static OrderServices getInstance() {
        if (instance == null) {
            instance = new OrderServices();
        }
        return instance;
    }

    public Orders findOrderByOrderNo(String orderNo) {
        EntityManager em = null;

        try {
            em = JPAUtil.getInstance().getEntityManager();
            Query query = em.createNamedQuery("Orders.findByOrderNo", Orders.class);
            query.setParameter("orderNo", orderNo);
            Orders order = (Orders) query.getSingleResult();
            return order;
        } catch (Exception e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public static void main(String[] args) {
//        Product p = new ProductServices().find(1);
//        System.out.println("Catalog of product: " + p.getCatalogId().getName());

        Orders order = new OrderServices().findOrderByOrderNo("MA_NO_457862");
        System.out.println("ALOALOALO: " + order);
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    
    
}
