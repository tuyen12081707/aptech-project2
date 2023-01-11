/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service;

import aptech.project2.model.Catalog;
import aptech.project2.utilities.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author DQT
 */
public class CatalogService extends AbstractFacade<Catalog>{

    private static CatalogService instance;
    
    public static CatalogService getInstance(){
        if (instance == null){
            instance = new CatalogService();
        }
        return instance;
    }
    
    private CatalogService() {
        super(Catalog.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JPAUtil.getInstance().getEntityManager();
    }
    public static void main(String[] args) {
        Catalog c = CatalogService.getInstance().find(1);
        for (aptech.project2.model.Product p : c.getProductCollection()){
            System.out.println("Product name: " + p.getName());
        }
    }
}
