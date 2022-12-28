/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service;

import aptech.project2.entities.Catalog;
import aptech.project2.entities.Product;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductService {
    boolean create(Product product) throws Exception;

    boolean update(Product product) throws Exception;

    boolean deleteById(int id) throws Exception;

    List<Product> findAll() throws Exception;
    
    Product findFirstProductByCatalog  (Catalog cat) throws Exception;
    
}
