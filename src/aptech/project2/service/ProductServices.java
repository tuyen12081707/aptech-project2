/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service;

import aptech.project2.dao.Product;
import aptech.project2.utilities.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author DQT
 */
public class ProductServices extends AbstractFacade<Product>{

    public ProductServices() {
        super(Product.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JPAUtil.getInstance().getEntityManager();
    }
    public static void main(String[] args) {
        Product p = new ProductServices().find(1);
        System.out.println("Catalog of product: " + p.getCatalogId().getName());
    }
}
