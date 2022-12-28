/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service;

import aptech.project2.entities.Order;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface OrderService {
        boolean create(Order order) throws Exception;

    boolean update(Order order) throws Exception;

    boolean deleteById(int id) throws Exception;
    
    Order findById(int id)throws Exception;
    
    List<Order> findAll() throws Exception;
    
    
}
