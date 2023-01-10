/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service;

import aptech.project2.dao.Product;
import aptech.project2.utilities.JPAUtil;
import aptech.project2.utilities.MD5Util;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DQT
 */
public class ProductServices {

    private static ProductServices instance;

    private Product product;

    private ProductServices(){}

    public static ProductServices getInstance() {
        if (instance == null) {
            instance = new ProductServices();
        }
        return instance;
    }

    public Product findProductByName(String name) {
        EntityManager em = null;

        try {
            em = JPAUtil.getInstance().getEntityManager();
            Query query = em.createNamedQuery("Product.findByName", Product.class);
            query.setParameter("name", name);
            Product pro = (Product) query.getSingleResult();
            return pro;
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

        Product pro = new ProductServices().findProductByName("c200");
        System.out.println("ALOALOALO: " + pro);
    }

    public void setProduct(Product p) {
        this.product = p;
    }
    
    public Product getProduct(){
        return product;
    }
    
}
